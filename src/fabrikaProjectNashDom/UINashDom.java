package fabrikaProjectNashDom;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

public class UINashDom {
	static JDesktopPane jdpDesktop;
	static int openFrameCount = 0;
	static final int xPosition = 20, yPosition = 20;

	//creates main JFrame
	public static void createUINashDom() {
		JFrame frame = new JFrame("NashDom");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());

		jdpDesktop = new JDesktopPane();
		frame.setContentPane(jdpDesktop);
		frame.setJMenuBar(createMenuBar());
		
		frame.setVisible(true);
	}
	
	//creates menuBar on the main JFrame
	public static JMenuBar createMenuBar() {
		JMenuBar menubar = new JMenuBar();
		
		JMenu productsMenu = new JMenu("Товары");
		JMenu supplyMenu = new JMenu("Приходы");
		JMenu salesMenu = new JMenu("Продажи");
		JMenu reportsMenu = new JMenu("Отчёты");
		
		JMenuItem addProductItemMenu = new JMenuItem("Добавить товар");
		JMenuItem stockItemMenu = new JMenuItem("Остатки товара");
		JMenuItem addSupplyItemMenu = new JMenuItem("Добавить приход");
		JMenuItem addSupplierItemMenu = new JMenuItem("Добавить поставщика");
		JMenuItem newSlipItemMenu = new JMenuItem("Новый чек");
		JMenuItem reportProductsItemMenu = new JMenuItem("Отчёт по товарам");
		JMenuItem reportSuppliesItemMenu = new JMenuItem("Отчёт по приходам");
		JMenuItem reportSalesItemMenu = new JMenuItem("Отчёт по продажам");
		JMenuItem reportSuppliersItemMenu = new JMenuItem("Отчёт по поставщикам");

		productsMenu.add(addProductItemMenu);
		productsMenu.add(stockItemMenu);
		supplyMenu.add(addSupplyItemMenu);
		supplyMenu.add(addSupplierItemMenu);
		salesMenu.add(newSlipItemMenu);
		reportsMenu.add(reportProductsItemMenu);
		reportsMenu.add(reportSuppliesItemMenu);
		reportsMenu.add(reportSalesItemMenu);
		reportsMenu.add(reportSuppliersItemMenu);

		menubar.add(productsMenu);
		menubar.add(supplyMenu);
		menubar.add(salesMenu);
		menubar.add(reportsMenu);
		
		addProductItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				createUINewProduct();
			}
		});
		
		stockItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//action
			}
		});
		
		addSupplyItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//action
			}
		});
		
		addSupplierItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//action
			}
		});

		newSlipItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//action
			}
		});

		reportProductsItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//action
			}
		});
		reportSuppliesItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//action
			}
		});
		
		reportSalesItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//action
			}
		});
		
		reportSuppliersItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//action
			}
		});
		return menubar;
	}
	
	//creates an internal jframe to add info about new product
	public static void createUINewProduct() {
		final JInternalFrame jfNewProduct = new JInternalFrame(
				"Новый товар ", true, true, true, true);
		jfNewProduct.setSize(700,450);
//		jfNewProduct.setResizable(false);
		jfNewProduct.setMinimumSize(new Dimension(700,450));
		jfNewProduct.setLocation(xPosition * (openFrameCount),
				yPosition * openFrameCount);
		jfNewProduct.setLayout(new GridBagLayout());
		
		if(openFrameCount++>9) openFrameCount = 0;
		
		JButton saveButton = new JButton("Сохранить");
		JButton exitButton = new JButton("Отмена");
		
		JLabel productIdLabel = new JLabel("Id товара: ");
		JLabel productBarcodeLabel = new JLabel("Штрих код: ");
		JLabel productArticleLabel = new JLabel("Артикул: ");
		JLabel productGroupLabel = new JLabel("Группа товаров: ");
		JLabel productNameLabel = new JLabel("Наименование товара: ");
		JLabel productUnitOfMeasureLabel = new JLabel("Единица измерения: ");
		JLabel productPrimeCostLabel = new JLabel("Цена закупки: ");
		JLabel productConsumerPriceLabel = new JLabel("Цена продажи: ");
		JLabel productDescriptionLabel = new JLabel("Описание: ");
		final JLabel distinctProductIdLabel = new JLabel("", JLabel.LEFT);
		final JLabel distinctProductBarcodeLabel = new JLabel("", JLabel.LEFT);
		final JLabel distinctProductArticleLabel = new JLabel("", JLabel.LEFT);
		final JLabel distinctProductNameLabel = new JLabel("", JLabel.LEFT);
		
		final JTextField productIdTextField = new JTextField(15);
		final JTextField productBarcodeTextField = new JTextField(15);
		final JTextField productArticleTextField = new JTextField(15);
		final JTextField productGroupTextField = new JTextField(15);
		final JTextField productNameTextField = new JTextField(15);
		final JTextField productUnitOfMeasureTextField = new JTextField(15);
		final JTextField productPrimeCostTextField = new JTextField(15);
		final JTextField productConsumerPriceTextField = new JTextField(15);
		final JTextArea productDescriptionTextArea = new JTextArea(8, 35);
		
		checkTextOnDigits(productIdTextField, 0);
		productIdTextField.setText(Integer.toString(JDBC.getMaxProductId() + 1));
		setTextLimit(productBarcodeTextField, 14);
		setTextLimit(productArticleTextField, 20);
		setTextLimit(productGroupTextField, 30);
		setTextLimit(productNameTextField, 255);
		setTextLimit(productUnitOfMeasureTextField, 5);
		productUnitOfMeasureTextField.setText("шт.");
		checkTextOnDigits(productPrimeCostTextField, 1);
		checkTextOnDigits(productConsumerPriceTextField, 1);
		setTextLimit(productDescriptionTextArea, 500);
		productDescriptionTextArea.setLineWrap(true);
		
		jfNewProduct.add(productIdLabel, new GridBagConstraints(
				0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(10,10,2,2), 0, 0));
		jfNewProduct.add(productBarcodeLabel, new GridBagConstraints(
				0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productArticleLabel, new GridBagConstraints(
				0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productGroupLabel, new GridBagConstraints(
				0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productNameLabel, new GridBagConstraints(
				0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productUnitOfMeasureLabel, new GridBagConstraints(
				0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productPrimeCostLabel, new GridBagConstraints(
				0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productConsumerPriceLabel, new GridBagConstraints(
				0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productDescriptionLabel, new GridBagConstraints(
				0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productIdTextField, new GridBagConstraints(
				1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(10,2,2,2), 0, 0));
		jfNewProduct.add(productBarcodeTextField, new GridBagConstraints(
				1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productArticleTextField, new GridBagConstraints(
				1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productGroupTextField, new GridBagConstraints(
				1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productNameTextField, new GridBagConstraints(
				1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productUnitOfMeasureTextField, new GridBagConstraints(
				1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productPrimeCostTextField, new GridBagConstraints(
				1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productConsumerPriceTextField, new GridBagConstraints(
				1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productDescriptionTextArea, new GridBagConstraints(
				1, 8, 2, 3, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,10), 0, 0));
		jfNewProduct.add(distinctProductIdLabel, new GridBagConstraints(
				2, 0, 2, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(10,2,2,10), 0, 0));
		jfNewProduct.add(distinctProductBarcodeLabel, new GridBagConstraints(
				2, 1, 2, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,10), 0, 0));
		jfNewProduct.add(distinctProductArticleLabel, new GridBagConstraints(
				2, 2, 2, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,10), 0, 0));
		jfNewProduct.add(distinctProductNameLabel, new GridBagConstraints(
				2, 4, 2, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,10), 0, 0));
		jfNewProduct.add(saveButton, new GridBagConstraints(
				3, 11, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTH,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,10), 0, 0));
		jfNewProduct.add(exitButton, new GridBagConstraints(
				3, 12, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTH,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,10,10), 0, 0));

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					jfNewProduct.setClosed(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			}
		});

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JTextComponent[] textComponents = {productIdTextField,
						productBarcodeTextField, productArticleTextField,
						productGroupTextField, productNameTextField,
						productUnitOfMeasureTextField,productPrimeCostTextField,
						productConsumerPriceTextField, productDescriptionTextArea};
				String[] textMessage = {"id товара", "штрих код", "артикул",
						"группу товаров", "наименование товара",
						"единицу измерения", "цену закупки", "цену продажи"};
				if(JDBC.idUnicityTest("product", Integer.parseInt(
						productIdTextField.getText()))) {
					distinctProductIdLabel.setForeground(Color.RED);
					distinctProductIdLabel.setText("Товар с таким id уже существует!");
				} else {
					distinctProductIdLabel.setText("");
				}
				if(JDBC.ValueUnicityTest("product", "barcode",
						productBarcodeTextField.getText())) {
					distinctProductBarcodeLabel.setForeground(Color.RED);
					distinctProductBarcodeLabel.setText("Товар с таким штрих кодом уже существует!");
				} else {
					distinctProductBarcodeLabel.setText("");
				}
				if(JDBC.ValueUnicityTest("product", "article",
						productArticleTextField.getText())) {
					distinctProductArticleLabel.setForeground(Color.RED);
					distinctProductArticleLabel.setText("Товар с таким артикулом уже существует!");
				} else {
					distinctProductArticleLabel.setText("");
				}
				if(JDBC.ValueUnicityTest("product", "product_name",
						productNameTextField.getText())) {
					distinctProductNameLabel.setForeground(Color.RED);
					distinctProductNameLabel.setText("Товар с таким наименованием уже существует!");
				} else {
					distinctProductNameLabel.setText("");
				}
				if(checkEmptyJTextComponents(jfNewProduct, textComponents,
						textMessage)) {
					Product newProduct = getInfo(textComponents);
					System.out.println(JDBC.getMaxProductId());
//					JDBC.newProduct(newProduct);
				}
			}
		});
		
		jfNewProduct.setVisible(true);
		jdpDesktop.add(jfNewProduct);
		try {
			jfNewProduct.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	//limits the number(=k) of characters entered into a textField or textArea
	public static void setTextLimit(JTextComponent text, final int k) {
		text.setDocument(new PlainDocument() {
			@Override
			public void insertString(int offset, String str,
					AttributeSet attr) throws BadLocationException {
				if (str != null && getLength() < k) {
					super.insertString(offset, str, attr);
				}
			}
		});
	}

	//check if the input data is a number
	//k=0 - without dot (int), k=1 - with 1 dot (double)
	public static void checkTextOnDigits(JTextComponent text, final int k) {
		text.setDocument(new PlainDocument() {
			String chars = "0123456789.";
			
			@Override
			public void insertString(int offset, String str,
					AttributeSet attr) throws BadLocationException {
				int dotCount = 0;
				for (int i = 0; i < str.length(); i++) {
                    if (chars.indexOf(str.charAt(i)) == -1) {
                        return;
                    }
                    if (str.charAt(i) == '.') {
                        dotCount++;
                        if (dotCount > k) {
                            return;
                        }
                    }
                }
                if (getText(0, getLength()).indexOf('.') != -1 && dotCount != 0) {
                    return;
                }
                if (getLength() < 10) {
                    super.insertString(offset, str, attr);
                }
			}
		});
	}

	//check if the important text fields and areas are empty
	//without extra info or description
	public static boolean checkEmptyJTextComponents(
			JInternalFrame internalFrame, JTextComponent[] textComponents,
			String[] textMessage) {
		for(int i=0; i < textComponents.length-1; i++) {
			if (textComponents[i].getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(internalFrame,
						"Пожалуйста, укажите " + textMessage[i] + "!");
				return false;
			}
		}
		return true;
	}

	//
	public static Product getInfo(JTextComponent[] textComponents){
		int i=0;
		Product newProduct = new Product();
		newProduct.setId(Integer.parseInt(textComponents[i++].getText()));
		newProduct.setBarcode(textComponents[i++].getText());
		newProduct.setArticle(textComponents[i++].getText());
		newProduct.setProductGroup(textComponents[i++].getText());
		newProduct.setProductName(textComponents[i++].getText());
		newProduct.setUnitOfMeasure(textComponents[i++].getText());
		newProduct.setPrimeCost(Double.parseDouble(textComponents[i++].getText()));
		newProduct.setConsumerPrice(Double.parseDouble(textComponents[i++].getText()));
		newProduct.setDescription(textComponents[i++].getText());

		return newProduct;
	}
	
}
