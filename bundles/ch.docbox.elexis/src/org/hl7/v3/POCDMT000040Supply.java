package org.hl7.v3;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for POCD_MT000040.Supply complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="POCD_MT000040.Supply">
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
 *         &lt;element name="effectiveTime" type="{urn:hl7-org:v3}SXCM_TS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="priorityCode" type="{urn:hl7-org:v3}CE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="repeatNumber" type="{urn:hl7-org:v3}IVL_INT" minOccurs="0"/>
 *         &lt;element name="independentInd" type="{urn:hl7-org:v3}BL" minOccurs="0"/>
 *         &lt;element name="quantity" type="{urn:hl7-org:v3}PQ" minOccurs="0"/>
 *         &lt;element name="expectedUseTime" type="{urn:hl7-org:v3}IVL_TS" minOccurs="0"/>
 *         &lt;element name="subject" type="{urn:hl7-org:v3}POCD_MT000040.Subject" minOccurs="0"/>
 *         &lt;element name="specimen" type="{urn:hl7-org:v3}POCD_MT000040.Specimen" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="product" type="{urn:hl7-org:v3}POCD_MT000040.Product" minOccurs="0"/>
 *         &lt;element name="performer" type="{urn:hl7-org:v3}POCD_MT000040.Performer2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="author" type="{urn:hl7-org:v3}POCD_MT000040.Author" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="informant" type="{urn:hl7-org:v3}POCD_MT000040.Informant12" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="participant" type="{urn:hl7-org:v3}POCD_MT000040.Participant2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="entryRelationship" type="{urn:hl7-org:v3}POCD_MT000040.EntryRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reference" type="{urn:hl7-org:v3}POCD_MT000040.Reference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="precondition" type="{urn:hl7-org:v3}POCD_MT000040.Precondition" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}ActClassSupply" fixed="SPLY" />
 *       &lt;attribute name="moodCode" use="required" type="{urn:hl7-org:v3}x_DocumentSubstanceMood" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000040.Supply", propOrder = { "realmCode", "typeId", "templateId", "id", "code", "text",
		"statusCode", "effectiveTime", "priorityCode", "repeatNumber", "independentInd", "quantity", "expectedUseTime",
		"subject", "specimen", "product", "performer", "author", "informant", "participant", "entryRelationship",
		"reference", "precondition" })
public class POCDMT000040Supply {

	protected List<CS> realmCode;
	protected POCDMT000040InfrastructureRootTypeId typeId;
	protected List<II> templateId;
	protected List<II> id;
	protected CD code;
	protected ED text;
	protected CS statusCode;
	protected List<SXCMTS> effectiveTime;
	protected List<CE> priorityCode;
	protected IVLINT repeatNumber;
	protected BL independentInd;
	protected PQ quantity;
	protected IVLTS expectedUseTime;
	protected POCDMT000040Subject subject;
	protected List<POCDMT000040Specimen> specimen;
	protected POCDMT000040Product product;
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
	protected ActClassSupply classCode;
	@XmlAttribute(required = true)
	protected XDocumentSubstanceMood moodCode;

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
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the effectiveTime property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getEffectiveTime().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link SXCMTS }
	 *
	 *
	 */
	public List<SXCMTS> getEffectiveTime() {
		if (effectiveTime == null) {
			effectiveTime = new ArrayList<SXCMTS>();
		}
		return this.effectiveTime;
	}

	/**
	 * Gets the value of the priorityCode property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the priorityCode property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getPriorityCode().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link CE }
	 *
	 *
	 */
	public List<CE> getPriorityCode() {
		if (priorityCode == null) {
			priorityCode = new ArrayList<CE>();
		}
		return this.priorityCode;
	}

	/**
	 * Gets the value of the repeatNumber property.
	 *
	 * @return possible object is {@link IVLINT }
	 *
	 */
	public IVLINT getRepeatNumber() {
		return repeatNumber;
	}

	/**
	 * Sets the value of the repeatNumber property.
	 *
	 * @param value allowed object is {@link IVLINT }
	 *
	 */
	public void setRepeatNumber(IVLINT value) {
		this.repeatNumber = value;
	}

	/**
	 * Gets the value of the independentInd property.
	 *
	 * @return possible object is {@link BL }
	 *
	 */
	public BL getIndependentInd() {
		return independentInd;
	}

	/**
	 * Sets the value of the independentInd property.
	 *
	 * @param value allowed object is {@link BL }
	 *
	 */
	public void setIndependentInd(BL value) {
		this.independentInd = value;
	}

	/**
	 * Gets the value of the quantity property.
	 *
	 * @return possible object is {@link PQ }
	 *
	 */
	public PQ getQuantity() {
		return quantity;
	}

	/**
	 * Sets the value of the quantity property.
	 *
	 * @param value allowed object is {@link PQ }
	 *
	 */
	public void setQuantity(PQ value) {
		this.quantity = value;
	}

	/**
	 * Gets the value of the expectedUseTime property.
	 *
	 * @return possible object is {@link IVLTS }
	 *
	 */
	public IVLTS getExpectedUseTime() {
		return expectedUseTime;
	}

	/**
	 * Sets the value of the expectedUseTime property.
	 *
	 * @param value allowed object is {@link IVLTS }
	 *
	 */
	public void setExpectedUseTime(IVLTS value) {
		this.expectedUseTime = value;
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
	 * Gets the value of the product property.
	 *
	 * @return possible object is {@link POCDMT000040Product }
	 *
	 */
	public POCDMT000040Product getProduct() {
		return product;
	}

	/**
	 * Sets the value of the product property.
	 *
	 * @param value allowed object is {@link POCDMT000040Product }
	 *
	 */
	public void setProduct(POCDMT000040Product value) {
		this.product = value;
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
	 * @return possible object is {@link ActClassSupply }
	 *
	 */
	public ActClassSupply getClassCode() {
		if (classCode == null) {
			return ActClassSupply.SPLY;
		} else {
			return classCode;
		}
	}

	/**
	 * Sets the value of the classCode property.
	 *
	 * @param value allowed object is {@link ActClassSupply }
	 *
	 */
	public void setClassCode(ActClassSupply value) {
		this.classCode = value;
	}

	/**
	 * Gets the value of the moodCode property.
	 *
	 * @return possible object is {@link XDocumentSubstanceMood }
	 *
	 */
	public XDocumentSubstanceMood getMoodCode() {
		return moodCode;
	}

	/**
	 * Sets the value of the moodCode property.
	 *
	 * @param value allowed object is {@link XDocumentSubstanceMood }
	 *
	 */
	public void setMoodCode(XDocumentSubstanceMood value) {
		this.moodCode = value;
	}

}
