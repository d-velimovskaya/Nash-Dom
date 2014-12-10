public class Shop {
	private int id = 0;
	private String businessName = "-";
	private String address = "-";
	private String phoneNumber = "-";
	private String fax = "-";
	private long accountCurrent; // 6-14 digits
	private String bank = "-";
	private int bankCode; // 6 digits
	private int codeEDRPOU; // 8 digits
	private long inn; // 12 digits

	public Shop() {}

	public Shop(int id, String businessName, String address,
				String phoneNumber, String fax, long accountCurrent,
				String bank, int bankCode, int codeEDRPOU, long inn) {
		this.id = id;
		this.businessName = businessName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.fax = fax;
		setAccountCurrent(accountCurrent);
		this.bank = bank;
		setBankCode(bankCode);
		setCodeEDRPOU(codeEDRPOU);
		setInn(inn);
	}

	private int countDigits(long number) {
		int size = 0;
		while (number>0) {
			number/=10;
			size++;
		}
		return size;
	}

	private boolean checkAccountCurrent(long accountCurrent) {
		if (countDigits(accountCurrent)>5 && countDigits(accountCurrent)<15) {
			return true;
		} else return false;
	}

	private boolean checkInn(long inn) {
		if (countDigits(inn) == 12) {
			return true;
		} else return false;
	}

	private boolean checkBankCode(int bankCode) {
		if (countDigits(bankCode) == 6) {
			return true;
		} else return false;
	}

	private boolean checkCodeEDRPOU(int codeEDRPOU) {
		if (countDigits(codeEDRPOU) == 8) {
			return true;
		} else return false;
	}

	public String toString() {
		return "\n" + getBusinessName() + "\n" + getAddress()
			   + "\na/c " + getAccountCurrent() + "   MFO "
			   + getBankCode() + "\nin a bank branch "
			   + getBank() + "\nINN" + getInn() + "\ntel.: "
			   + getPhoneNumber() + ", fax: " + getFax() + "\n";
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
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

	public void setAccountCurrent(long accountCurrent) {
		if (checkAccountCurrent(accountCurrent)) {
			this.accountCurrent = accountCurrent;
		}
	}

	public long getAccountCurrent() {
		return accountCurrent;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBank() {
		return bank;
	}

	public void setBankCode(int bankCode) {
		if (checkBankCode(bankCode)) {
			this.bankCode = bankCode;
		}
	}

	public int getBankCode() {
		return bankCode;
	}

	public void setCodeEDRPOU(int codeEDRPOU) {
		if (checkCodeEDRPOU(codeEDRPOU)) {
			this.codeEDRPOU = codeEDRPOU;
		}
	}

	public int getCodeEDRPOU() {
		return codeEDRPOU;
	}

	public void setInn(long inn) {
		if (checkInn(inn)) {
			this.inn = inn;
		}
	}

	public long getInn() {
		return inn;
	}
}