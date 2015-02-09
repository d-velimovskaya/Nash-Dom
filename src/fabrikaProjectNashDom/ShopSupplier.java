package fabrikaProjectNashDom;
public class ShopSupplier {
	private int id = 0;
	private boolean checkMark = false;// if it's Shop: checkMark=true, if Supplier: checkMark=false
	private String businessName = "";
	private String address = "";
	private String phoneNumber = "";
	private String fax = "";
	private String accountCurrent = ""; // 6-14 digits
	private String bank = "";
	private String bankCode = ""; // 6 digits
	private String codeEDRPOU = ""; // 8 digits
	private String inn = ""; // 12 digits
	private String extraInformation = "";

	public ShopSupplier() {}

	public ShopSupplier(int id, boolean checkMark, String businessName, String address,
				String phoneNumber, String fax, String accountCurrent,
				String bank, String bankCode, String codeEDRPOU, String inn,
				String extraInformation) {
		setId(id);
		this.checkMark = checkMark;
		this.businessName = businessName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.fax = fax;
		setAccountCurrent(accountCurrent);
		this.bank = bank;
		setBankCode(bankCode);
		setCodeEDRPOU(codeEDRPOU);
		setInn(inn);
		this.extraInformation = extraInformation;
	}

	private boolean checkAccountCurrent(String accountCurrent) {
		if (accountCurrent.length()>5 && accountCurrent.length()<15) {
			return true;
		} else return false;
	}

	private boolean checkInn(String inn) {
		if (inn.length() == 12) {
			return true;
		} else return false;
	}

	private boolean checkBankCode(String bankCode) {
		if (bankCode.length() == 6) {
			return true;
		} else return false;
	}

	private boolean checkCodeEDRPOU(String codeEDRPOU) {
		if (codeEDRPOU.length() == 8) {
			return true;
		} else return false;
	}

	public String toString() {
		return "\nShop id: " + getId() + "\n"+ getBusinessName() + "\n"
			   + getAddress() + "\na/c " + getAccountCurrent()
			   + "   MFO " + getBankCode() + "\nin a bank branch "
			   + getBank() + "\nINN " + getInn() + "\ntel.: "
			   + getPhoneNumber() + ", fax: " + getFax()
			   + "\nExtra Information:\n" + getExtraInformation();
	}

	public void setId(int id) {
		if (id > 0) {
			this.id = id;
		}
	}

	public int getId() {
		return id;
	}

	public void setCheckMark(boolean checkMark) {
		this.checkMark = checkMark;
	}

	public boolean getCheckMark() {
		return checkMark;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFax() {
		return fax;
	}

	public void setAccountCurrent(String accountCurrent) {
		if (checkAccountCurrent(accountCurrent)) {
			this.accountCurrent = accountCurrent;
		}
	}

	public String getAccountCurrent() {
		return accountCurrent;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBank() {
		return bank;
	}

	public void setBankCode(String bankCode) {
		if (checkBankCode(bankCode)) {
			this.bankCode = bankCode;
		}
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setCodeEDRPOU(String codeEDRPOU) {
		if (checkCodeEDRPOU(codeEDRPOU)) {
			this.codeEDRPOU = codeEDRPOU;
		}
	}

	public String getCodeEDRPOU() {
		return codeEDRPOU;
	}

	public void setInn(String inn) {
		if (checkInn(inn)) {
			this.inn = inn;
		}
	}

	public String getInn() {
		return inn;
	}

	public String getExtraInformation() {
		return extraInformation;
	}

	public void setExtraInformation(String extraInformation) {
		this.extraInformation = extraInformation;
	}
}