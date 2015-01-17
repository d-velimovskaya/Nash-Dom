package fabrikaProjectNashDom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class SupplyDocument {
	private ShopSupplier supplier;
	private int supplyDocumentNumber;
	private Calendar date = new GregorianCalendar();
	private double totalAmount = 0.00;
	private List<Supply> supplies = new ArrayList<Supply>();
	
	public SupplyDocument() {}
	
	public SupplyDocument(int supplyDocumentNumber, ShopSupplier supplier,
			Calendar date, List<Supply> supplies) {
		setSupplyDocumentNumber(supplyDocumentNumber);
		setSupplier(supplier);
		this.date = date;
		this.supplies = supplies;
		setTotalAmount(supplies);		
	}
	
	public ShopSupplier getSupplier() {
		return supplier;
	}
	public void setSupplier(ShopSupplier supplier) {
		if (!supplier.getCheckMark()) {
			this.supplier = supplier;
		}
	}
	public int getSupplyDocumentNumber() {
		return supplyDocumentNumber;
	}
	public void setSupplyDocumentNumber(int supplyDocumentNumber) {
		if (supplyDocumentNumber > 0) {
			this.supplyDocumentNumber = supplyDocumentNumber;
		}
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(List<Supply> supplies) {
		for (Supply singleSupply : supplies) {
			totalAmount += singleSupply.getTotal() ;
		}
	}
	public List<Supply> getSupplies() {
		return supplies;
	}
	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}
	

}
