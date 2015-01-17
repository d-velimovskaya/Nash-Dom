package fabrikaProjectNashDom;


public class Supply {
	private Product product;
	private final static int productSale = 0;
	private int productSupply = 0;
	private double purchasePrice = 0.00;
	private double total = 0.00;
	
	public Supply() {}
	
	public Supply(Product product, int productSupply,
			double purchasePrice) {
		this.product = product;
		setProductSupply(productSupply);
		setPurchasePrice(purchasePrice);
		setTotal(productSupply,purchasePrice);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductSupply() {
		return productSupply;
	}

	public void setProductSupply(int productSupply) {
		if (checkProductSupply(productSupply)) {
			this.productSupply = productSupply;
		}
	}
	
	private boolean checkProductSupply(int productSupply) {
		if (productSupply > 0) {
			return true;
			} else return false;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		if (checkPurchasePrice(purchasePrice)) {
			this.purchasePrice = purchasePrice;
		}
	}
	
	private boolean checkPurchasePrice(double purchasePrice) {
		if (purchasePrice > 0.00) {
			return true;
		} else return false;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(int productSupply, double purchasePrice) {
		if(checkProductSupply(productSupply) 
				&& checkPurchasePrice(purchasePrice)) {
			this.total = productSupply*purchasePrice;
		}
	}

	public static int getProductsale() {
		return productSale;
	}
	
	
	
	

}
