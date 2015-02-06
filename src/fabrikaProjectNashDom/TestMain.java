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
//			   "Мелкая бытовая техника", "Тостер PHILIPS HD 2586/20"
//			   		+ " Черный/серебристый", "шт.", 323.00,
//			   545.00, 11, "Мощность: 950 Вт. Кол-во отделений:"
//			   		+ " 2. Количество тостов: 2. Съемный поддон для крошек:"
//			   		+ " есть. Цвет: серебристый металлик/черный");
//	Product product2 = new Product(2, "12345678900002", "1017679",
//			   "Крупная бытовая техника", "Стиральная машина узкая"
//			   		+ " INDESIT WISN 821 UA", "шт.", 2500.00,
//			   3393.00, 7, "Тип: узкая. Количество белья при стирке:"
//			   		+ " 5 кг. Скорость отжима: 800 об/мин. Класс "
//			   		+ "энергопотребления: А+. Дисплей: нет. Количество"
//			   		+ " программ: 16. Габариты (ВхШхГ) : 85x59,5x42 см. "
//			   		+ "Цвет: белый.");
//	Product product3 = new Product(3, "12345678900003", "169614",
//			   "Мелкая бытовая техника", "Кофеварка эспрессо DELONGHI ECAM "
//			   		+ "22.110 SB", "шт.", 7385.00, 13299.00, 3,
//			   		"Тип: кофемашина эспрессо. Тип управления: электронное."
//			   		+ " Приготовление капучино: ручное. Тип используемого"
//			   		+ " кофе: зерновой, молотый. Резервуар для воды: 1,8 л."
//			   		+ " Давление водяного насоса: 15 бар. Функции:"
//			   		+ " автоматическая очистка от накипи, автоотключение,"
//			   		+ " выбор объема порции, подогрев чашек, регулировка"
//			   		+ " крепости кофе. Габариты: 35,1x23,8x43 см. Вес: 9 кг."
//			   		+ " Цвет: серебристый.");
//	JDBC.setNewProduct(product1);
//	JDBC.setNewProduct(product2);
//	JDBC.setNewProduct(product3);
//	JDBC.deleteProduct(product2);
//	System.out.println(JDBC.selectAllNotNullProducts());
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			UINashDom.createUINashDom();
		}
	});
	}

}
