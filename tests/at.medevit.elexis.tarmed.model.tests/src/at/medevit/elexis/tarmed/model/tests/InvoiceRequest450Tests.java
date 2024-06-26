package at.medevit.elexis.tarmed.model.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import at.medevit.elexis.tarmed.model.TarmedJaxbUtil;
import ch.fd.invoice450.request.BalanceTPType;
import ch.fd.invoice450.request.BillerAddressType;
import ch.fd.invoice450.request.BodyType;
import ch.fd.invoice450.request.CompanyType;
import ch.fd.invoice450.request.DependsOnType;
import ch.fd.invoice450.request.DiagnosisType;
import ch.fd.invoice450.request.Esr9Type;
import ch.fd.invoice450.request.EsrAddressType;
import ch.fd.invoice450.request.GuarantorAddressType;
import ch.fd.invoice450.request.InsuranceAddressType;
import ch.fd.invoice450.request.InvoiceType;
import ch.fd.invoice450.request.KvgLawType;
import ch.fd.invoice450.request.PatientAddressType;
import ch.fd.invoice450.request.PayantType;
import ch.fd.invoice450.request.PayloadType;
import ch.fd.invoice450.request.PersonType;
import ch.fd.invoice450.request.PostalAddressType;
import ch.fd.invoice450.request.ProcessingType;
import ch.fd.invoice450.request.PrologType;
import ch.fd.invoice450.request.ProviderAddressType;
import ch.fd.invoice450.request.RequestType;
import ch.fd.invoice450.request.ServiceType;
import ch.fd.invoice450.request.ServicesType;
import ch.fd.invoice450.request.SoftwareType;
import ch.fd.invoice450.request.TelecomAddressType;
import ch.fd.invoice450.request.TransportType;
import ch.fd.invoice450.request.TransportType.Via;
import ch.fd.invoice450.request.TreatmentType;
import ch.fd.invoice450.request.VatRateType;
import ch.fd.invoice450.request.VatType;
import ch.fd.invoice450.request.ZipType;

public class InvoiceRequest450Tests {
	private static File writeReq450;
	private static File readReq450;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		writeReq450 = new File("rsc/writeReq450.xml");
		if (!writeReq450.exists()) {
			writeReq450.createNewFile();
		}

		readReq450 = new File("rsc/readReq450.xml");
	}

	@Test
	public void testMarshallInvoiceRequest450() throws InstantiationException, IllegalAccessException,
			FileNotFoundException, DatatypeConfigurationException {

		assertTrue(TarmedJaxbUtil.marshallInvoiceRequest(generateRequestSample(), new FileOutputStream(writeReq450)));
		assertTrue(writeReq450.exists());
	}

	@Test
	public void testUnmarshalInvoiceRequest450() throws FileNotFoundException, InstantiationException,
			IllegalAccessException, DatatypeConfigurationException {

		RequestType requestType = TarmedJaxbUtil.unmarshalInvoiceRequest450(new FileInputStream(readReq450));

		assertNotNull(requestType);
		assertEquals("en", requestType.getLanguage());
		assertEquals("UnitTest", requestType.getModus());
		assertNotNull(requestType.getProcessing());
		assertNotNull(requestType.getProcessing().getTransport());
		assertEquals("2099988872462", requestType.getProcessing().getTransport().getFrom());
		assertEquals("7601001302181", requestType.getProcessing().getTransport().getTo());
		assertEquals(1, requestType.getProcessing().getTransport().getVia().size());
		assertNotNull(requestType.getPayload());
		assertNotNull(requestType.getPayload().getInvoice());
		BodyType body = requestType.getPayload().getBody();
		assertNotNull(body);
		assertNotNull(body.getEsr9());
		assertNotNull(body.getTiersPayant());
		assertEquals("6564564", body.getKvg().getInsuredId());
		assertEquals(1, body.getServices().getServiceExOrService().size());
	}

	@Test
	public void testGetXMLVersion() throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		Document jdomDoc = builder.build(readReq450);
		String version = TarmedJaxbUtil.getXMLVersion(jdomDoc);
		assertEquals("4.5", version);
	}

	private RequestType generateRequestSample()
			throws InstantiationException, IllegalAccessException, DatatypeConfigurationException {
		RequestType request = new RequestType();
		request.setModus("UnitTest");
		request.setLanguage("en");
		request.setProcessing(getProcessingSample());
		request.setPayload(getPayloadSample());
		return request;
	}

	private ProcessingType getProcessingSample() {
		ProcessingType processing = new ProcessingType();
		processing.setPrintAtIntermediate(false);
		processing.setPrintCopyToGuarantor(true);
		// transport from - to
		TransportType transport = new TransportType();
		transport.setFrom("2099988872462");
		transport.setTo("7601001302181");
		// transport via
		Via via = new Via();
		via.setSequenceId(1);
		via.setVia("7601001304307");
		transport.getVia().add(via);

		// add transport to processing
		processing.setTransport(transport);
		return processing;
	}

	private PayloadType getPayloadSample()
			throws InstantiationException, IllegalAccessException, DatatypeConfigurationException {
		GregorianCalendar c = new GregorianCalendar();
		c.set(2015, 01, 21, 13, 30);
		XMLGregorianCalendar cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

		PayloadType payload = new PayloadType();
		payload.setType("invoice");
		payload.setCopy(false);
		payload.setStorno(false);

		// set invoice
		InvoiceType invoice = new InvoiceType();
		invoice.setRequestTimestamp(new Integer(1421827519));
		invoice.setRequestId("001163000552");
		payload.setInvoice(invoice);

		// body
		BodyType body = new BodyType();

		// prolog
		PrologType prolog = new PrologType();

		// package
		SoftwareType swPackage = new SoftwareType();
		swPackage.setVersion(300l);
		swPackage.setName("Elexis Unit Test");
		prolog.setPackage(swPackage);

		// generator
		SoftwareType generator = new SoftwareType();
		generator.setVersion(100l);
		generator.setName("JAXB");
		DependsOnType dependsOn = new DependsOnType();
		dependsOn.setName("Elexis Tarmed");
		dependsOn.setVersion(300l);
		generator.getDependsOn().add(dependsOn);
		prolog.setGenerator(generator);

		body.setProlog(prolog);

		// esr 9
		Esr9Type esr9 = new Esr9Type();
		esr9.setParticipantNumber("01-200020-9");
		esr9.setType("16or27");
		esr9.setReferenceNumber("81 17000 00000 00001 16300 05527");
		esr9.setCodingLine("0100000030359&gt;811700000000000011630005527+ 012000209&gt;");

		// add bank part
		EsrAddressType bank = new EsrAddressType();
		CompanyType company = new CompanyType();
		company.setCompanyname("Medevit");
		// address
		PostalAddressType postal = new PostalAddressType();
		ZipType zip = new ZipType();
		zip.setValue("6840");
		postal.setZip(zip);
		postal.setCity("Götzis");
		postal.setStreet("St. Ulrich Straße 40");
		company.setPostal(postal);
		// phone
		TelecomAddressType tele = new TelecomAddressType();
		tele.getPhone().add("+4369919270505");
		company.setTelecom(tele);
		bank.setCompany(company);
		esr9.setBank(bank);
		body.setEsr9(esr9);

		// Tiers Payant
		PayantType payant = new PayantType();

		// biller
		BillerAddressType biller = new BillerAddressType();
		CompanyType medevit = new CompanyType();
		medevit.setCompanyname("Medevit");
		// address & phone
		PostalAddressType adr = new PostalAddressType();
		ZipType plz = new ZipType();
		plz.setValue("6840");
		adr.setZip(plz);
		adr.setCity("Götzis");
		adr.setStreet("St. Ulrich Straße 40");
		medevit.setPostal(adr);
		TelecomAddressType phone = new TelecomAddressType();
		phone.getPhone().add("+4369919270505");
		medevit.setTelecom(phone);
		biller.setCompany(medevit);
		biller.setSpecialty("Software Development");
		payant.setBiller(biller);

		// provider
		ProviderAddressType provider = new ProviderAddressType();
		provider.setCompany(medevit);
		payant.setProvider(provider);

		// insurance
		InsuranceAddressType insurance = new InsuranceAddressType();
		CompanyType person = new CompanyType();
		person.setCompanyname("Armeswesen");
		PostalAddressType postAdr = new PostalAddressType();
		postAdr.setStreet("Apfelgasse 2");
		postAdr.setCity("Lenzburg");
		TelecomAddressType mobil = new TelecomAddressType();
		mobil.getPhone().add("555-7195217");
		person.setPostal(postAdr);
		person.setTelecom(mobil);
		insurance.setCompany(person);
		payant.setInsurance(insurance);

		// patient
		PatientAddressType patAddress = new PatientAddressType();
		patAddress.setGender("female");
		PersonType pat = new PersonType();
		pat.setTitle("Dr.");
		pat.setFamilyname("Armeswesen");
		pat.setGivenname("Edeltraud");
		pat.setPostal(postAdr);
		pat.setTelecom(mobil);
		patAddress.setPerson(pat);
		payant.setPatient(patAddress);

		// guarantor
		GuarantorAddressType guarantor = new GuarantorAddressType();
		guarantor.setPerson(pat);
		payant.setGuarantor(guarantor);

		// balance
		BalanceTPType balance = new BalanceTPType();
		balance.setCurrency("CHF");
		balance.setAmount(30.35);
		balance.setAmountDue(30.35);
		balance.setAmountObligations(30.35);
		// vat
		VatType vat = new VatType();
		vat.setVat(0.0);
		VatRateType vatRate = new VatRateType();
		vatRate.setAmount(30.35);
		vatRate.setVatRate(0.0);
		vatRate.setVat(0.0);
		vat.getVatRate().add(vatRate);
		balance.setVat(vat);

		payant.setBalance(balance);

		body.setTiersPayant(payant);

		// KVG
		KvgLawType kvg = new KvgLawType();
		kvg.setInsuredId("6564564");
		kvg.setCaseDate(cal);
		body.setKvg(kvg);

		// treatment and diagnosis
		TreatmentType treatment = new TreatmentType();
		treatment.setReason("disease");
		treatment.setCanton("AG");
		treatment.setDateBegin(cal);
		treatment.setDateEnd(cal);
		DiagnosisType diagnosis = new DiagnosisType();
		diagnosis.setType("ICD");
		diagnosis.setCode("H00.0");
		treatment.getDiagnosis().add(diagnosis);
		body.setTreatment(treatment);

		// services
		ServicesType services = new ServicesType();
		ServiceType recDrug = new ServiceType();
		recDrug.setUnit(17.50);
		recDrug.setUnitFactor(1.00);
		recDrug.setTariffType("400");
		recDrug.setCode("4768637");
		recDrug.setAmount(17.50);
		recDrug.setVatRate(0.0);
		recDrug.setObligation(false);
		recDrug.setProviderId("7601002145411");
		recDrug.setResponsibleId("7601002145411");
		recDrug.setRecordId(4);
		recDrug.setQuantity(1.0);
		recDrug.setDateBegin(cal);
		recDrug.setName("MUCEDOKEHL Tropfen D 5 AR 11649 10 ml ()");
		services.getServiceExOrService().add(recDrug);
		body.setServices(services);

		payload.setBody(body);
		return payload;
	}
}
