package fabrikaProjectNashDom;
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
	private String description = "";

	public Product() {}

	public Product(int id, String barcode, String article,
				   String productGroup, String productName,
				   String unitOfMeasure, double primeCost,
				   double consumerPrice, int stockLevel,
				   String description) {
		setId(id);
		setBarcode(barcode);
		this.article = article;
		this.productGroup = productGroup;
		this.productName = productName;
		this.unitOfMeasure = unitOfMeasure;
		setPrimeCost(primeCost);
		setConsumerPrice(consumerPrice);
		setStockLevel(stockLevel);
		this.setDescription(description);
	}

	private boolean checkBarcode(String barcode) {
		if (barcode.length() < 15) {
			return true;
		} else return false;
	}

	private boolean checkPrimeCost(double primeCost) {
		if (primeCost>0.00) {
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
		+ "\nProduct Quantity: " + getStockLevel()
		+ getUnitOfMeasure() + "\nProduct Final Cost = "
		+ getPrimeCost() + "\nProduct Consumer Price = "
		+ getConsumerPrice() + "\nProduct Description:"
		+ getDescription();
	}
	
	public void setId(int id) {
		if (id > 0) {
			this.id = id;
		}
	}

	public int getId() {
		return id;
	}

	public void setBarcode(String barcode) {
		if(checkBarcode(barcode)) {
			this.barcode = barcode;
		}
	}

	public String getBarcode() {
		return barcode;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getArticle() {
		return article;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setPrimeCost(double primeCost) {
		if (checkPrimeCost(primeCost)) {
			this.primeCost = primeCost;
		}
	}

	public double getPrimeCost() {
		return primeCost;
	}
	
	public void setConsumerPrice(double consumerPrice) {
		if (checkConsumerPrice(consumerPrice)) {
			this.consumerPrice = consumerPrice;
		}
	}

	public double getConsumerPrice() {
		return consumerPrice;
	}

	public void setStockLevel(int stockLevel) {
		if (checkStockLevel(stockLevel)) {
			this.stockLevel = stockLevel;
		}
	}

	public int getStockLevel() {
		return stockLevel;
	}

	/*
	*Updates the number of products in stock 
	*depending on the amount in
	*supply or sale document.
	*/

	public void updateStockLevel(int productSupply,
								 int productSale) {
		this.stockLevel = this.stockLevel + productSupply
						  - productSale;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
