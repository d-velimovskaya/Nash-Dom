package fabrikaProjectNashDom;

public class Sale {
	private int saleId;
	private Product product;
	private int productSale = 0;
	private final static int productSupply = 0;
	private int salesSlipNumber;// I suppose it's not necessary
	private double totalAmount = 0.00;
	
	public Sale() {}
	
	public Sale(int saleId, Product product, int productSale,
			int salesSlipNumber) {
		setSaleId(saleId);
		this.product = product;
		setProductSale(productSale);
		setSalesSlipNumber(salesSlipNumber);
		setTotalAmount(product, productSale);
	}
	
	public String toString() {
		return "\nSale Id: " + getSaleId() + "\n"
				+ getProduct().getProductName() + "	"
				+ getProductSale() + "	" + getTotalAmount();
	}
	
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		if (saleId > 0) {
			this.saleId = saleId;
		}
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductSale() {
		return productSale;
	}
	public void setProductSale(int productSale) {
		if (productSale>0){
			this.productSale = productSale;
		}
	}
	public int getSalesSlipNumber() {
		return salesSlipNumber;
	}
	public void setSalesSlipNumber(int salesSlipNumber) {
		this.salesSlipNumber = salesSlipNumber;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Product product, int productSale) {
		this.totalAmount = product.getConsumerPrice()*productSale;
	}
	public static int getProductsupply() {
		return productSupply;
	}
	
	

	
}
