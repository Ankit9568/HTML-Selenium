package APIs;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import APIs.StbAssign.ObjectFactory;
import APIs.StbAssign.SubscriberAPIType;
import APIs.StbAssign.SubscriberDataAttributesType;
import APIs.StbAssign.SubscriberSTBAssignType;
import APIs.StbAssign.SubscriberSTBType;
import APIs.packageAssign.PackageDataType;
import APIs.packageAssign.SubscriberPackageAssignType;
import APIs.packageAssign.SubscriberPackageType;
import APIs.requestReponseXmls.RequestResponseValidation;

public class STBAPIs {

	public void stbAssign(String accountNumber, String equipmentId, String macAddress, String serialNumber,
			String subscriberVersion) throws Exception {

		SubscriberDataAttributesType subscriberDataAttributesType = new SubscriberDataAttributesType();
		subscriberDataAttributesType.setAccountNumber(accountNumber);

		SubscriberSTBType subscriberSTBType = new SubscriberSTBType();
		subscriberSTBType.setEquipmentId(Integer.parseInt(equipmentId));
		subscriberSTBType.setMacAddress(macAddress);
		subscriberSTBType.setSerialNumber(Integer.parseInt(serialNumber));

		SubscriberSTBAssignType subscriberSTBAssignType = new SubscriberSTBAssignType();
		subscriberSTBAssignType.setSubscriberSTB(subscriberSTBType);
		subscriberSTBAssignType.setSubscriberDataAttributes(subscriberDataAttributesType);

		SubscriberAPIType subscriberAPIType = new SubscriberAPIType();
		subscriberAPIType.setVersion(subscriberVersion);
		subscriberAPIType.setSubscriberSTBAssign(subscriberSTBAssignType);

		JAXBContext jaxbContext = JAXBContext.newInstance(SubscriberAPIType.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		JAXBElement<SubscriberAPIType> newXml = (new ObjectFactory()).createSubscriberAPI(subscriberAPIType);
		// output pretty printed
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		File file = new File(RequestResponseValidation.requestXml);
		marshaller.marshal(newXml, file);
		new RequestResponseValidation().postRequest();

	}

	public void stbUnassign(String accountNumber, String equipmentId, String macAddress, String serialNumber,
			String subscriberVersion) throws Exception {

		APIs.StbUnAssign.SubscriberDataAttributesType subscriberDataAttributesType = new APIs.StbUnAssign.SubscriberDataAttributesType();
		subscriberDataAttributesType.setAccountNumber(accountNumber);

		APIs.StbUnAssign.SubscriberSTBType subscriberSTBType = new APIs.StbUnAssign.SubscriberSTBType();

		subscriberSTBType.setEquipmentId(equipmentId);
		subscriberSTBType.setMacAddress(macAddress);
		subscriberSTBType.setSerialNumber(serialNumber);

		APIs.StbUnAssign.SubscriberSTBUnassignType subscriberSTBAssignType = new APIs.StbUnAssign.SubscriberSTBUnassignType();
		subscriberSTBAssignType.setSubscriberSTB(subscriberSTBType);
		subscriberSTBAssignType.setSubscriberDataAttributes(subscriberDataAttributesType);

		APIs.StbUnAssign.SubscriberAPIType subscriberAPIType = new APIs.StbUnAssign.SubscriberAPIType();
		subscriberAPIType.setVersion(subscriberVersion);
		subscriberAPIType.setSubscriberSTBUnassign(subscriberSTBAssignType);

		JAXBContext jaxbContext = JAXBContext.newInstance(APIs.StbUnAssign.SubscriberAPIType.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		JAXBElement<APIs.StbUnAssign.SubscriberAPIType> newXml = (new APIs.StbUnAssign.ObjectFactory())
				.createSubscriberAPI(subscriberAPIType);

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		File file = new File(RequestResponseValidation.requestXml);

		marshaller.marshal(newXml, file);
		new RequestResponseValidation().postRequest();
	}

	public void stbPackageAssign(String accountNumber, String subscriberApiVersion, String packageId,
			String packageLock, String usoc, String packageRateCode, String subscriptionStartDate,
			String subcriptionEndDate) throws Exception {

		PackageDataType packageDataType = new PackageDataType();
		packageDataType.setPackageId(packageId);
		packageDataType.setPackageLocked(packageLock);
		packageDataType.setUsoc(usoc);
		packageDataType.setPackageRateCode(packageRateCode);
		packageDataType.setSubscriptionStartDate(subscriptionStartDate);
		packageDataType.setSubscriptionEndDate(subcriptionEndDate);

		APIs.packageAssign.SubscriberDataAttributesType subscriberDataAttributesType = new APIs.packageAssign.SubscriberDataAttributesType();
		subscriberDataAttributesType.setAccountNumber(accountNumber);

		SubscriberPackageType subscriberPackageType = new SubscriberPackageType();
		subscriberPackageType.setPackageData(packageDataType);
		subscriberPackageType.setSubscriberDataAttributes(subscriberDataAttributesType);

		SubscriberPackageAssignType subscriberPackageAssignType = new SubscriberPackageAssignType();
		subscriberPackageAssignType.setSubscriberPackage(subscriberPackageType);

		APIs.packageAssign.SubscriberAPIType subscriberAPIType = new APIs.packageAssign.SubscriberAPIType();
		subscriberAPIType.setVersion(subscriberApiVersion);
		subscriberAPIType.setSubscriberPackageAssign(subscriberPackageAssignType);

		JAXBContext jaxbContext = JAXBContext.newInstance(APIs.packageAssign.SubscriberAPIType.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		JAXBElement<APIs.packageAssign.SubscriberAPIType> newXml = (new APIs.packageAssign.ObjectFactory())
				.createSubscriberAPI(subscriberAPIType);
		// output pretty printed
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		File file = new File(RequestResponseValidation.requestXml);

		marshaller.marshal(newXml, file);
		new RequestResponseValidation().postRequest();

	}

	public void stbPackageUnAssign(String accountNumber, String subscriberApiVersion, String packageId,
			String packageLock, String usoc, String packageRateCode, String subscriptionStartDate,
			String subcriptionEndDate) throws Exception {

		APIs.packageUnassign.PackageDataType packageDataType = new APIs.packageUnassign.PackageDataType();
		packageDataType.setPackageId(packageId);
		packageDataType.setPackageLocked(packageLock);
		packageDataType.setUsoc(usoc);
		packageDataType.setPackageRateCode(packageRateCode);
		packageDataType.setSubscriptionStartDate(subscriptionStartDate);
		packageDataType.setSubscriptionEndDate(subcriptionEndDate);

		APIs.packageUnassign.SubscriberDataAttributesType subscriberDataAttributesType = new APIs.packageUnassign.SubscriberDataAttributesType();
		subscriberDataAttributesType.setAccountNumber(accountNumber);

		APIs.packageUnassign.SubscriberPackageType subscriberPackageType = new APIs.packageUnassign.SubscriberPackageType();
		subscriberPackageType.setPackageData(packageDataType);
		subscriberPackageType.setSubscriberDataAttributes(subscriberDataAttributesType);

		APIs.packageUnassign.SubscriberPackageUnassignType subscriberPackageAssignType = new APIs.packageUnassign.SubscriberPackageUnassignType();
		subscriberPackageAssignType.setSubscriberPackage(subscriberPackageType);

		APIs.packageUnassign.SubscriberAPIType subscriberAPIType = new APIs.packageUnassign.SubscriberAPIType();
		subscriberAPIType.setVersion(subscriberApiVersion);
		subscriberAPIType.setSubscriberPackageUnassign(subscriberPackageAssignType);

		JAXBContext jaxbContext = JAXBContext.newInstance(APIs.packageUnassign.SubscriberAPIType.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		JAXBElement<APIs.packageUnassign.SubscriberAPIType> newXml = (new APIs.packageUnassign.ObjectFactory())
				.createSubscriberAPI(subscriberAPIType);
		// output pretty printed
		File file = new File(RequestResponseValidation.requestXml);

		marshaller.marshal(newXml, file);
		new RequestResponseValidation().postRequest();
	}
}
