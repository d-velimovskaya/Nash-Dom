package fabrikaProjectNashDom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class JDBC {
	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/nashdom";
	private static String user = "postgres";
	private static String password = "123456";
	private static Connection connection = null;
	private static Statement statement = null;
	
	//database connection method
	private static Connection getDBconnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url,user,password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//this method inserts a record to DB table shop or supplier
	public static void insertIntoShopSupplier(ShopSupplier ss){
		connection = getDBconnection();
		String insertTableSQL = "";
		try {
			statement = connection.createStatement();
			String table = "";
			if (ss.getCheckMark()) {
				table = "shop";
			} else {
				table = "supplier";
			}
			insertTableSQL = "INSERT INTO " + table + " VALUES (\'"
					+ ss.getId() + "\',\'" + ss.getBusinessName() + "\',\'"
					+ ss.getAddress() + "\',\'" + ss.getPhoneNumber() + "\',\'"
					+ ss.getFax() + "\',\'" + ss.getAccountCurrent() + "\',\'"
					+ ss.getBank() + "\',\'" + ss.getBankCode() + "\',\'"
					+ ss.getCodeEDRPOU() + "\',\'" + ss.getInn() + "\',\'"
					+ ss.getExtraInformation() + "\');";
			statement.executeUpdate(insertTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//this method deletes a record  with chosen id
	//from DB table shop or supplier
	public static void deleteFromShopSupplier(ShopSupplier ss) {
		connection = getDBconnection();
		String deleteTableSQL = "";
		try {
			statement = connection.createStatement();
			String table = "";
			if (ss.getCheckMark()) {
				table = "shop";
			} else {
				table = "supplier";
			}
			deleteTableSQL = "DELETE FROM " + table + " WHERE " + table + "_id = "
					+ "\'" + ss.getId() + "\';";
			statement.executeUpdate(deleteTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//this method selects all records from DB table shop or supplier
	//depends on checkMark, if it true - shop, false - supplier
	public static ArrayList<ShopSupplier> selectFromShopSupplier(boolean checkMark) {
		ArrayList<ShopSupplier> report = new ArrayList<ShopSupplier>();
		String selectTableSQL = "";
		connection = getDBconnection();
		try {
			statement = connection.createStatement();
			String table = "";
			if (checkMark) {
				table = "shop";
			} else {
				table = "supplier";
			}
			selectTableSQL = "SELECT * FROM " + table + ";";
			ResultSet rs = statement.executeQuery(selectTableSQL);
				if(rs != null) {
					while (rs.next()) {
						ShopSupplier shopsupplier = new ShopSupplier();
						shopsupplier.setId(rs.getInt(table + "_id"));
						shopsupplier.setBusinessName(rs.getString(
								table + "_name"));
						shopsupplier.setAddress(rs.getString(
								table + "_address"));
						shopsupplier.setPhoneNumber(rs.getString(
								table + "_phone_number"));
						shopsupplier.setFax(rs.getString(
								table + "_fax_number"));
						shopsupplier.setAccountCurrent(rs.getString(
								table + "_account_current"));
						shopsupplier.setBank(rs.getString(
								table + "_bank"));
						shopsupplier.setBankCode(rs.getString(
								table + "_bank_code"));
						shopsupplier.setCodeEDRPOU(rs.getString(
								table + "_edrpou_code"));
						shopsupplier.setInn(rs.getString(
								table + "_inn"));
						shopsupplier.setExtraInformation(rs.getString(
								table + "_extra_info"));
						report.add(shopsupplier);
					}
					if(rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					return report;
					}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return report;
	}
	//this method inserts a record to DB table product
	public static void newProduct(Product product){
		connection = getDBconnection();
		String insertTableSQL = "";
		try {
			statement = connection.createStatement();
			insertTableSQL = "INSERT INTO product VALUES (\'"
					+ product.getId() + "\',\'" + product.getBarcode() + "\',\'"
					+ product.getArticle() + "\',\'"
					+ product.getProductGroup() + "\',\'"
					+ product.getProductName() + "\',\'"
					+ product.getUnitOfMeasure() + "\',\'"
					+ product.getPrimeCost() + "\',\'"
					+ product.getConsumerPrice() + "\',\'"
					+ product.getStockLevel() + "\',\'"
					+ product.getDescription() + "\');";
			statement.executeUpdate(insertTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//this method deletes a record  with chosen id
	//from DB table product
	public static void deleteProduct(Product product) {
		connection = getDBconnection();
		String deleteTableSQL = "";
		try {
			statement = connection.createStatement();
			deleteTableSQL = "DELETE FROM product WHERE product_id = "
					+ "\'" + product.getId() + "\';";
			statement.executeUpdate(deleteTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
