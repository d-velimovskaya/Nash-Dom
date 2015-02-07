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
	public static void setNewProduct(Product product){
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
	
	//this method selects all records from DB table product
	public static ArrayList<Product> selectAllNotNullProducts() {
		ArrayList<Product> productStock = new ArrayList<Product>();
		String selectTableSQL = "";
		connection = getDBconnection();
		try {
			statement = connection.createStatement();
			selectTableSQL = "SELECT * FROM product WHERE stock_level <> 0 "
					+ "ORDER BY product_id;";
			ResultSet rs = statement.executeQuery(selectTableSQL);
				if(rs != null) {
					while (rs.next()) {
						Product product = new Product();
						product.setId(rs.getInt("product_id"));
						product.setBarcode(rs.getString("barcode"));
						product.setArticle(rs.getString("article"));
						product.setProductGroup(rs.getString("product_group"));
						product.setProductName(rs.getString("product_name"));
						product.setUnitOfMeasure(rs.getString("unit_of_measure"));
						product.setPrimeCost(rs.getDouble("prime_cost"));
						product.setConsumerPrice(rs.getDouble("consumer_price"));
						product.setStockLevel(rs.getInt("stock_level"));
						product.setDescription(rs.getString("description"));
						productStock.add(product);
					}
					if(rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					return productStock;
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
		return productStock;
	}

	//this method get maximum tableName_id from DB table with tableName
	public static int getMaxId(String tableName) {
		String selectTableSQL = "SELECT max(" +
					tableName +"_id) FROM " + tableName + ";";
		int maxId = 0;
		connection = getDBconnection();
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectTableSQL);
				if(rs != null) {
					while (rs.next()) {
						maxId = rs.getInt("max");
					}
					if(rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					return maxId;
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
		return maxId;
	}
	
	/*This method checks whether there is a new value in specified
	*column of the specified table in our database.
	*If the specified table in specified column already has
	*this value the method returns true, in other case 
	*(new value is unique) it returns false.
	*/
	public static boolean ValueUnicityTest(String tableName,
			String column, String newValue) {
		String selectTableSQL = "SELECT * FROM " + tableName + ";";
		connection = getDBconnection();
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectTableSQL);
				if(rs != null) {
					while (rs.next()) {
						if (rs.getString(column).equals(newValue)) {
							return true;
						}
					}
					if(rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
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
		return false;
	}

	//get the quantity of different product groups in DB table "product"
	public static int countDistinctProductGroups(){
		String selectCountProductGroupSQL = "SELECT COUNT("
				+ "DISTINCT product_group) FROM product;";
		int productGroupCount = 0;
		connection = getDBconnection();
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectCountProductGroupSQL);
				if(rs != null) {
					while (rs.next()) {
						productGroupCount = rs.getInt("count");
					}
					if(rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
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
		return productGroupCount;
	}
	
	//get only distinct product groups frop DB table "product" 
	//in ascending order
	public static String[] getAllDistinctProductGroups(){
		String selectAllDistinctProductGroupSQL = 
			"SELECT DISTINCT product_group FROM product ORDER BY product_group;";
		int k = countDistinctProductGroups();
		String[] productGroups = new String[k];
		int i=0;
		connection = getDBconnection();
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(selectAllDistinctProductGroupSQL);
				if(rs != null) {
					while (rs.next()) {
						productGroups[i++] = rs.getString("product_group");
					}
					if(rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
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
		return productGroups;
	}
}
