/*******************************************************************************
 * Copyright (c) 2009, A. Kaufmann and Elexis
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    A. Kaufmann - initial implementation
 *
 *******************************************************************************/

package com.hilotec.elexis.pluginstatistiken.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.hilotec.elexis.pluginstatistiken.schnittstelle.IDatenquelle;

import ch.elexis.core.data.activator.CoreHub;
import ch.elexis.core.data.util.Extensions;

/**
 * Parser fuer die Konfiguration der Abfragen
 *
 * @author Antoine Kaufmann
 */
public class Konfiguration {
	public static final String STATISTIKEN_FILENAME = "statistiken.xml"; //$NON-NLS-1$
	public static final String ELEM_QUERY = "query"; //$NON-NLS-1$
	public static final String ELEM_FROM = "from"; //$NON-NLS-1$
	public static final String ELEM_COLS = "cols"; //$NON-NLS-1$
	public static final String ELEM_WHERE = "where"; //$NON-NLS-1$
	public static final String ELEM_JOIN = "join"; //$NON-NLS-1$
	public static final String ATTR_TITLE = "title"; //$NON-NLS-1$
	public static final String ATTR_NAME = "name"; //$NON-NLS-1$
	public static final String ATTR_SOURCE = "source"; //$NON-NLS-1$
	public static final String ATTR_TABLE = "table"; //$NON-NLS-1$
	public static final String ATTR_AS = "as"; //$NON-NLS-1$
	public static final String ATTR_TYPE = "type"; //$NON-NLS-1$

	public static final String DATASOURCE_EXT = "com.hilotec.elexis.pluginstatistiken.Datenquelle"; //$NON-NLS-1$

	Logger log = LoggerFactory.getLogger(getClass());
	ArrayList<KonfigurationQuery> queries;
	HashMap<String, IDatenquelle> datenquellen;

	private static Konfiguration the_one_and_only_instance = null;

	public static Konfiguration getInstance() {
		if (the_one_and_only_instance == null) {
			the_one_and_only_instance = new Konfiguration();
		}
		return the_one_and_only_instance;
	}

	/**
	 * Das ist ein Singleton, also muss der Konstruktor privat sein
	 */
	private Konfiguration() {
		queries = new ArrayList<KonfigurationQuery>();
		datenquellen = new HashMap<String, IDatenquelle>();
		datenquellenInitialisieren();
		readFromXML(CoreHub.getWritableUserDir() + File.separator + STATISTIKEN_FILENAME);
	}

	/**
	 * XML-Datei mit den Definitionen der Abfragen einlesen und parsen
	 *
	 * @param path Pfad zur Datei
	 */
	private void readFromXML(String path) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc;

		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(new FileInputStream(path));

			Element rootel = doc.getDocumentElement();
			NodeList ql = rootel.getElementsByTagName(ELEM_QUERY);
			for (int i = 0; i < ql.getLength(); i++) {
				Node qn = ql.item(i);
				if (qn.getNodeType() != Node.ELEMENT_NODE) {
					continue;
				}

				Element qe = (Element) qn;
				KonfigurationQuery kq = new KonfigurationQuery(qe.getAttribute(ATTR_TITLE));

				Element frome = (Element) qe.getElementsByTagName(ELEM_FROM).item(0);
				kq.setFrom(frome.getAttribute(ATTR_TABLE), frome.getAttribute(ATTR_AS));

				// Joins verabeiten
				NodeList jl = qe.getElementsByTagName(ELEM_JOIN);
				for (int j = 0; j < jl.getLength(); j++) {
					Element je = (Element) jl.item(j);

					// Bedingunsoperation suchen
					KonfigurationWhere where = null;
					NodeList jchildren = je.getChildNodes();
					for (int k = 0; k < jchildren.getLength(); k++) {
						if (jchildren.item(k).getNodeType() == Node.ELEMENT_NODE) {
							where = new KonfigurationWhere((Element) jchildren.item(k));
							break;
						}
					}

					kq.addJoin(new KonfigurationQuery.Join(je.getAttribute(ATTR_TABLE), je.getAttribute(ATTR_AS), where,
							KonfigurationQuery.Join.JType.JOIN_INNER));
				}

				// Spaltendefinitionen
				Element colse = (Element) qe.getElementsByTagName(ELEM_COLS).item(0);
				Element wheree;
				NodeList wel = qe.getElementsByTagName(ELEM_WHERE);
				if (wel == null || wel.getLength() == 0) {
					wheree = null;
				} else {
					wheree = (Element) wel.item(0);
				}

				NodeList colsList = colse.getChildNodes();
				for (int j = 0; j < colsList.getLength(); j++) {
					Node cn = colsList.item(j);
					if (cn.getNodeType() != Node.ELEMENT_NODE) {
						continue;
					}
					Element ce = (Element) cn;

					kq.addCol(ce.getAttribute(ATTR_NAME), ce.getAttribute(ATTR_SOURCE));
				}

				// Where-Klausel
				if (wheree != null) {
					Element whereOp = null;
					NodeList wl = wheree.getChildNodes();
					for (int j = 0; j < wl.getLength(); j++) {
						if (wl.item(j).getNodeType() == Node.ELEMENT_NODE) {
							whereOp = (Element) wl.item(j);
							break;
						}
					}
					KonfigurationWhere where = new KonfigurationWhere(whereOp);
					kq.setWhere(where);
				}
				queries.add(kq);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Einlesen der XML-Datei felgeschlagen: " + e.getMessage()); //$NON-NLS-1$
			MessageDialog.openError(Display.getDefault().getActiveShell(), "Hilotec Pluginstatistiken Fehler",
					"Einlesen der XML-Datei felgeschlagen: " + e.getMessage());
		}
	}

	private void datenquellenInitialisieren() {
		for (IConfigurationElement ic : Extensions.getExtensions(DATASOURCE_EXT)) {
			try {
				IDatenquelle dq;
				dq = (IDatenquelle) ic.createExecutableExtension("class"); //$NON-NLS-1$
				datenquellen.put(dq.getName(), dq);
			} catch (CoreException ce) {
				log.error("Initialisieren der Datenquelle " + ic.getAttribute("name") + " fehlgeschlagen: " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						+ ce.getMessage());
				MessageDialog.openError(Display.getDefault().getActiveShell(), "Hilotec Pluginstatistiken Fehler",
						"Initialisieren der Datenquelle " + ic.getAttribute("name") + " fehlgeschlagen: " //$NON-NLS-2$
								+ ce.getMessage());
			}
		}
	}

	/**
	 * Alle Abfragen in dieser Konfiguration zurzueckgeben
	 */
	public List<KonfigurationQuery> getQueries() {
		return queries;
	}

	/**
	 * Bestimmte Datenquelle holen
	 */
	public IDatenquelle getDatenquelle(String name) {
		return datenquellen.get(name);
	}
}
