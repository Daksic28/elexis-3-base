package org.hl7.v3;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for POCD_MT000040.Procedure complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="POCD_MT000040.Procedure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="realmCode" type="{urn:hl7-org:v3}CS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="typeId" type="{urn:hl7-org:v3}POCD_MT000040.InfrastructureRoot.typeId" minOccurs="0"/>
 *         &lt;element name="templateId" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}CD" minOccurs="0"/>
 *         &lt;element name="text" type="{urn:hl7-org:v3}ED" minOccurs="0"/>
 *         &lt;element name="statusCode" type="{urn:hl7-org:v3}CS" minOccurs="0"/>
 *         &lt;element name="effectiveTime" type="{urn:hl7-org:v3}IVL_TS" minOccurs="0"/>
 *         &lt;element name="priorityCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;element name="languageCode" type="{urn:hl7-org:v3}CS" minOccurs="0"/>
 *         &lt;element name="methodCode" type="{urn:hl7-org:v3}CE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="approachSiteCode" type="{urn:hl7-org:v3}CD" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="targetSiteCode" type="{urn:hl7-org:v3}CD" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subject" type="{urn:hl7-org:v3}POCD_MT000040.Subject" minOccurs="0"/>
 *         &lt;element name="specimen" type="{urn:hl7-org:v3}POCD_MT000040.Specimen" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="performer" type="{urn:hl7-org:v3}POCD_MT000040.Performer2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="author" type="{urn:hl7-org:v3}POCD_MT000040.Author" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="informant" type="{urn:hl7-org:v3}POCD_MT000040.Informant12" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="participant" type="{urn:hl7-org:v3}POCD_MT000040.Participant2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="entryRelationship" type="{urn:hl7-org:v3}POCD_MT000040.EntryRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reference" type="{urn:hl7-org:v3}POCD_MT000040.Reference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="precondition" type="{urn:hl7-org:v3}POCD_MT000040.Precondition" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}ActClass" />
 *       &lt;attribute name="moodCode" use="required" type="{urn:hl7-org:v3}x_DocumentProcedureMood" />
 *       &lt;attribute name="negationInd" type="{urn:hl7-org:v3}bl" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.Procedure", propOrder = { "realmCode", "typeId", "templateId", "id", "code", "text",
		"statusCode", "effectiveTime", "priorityCode", "languageCode", "methodCode", "approachSiteCode",
		"targetSiteCode", "subject", "specimen", "performer", "author", "informant", "participant", "entryRelationship",
		"reference", "precondition" })
public class POCDMT000040Procedure {

	protected List<CS> realmCode;
	protected POCDMT000040InfrastructureRootTypeId typeId;
	protected List<II> templateId;
	protected List<II> id;
	protected CD code;
	protected ED text;
	protected CS statusCode;
	protected IVLTS effectiveTime;
	protected CE priorityCode;
	protected CS languageCode;
	protected List<CE> methodCode;
	protected List<CD> approachSiteCode;
	protected List<CD> targetSiteCode;
	protected POCDMT000040Subject subject;
	protected List<POCDMT000040Specimen> specimen;
	protected List<POCDMT000040Performer2> performer;
	protected List<POCDMT000040Author> author;
	protected List<POCDMT000040Informant12> informant;
	protected List<POCDMT000040Participant2> participant;
	protected List<POCDMT000040EntryRelationship> entryRelationship;
	protected List<POCDMT000040Reference> reference;
	protected List<POCDMT000040Precondition> precondition;
	@XmlAttribute
	protected List<String> nullFlavor;
	@XmlAttribute(required = true)
	protected List<String> classCode;
	@XmlAttribute(required = true)
	protected XDocumentProcedureMood moodCode;
	@XmlAttribute
	protected Boolean negationInd;

	/**
	 * Gets the value of the realmCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the realmCode property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getRealmCode().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link CS }
	 *
	 *
	 */
	public List<CS> getRealmCode() {
		if (realmCode == null) {
			realmCode = new ArrayList<CS>();
		}
		return this.realmCode;
	}

	/**
	 * Gets the value of the typeId property.
	 *
	 * @return possible object is {@link POCDMT000040InfrastructureRootTypeId }
	 *
	 */
	public POCDMT000040InfrastructureRootTypeId getTypeId() {
		return typeId;
	}

	/**
	 * Sets the value of the typeId property.
	 *
	 * @param value allowed object is {@link POCDMT000040InfrastructureRootTypeId }
	 *
	 */
	public void setTypeId(POCDMT000040InfrastructureRootTypeId value) {
		this.typeId = value;
	}

	/**
	 * Gets the value of the templateId property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the templateId property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getTemplateId().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link II }
	 *
	 *
	 */
	public List<II> getTemplateId() {
		if (templateId == null) {
			templateId = new ArrayList<II>();
		}
		return this.templateId;
	}

	/**
	 * Gets the value of the id property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the id property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getId().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link II }
	 *
	 *
	 */
	public List<II> getId() {
		if (id == null) {
			id = new ArrayList<II>();
		}
		return this.id;
	}

	/**
	 * Gets the value of the code property.
	 *
	 * @return possible object is {@link CD }
	 *
	 */
	public CD getCode() {
		return code;
	}

	/**
	 * Sets the value of the code property.
	 *
	 * @param value allowed object is {@link CD }
	 *
	 */
	public void setCode(CD value) {
		this.code = value;
	}

	/**
	 * Gets the value of the text property.
	 *
	 * @return possible object is {@link ED }
	 *
	 */
	public ED getText() {
		return text;
	}

	/**
	 * Sets the value of the text property.
	 *
	 * @param value allowed object is {@link ED }
	 *
	 */
	public void setText(ED value) {
		this.text = value;
	}

	/**
	 * Gets the value of the statusCode property.
	 *
	 * @return possible object is {@link CS }
	 *
	 */
	public CS getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the value of the statusCode property.
	 *
	 * @param value allowed object is {@link CS }
	 *
	 */
	public void setStatusCode(CS value) {
		this.statusCode = value;
	}

	/**
	 * Gets the value of the effectiveTime property.
	 *
	 * @return possible object is {@link IVLTS }
	 *
	 */
	public IVLTS getEffectiveTime() {
		return effectiveTime;
	}

	/**
	 * Sets the value of the effectiveTime property.
	 *
	 * @param value allowed object is {@link IVLTS }
	 *
	 */
	public void setEffectiveTime(IVLTS value) {
		this.effectiveTime = value;
	}

	/**
	 * Gets the value of the priorityCode property.
	 *
	 * @return possible object is {@link CE }
	 *
	 */
	public CE getPriorityCode() {
		return priorityCode;
	}

	/**
	 * Sets the value of the priorityCode property.
	 *
	 * @param value allowed object is {@link CE }
	 *
	 */
	public void setPriorityCode(CE value) {
		this.priorityCode = value;
	}

	/**
	 * Gets the value of the languageCode property.
	 *
	 * @return possible object is {@link CS }
	 *
	 */
	public CS getLanguageCode() {
		return languageCode;
	}

	/**
	 * Sets the value of the languageCode property.
	 *
	 * @param value allowed object is {@link CS }
	 *
	 */
	public void setLanguageCode(CS value) {
		this.languageCode = value;
	}

	/**
	 * Gets the value of the methodCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the methodCode property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getMethodCode().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link CE }
	 *
	 *
	 */
	public List<CE> getMethodCode() {
		if (methodCode == null) {
			methodCode = new ArrayList<CE>();
		}
		return this.methodCode;
	}

	/**
	 * Gets the value of the approachSiteCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the approachSiteCode property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getApproachSiteCode().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link CD }
	 *
	 *
	 */
	public List<CD> getApproachSiteCode() {
		if (approachSiteCode == null) {
			approachSiteCode = new ArrayList<CD>();
		}
		return this.approachSiteCode;
	}

	/**
	 * Gets the value of the targetSiteCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the targetSiteCode property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getTargetSiteCode().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link CD }
	 *
	 *
	 */
	public List<CD> getTargetSiteCode() {
		if (targetSiteCode == null) {
			targetSiteCode = new ArrayList<CD>();
		}
		return this.targetSiteCode;
	}

	/**
	 * Gets the value of the subject property.
	 *
	 * @return possible object is {@link POCDMT000040Subject }
	 *
	 */
	public POCDMT000040Subject getSubject() {
		return subject;
	}

	/**
	 * Sets the value of the subject property.
	 *
	 * @param value allowed object is {@link POCDMT000040Subject }
	 *
	 */
	public void setSubject(POCDMT000040Subject value) {
		this.subject = value;
	}

	/**
	 * Gets the value of the specimen property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the specimen property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getSpecimen().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040Specimen }
	 *
	 *
	 */
	public List<POCDMT000040Specimen> getSpecimen() {
		if (specimen == null) {
			specimen = new ArrayList<POCDMT000040Specimen>();
		}
		return this.specimen;
	}

	/**
	 * Gets the value of the performer property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the performer property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getPerformer().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040Performer2 }
	 *
	 *
	 */
	public List<POCDMT000040Performer2> getPerformer() {
		if (performer == null) {
			performer = new ArrayList<POCDMT000040Performer2>();
		}
		return this.performer;
	}

	/**
	 * Gets the value of the author property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the author property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getAuthor().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040Author }
	 *
	 *
	 */
	public List<POCDMT000040Author> getAuthor() {
		if (author == null) {
			author = new ArrayList<POCDMT000040Author>();
		}
		return this.author;
	}

	/**
	 * Gets the value of the informant property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the informant property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getInformant().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040Informant12 }
	 *
	 *
	 */
	public List<POCDMT000040Informant12> getInformant() {
		if (informant == null) {
			informant = new ArrayList<POCDMT000040Informant12>();
		}
		return this.informant;
	}

	/**
	 * Gets the value of the participant property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the participant property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getParticipant().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040Participant2 }
	 *
	 *
	 */
	public List<POCDMT000040Participant2> getParticipant() {
		if (participant == null) {
			participant = new ArrayList<POCDMT000040Participant2>();
		}
		return this.participant;
	}

	/**
	 * Gets the value of the entryRelationship property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the entryRelationship property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getEntryRelationship().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040EntryRelationship }
	 *
	 *
	 */
	public List<POCDMT000040EntryRelationship> getEntryRelationship() {
		if (entryRelationship == null) {
			entryRelationship = new ArrayList<POCDMT000040EntryRelationship>();
		}
		return this.entryRelationship;
	}

	/**
	 * Gets the value of the reference property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the reference property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getReference().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040Reference }
	 *
	 *
	 */
	public List<POCDMT000040Reference> getReference() {
		if (reference == null) {
			reference = new ArrayList<POCDMT000040Reference>();
		}
		return this.reference;
	}

	/**
	 * Gets the value of the precondition property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the precondition property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getPrecondition().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link POCDMT000040Precondition }
	 *
	 *
	 */
	public List<POCDMT000040Precondition> getPrecondition() {
		if (precondition == null) {
			precondition = new ArrayList<POCDMT000040Precondition>();
		}
		return this.precondition;
	}

	/**
	 * Gets the value of the nullFlavor property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the nullFlavor property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getNullFlavor().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 *
	 *
	 */
	public List<String> getNullFlavor() {
		if (nullFlavor == null) {
			nullFlavor = new ArrayList<String>();
		}
		return this.nullFlavor;
	}

	/**
	 * Gets the value of the classCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the classCode property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getClassCode().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 *
	 *
	 */
	public List<String> getClassCode() {
		if (classCode == null) {
			classCode = new ArrayList<String>();
		}
		return this.classCode;
	}

	/**
	 * Gets the value of the moodCode property.
	 *
	 * @return possible object is {@link XDocumentProcedureMood }
	 *
	 */
	public XDocumentProcedureMood getMoodCode() {
		return moodCode;
	}

	/**
	 * Sets the value of the moodCode property.
	 *
	 * @param value allowed object is {@link XDocumentProcedureMood }
	 *
	 */
	public void setMoodCode(XDocumentProcedureMood value) {
		this.moodCode = value;
	}

	/**
	 * Gets the value of the negationInd property.
	 *
	 * @return possible object is {@link Boolean }
	 *
	 */
	public Boolean isNegationInd() {
		return negationInd;
	}

	/**
	 * Sets the value of the negationInd property.
	 *
	 * @param value allowed object is {@link Boolean }
	 *
	 */
	public void setNegationInd(Boolean value) {
		this.negationInd = value;
	}

}
