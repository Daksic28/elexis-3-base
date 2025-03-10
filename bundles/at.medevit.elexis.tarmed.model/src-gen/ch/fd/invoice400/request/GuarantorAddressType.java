//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.18 at 01:35:39 PM CET 
//

package ch.fd.invoice400.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for guarantorAddressType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="guarantorAddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="company" type="{http://www.xmlData.ch/xmlInvoice/XSD}guarantorCompanyType"/>
 *         &lt;element name="person" type="{http://www.xmlData.ch/xmlInvoice/XSD}guarantorPersonType"/>
 *       &lt;/choice>
 *       &lt;attribute name="unique_id" type="{http://www.xmlData.ch/xmlInvoice/XSD}ssn13PartyType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guarantorAddressType", propOrder = {
	"company", "person"
})
public class GuarantorAddressType {
	
	protected GuarantorCompanyType company;
	protected GuarantorPersonType person;
	@XmlAttribute(name = "unique_id")
	protected String uniqueId;
	
	/**
	 * Gets the value of the company property.
	 * 
	 * @return possible object is {@link GuarantorCompanyType }
	 * 
	 */
	public GuarantorCompanyType getCompany(){
		return company;
	}
	
	/**
	 * Sets the value of the company property.
	 * 
	 * @param value
	 *            allowed object is {@link GuarantorCompanyType }
	 * 
	 */
	public void setCompany(GuarantorCompanyType value){
		this.company = value;
	}
	
	/**
	 * Gets the value of the person property.
	 * 
	 * @return possible object is {@link GuarantorPersonType }
	 * 
	 */
	public GuarantorPersonType getPerson(){
		return person;
	}
	
	/**
	 * Sets the value of the person property.
	 * 
	 * @param value
	 *            allowed object is {@link GuarantorPersonType }
	 * 
	 */
	public void setPerson(GuarantorPersonType value){
		this.person = value;
	}
	
	/**
	 * Gets the value of the uniqueId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUniqueId(){
		return uniqueId;
	}
	
	/**
	 * Sets the value of the uniqueId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUniqueId(String value){
		this.uniqueId = value;
	}
	
}
