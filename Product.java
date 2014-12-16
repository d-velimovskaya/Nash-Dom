public class Product {
	private int id = 0;
	private String barcode = ""; // under 14 symbols
	private String article = "";
	private String productGroup = "";
	private String productName = "";
	private String unitOfMeasure = "";
	private double primeCost = 0.00;
	private double consumerPrice = 0.00;
	private int stockLevel = 0;

	public Product() {}

	public Product(int id, String barcode, String article,
				   String productGroup, String productName,
				   String unitOfMeasure, double primeCost,
				   double consumerPrice, int stockLevel) {
		this.int = int;
		setBarcode(barcode);
		this.article = article;
		this.productGroup = productGroup;
		this.productName = productName;
		this.unitOfMeasure = unitOfMeasure;
		setPrimeCost(PrimeCost);
		setConsumerPrice(consumerPrice);
		setStockLevel(stockLevel);
	}

	private boolean checkBarcode(String barcode) {
		if (barcode.length() < 15) {
			return true;
		} else return false;
	}

	private boolean checkPrimeCost(double primeCost) {
		if (PrimeCost>0.00) {
			return true;
		} else return false;
	}

	private boolean checkConsumerPrice(double consumerPrice) {
		if (consumerPrice>0.00) {
			return true;
		} else return false;
	}

	private boolean checkStockLevel(int stockLevel) {
		if (stockLevel>0) {
			return true;
		} else return false;
	}

	public String toString() {
		return "\nProduct Id: " + getId() + "\nBarcode: " 
		+ getBarcode() + "Article: " + getArticle()
		+ "\nProduct Group: " + getProductGroup()
		+ "\nProduct Name: " + getProductName()
		+ "\nProduct Quantity: " + getStockevel()
		+ getUnitOfMeasure() + "\nProduct Final Cost = "
		+ getPrimeCost() + "\nProduct Consumer Price = "
		+ getConsumerPrice() + "\n";
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setBarcode(String barcode) {
		if(checkBarcode) {
			this.barcode = barcode;
		}
	}

	public int getBarcode() {
		return barcode;
	}

	public void setArticle(int article) {
		this.article = article;
	}

	public int getArticle() {
		return article;
	}

	public void setProductGroup(int productGroup) {
		this.productGroup = productGroup;
	}

	public int getProductGroup() {
		return productGroup;
	}

	public void setProductName(int productName) {
		this.productName = productName;
	}

	public int getProductName() {
		return productName;
	}

	public void setUnitOfMeasure(int unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public int getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setPrimeCost(int primeCost) {
		if (checkPrimeCost) {
			this.primeCost = primeCost;
		}
	}

	public int getPrimeCost() {
		return primeCost;
	}
	
	/*розничная цена товара получается из его себестоимости
	*50% надбавкой себестоимости и округлением
	*/

	public void setConsumerPrice(int primeCost) {
		if (checkPrimeCost) {
			this.consumerPrice = Math.round(primeCost*1.5);
		}
	}

	public int getConsumerPrice() {
		return consumerPrice;
	}

	public void setStockLevel(int stockLevel) {
		if (checkStockLevel) {
			this.stockLevel = stockLevel;
		}
	}

	public int getStockLevel() {
		return stockLevel;
	}

	/*
	*Обновляет количество данного товара на складе, 
	*в зависимости от его количества в
	*приходной накладной или при продаже.
	*/

	public void updateStockLevel(int productSupply,
								 int productSale) {
		this.stockLevel = this.stockLevel + productSupply
						  - productSale;
	}

}