package com.rsystems.utils;

public class PackageInformation {

	private String packagename = null;
	private String stbAccountNumber = null;
	private String subscriberApiVersion = null;
	private String packageId = null;
	private String packageLock = null;
	private String packageUsoc = null;
	private String packageRateCode = null;
	private String subscriptionStartDate = null;
	private String subcriptionEndDate = null;

	public PackageInformation(String packageName) {

		this.packagename = packageName;

		this.stbAccountNumber = TestInitization.getExcelKeyValue("PackageAssignAndUnassign", packageName,
				"AccountNumber");
		this.subscriberApiVersion = TestInitization.getExcelKeyValue("PackageAssignAndUnassign", packageName,
				"SubscriberAPIVersion");
		this.packageId = TestInitization.getExcelKeyValue("PackageAssignAndUnassign", packageName, "PackageId");
		this.packageLock = TestInitization.getExcelKeyValue("PackageAssignAndUnassign", packageName, "PackageLock");
		this.packageUsoc = TestInitization.getExcelKeyValue("PackageAssignAndUnassign", packageName, "PackageUsoc");
		this.packageRateCode = TestInitization.getExcelKeyValue("PackageAssignAndUnassign", packageName,
				"PackageRateCode");
		this.subscriptionStartDate = TestInitization.getExcelKeyValue("PackageAssignAndUnassign", packageName,
				"SubscriptionStartDate");
		this.subcriptionEndDate = TestInitization.getExcelKeyValue("PackageAssignAndUnassign", packageName,
				"SubcriptionEndDate");

	}

	public String getStbAccoutNumber() {
		return this.stbAccountNumber;
	}

	public String getSubscriberApiVersion() {
		return this.subscriberApiVersion;
	}

	public String getPackageId() {
		return this.packageId;
	}

	public String getPackageLock() {
		return this.packageLock;
	}

	public String getPackageUsoc() {
		return this.packageUsoc;
	}

	public String getPackageRateCode() {
		return this.packageRateCode;
	}

	public String getSubscriptionStartDate() {
		return this.subscriptionStartDate;
	}

	public String getSubcriptionEndDate() {
		return this.subcriptionEndDate;
	}

	public String getPackageName() {
		return this.packagename;
	}
}
