package fabrikaProjectNashDom;

public class TestMain {
	
	public static void main (String[] args) {

//	ShopSupplier shop = new ShopSupplier(1, true, "Foxtrot", "Odessa,"
//							 + "Panteleymovskaya str, 25",
//	 						 "(048)236-15-45", "(048)723-15-45",
//	 						 "26001523697452", "OTP bank", "300568",
//	 						 "87465123", "112233445566", "");
//	ShopSupplier supplier1 = new ShopSupplier(101, false, "Foxtrot", "Kyiv, Mishugi str, 14",
//			 "(044)236-15-45", "(044)723-15-45",
//			 "26001523697455", "OTP bank", "300568",
//			 "87465123", "112233445566", "");
// 	System.out.println(shop.toString());
// 	JDBC.deleteFromShopSupplier(shop);
// 	JDBC.insertIntoShopSupplier(shop);
// 	JDBC.deleteFromShopSupplier(supplier1);
// 	JDBC.insertIntoShopSupplier(supplier1);
//	System.out.println(JDBC.selectFromShopSupplier(true));
//	System.out.println(JDBC.selectFromShopSupplier(false));
	
//	Product product1 = new Product(1, "12345678900001", "184237",
//			   "������ ������� �������", "������ PHILIPS HD 2586/20"
//			   		+ " ������/�����������", "��.", 323.00,
//			   545.00, 11, "��������: 950 ��. ���-�� ���������:"
//			   		+ " 2. ���������� ������: 2. ������� ������ ��� ������:"
//			   		+ " ����. ����: ����������� ��������/������");
	Product product2 = new Product(2, "12345678900002", "1017679",
			   "������� ������� �������", "���������� ������ �����"
			   		+ " INDESIT WISN 821 UA", "��.", 2500.00,
			   3393.00, 7, "���: �����. ���������� ����� ��� ������:"
			   		+ " 5 ��. �������� ������: 800 ��/���. ����� "
			   		+ "�����������������: �+. �������: ���. ����������"
			   		+ " ��������: 16. �������� (�����) : 85x59,5x42 ��. "
			   		+ "����: �����.");
//	Product product3 = new Product(3, "12345678900003", "169614",
//			   "������ ������� �������", "��������� �������� DELONGHI ECAM "
//			   		+ "22.110 SB", "��.", 7385.00, 13299.00, 3,
//			   		"���: ���������� ��������. ��� ����������: �����������."
//			   		+ " ������������� ��������: ������. ��� �������������"
//			   		+ " ����: ��������, �������. ��������� ��� ����: 1,8 �."
//			   		+ " �������� �������� ������: 15 ���. �������:"
//			   		+ " �������������� ������� �� ������, ��������������,"
//			   		+ " ����� ������ ������, �������� �����, �����������"
//			   		+ " �������� ����. ��������: 35,1x23,8x43 ��. ���: 9 ��."
//			   		+ " ����: �����������.");
//	JDBC.newProduct(product1);
	JDBC.newProduct(product2);
//	JDBC.newProduct(product3);
//	JDBC.deleteProduct(product2);
	}

}
