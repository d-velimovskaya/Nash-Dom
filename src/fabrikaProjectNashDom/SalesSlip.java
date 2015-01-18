package fabrikaProjectNashDom;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.List;

public class SalesSlip {
	private int slipNumber; // 8 digits
	private ShopSupplier shop = new ShopSupplier();
	private Calendar date = new GregorianCalendar();
	private List<Sale> sales = new ArrayList<Sale>(); //list of sales for this cheque
	private double total = 0.00; // total amount of this cheque

	public SalesSlip() {}
	
	public SalesSlip(int slipNumber, ShopSupplier shop,
			List<Sale> sales) {
		setSlipNumber(slipNumber);
		setShop(shop);
		this.date = Calendar.getInstance();
		setSales(sales);
		setTotal(sales);
	}
	
	public String toString() {
		String salesString = "";
		for(Sale singleSale : sales) {
			salesString += singleSale.toString();
		}
		return "\nSlip Number: " + getSlipNumber() + "\nShop: "
				+ getShop().getBusinessName() + "\n" + getDate().get(Calendar.DATE)
				+ "." + getDate().get(Calendar.MONTH) + "."
				+ getDate().get(Calendar.YEAR) + "	" + getDate().get(Calendar.HOUR)
				+ ":" + getDate().get(Calendar.MINUTE) + ":"
				+ getDate().get(Calendar.SECOND) + "\n" + salesString
				+ "\nTotal amount: " + getTotal() + " UAH";
	}

	public int getSlipNumber() {
		return slipNumber;
	}

	public void setSlipNumber(int slipNumber) {
		if (slipNumber > 0) {
			this.slipNumber = slipNumber;
		}
	}

	public ShopSupplier getShop() {
		return shop;
	}

	public void setShop(ShopSupplier shop) {
		if (shop.getCheckMark()) {
			this.shop = shop;
		}
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate() {
		this.date = Calendar.getInstance();
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
		for(Sale singleSale : sales) {
			singleSale.getProduct().updateStockLevel(Sale.getProductsupply(),
					singleSale.getProductSale());
		}
		
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(List<Sale> sales) {
		for(Sale singleSale : sales){
			this.total = total + singleSale.getTotalAmount();	
		}
	}

	
}
