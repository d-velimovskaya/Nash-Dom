package fabrikaProjectNashDom;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

public class UINashDom {
	private static JDesktopPane jdpDesktop;
	private static int openFrameCount = 0;
	private static final int xPosition = 20, yPosition = 20;
	private static final int codeDigitsCount = 9;
	private static final int priceDigitsCount = 12;
	private static final int accountDigitsCount = 14;
	private static final int bankCodeDigitsCount = 6;
	private static final int codeEDRPOUdigitsCount = 8;
	private static final int codeINNdigitsCount = 12;
	private static final int barcodeDigitsCount = 13;
	private static final int productArticleSymbolCount = 20;
	private static final int productGroupSymbolCount = 30;
	private static final int NameSymbolCount = 255;
	private static final int productUnitOfMeasureSymbolCount = 5;
	private static final int productDescriptionSymbolCount = 500;
	private static final int AddressSymbolCount = 255;
	private static final int PhoneFaxSymbolCount = 20;
	private static final int bankNameSymbolCount = 150;
	private static final int extraInfoSymbolCount = 255;

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
		JMenuItem ShopItemMenu = new JMenuItem("Магазин");
		JMenuItem reportProductsItemMenu = new JMenuItem("Отчёт по товарам");
		JMenuItem reportSuppliesItemMenu = new JMenuItem("Отчёт по приходам");
		JMenuItem reportSalesItemMenu = new JMenuItem("Отчёт по продажам");
		JMenuItem reportSuppliersItemMenu = new JMenuItem("Отчёт по поставщикам");

		productsMenu.add(addProductItemMenu);
		productsMenu.add(stockItemMenu);
		supplyMenu.add(addSupplyItemMenu);
		supplyMenu.add(addSupplierItemMenu);
		salesMenu.add(newSlipItemMenu);
		salesMenu.add(ShopItemMenu);
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
				createUINewSupplier();
			}
		});

		newSlipItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				//action
			}
		});

		ShopItemMenu.addActionListener(new ActionListener() {
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
				"Новый товар", true, true, true, true);
		jfNewProduct.setSize(720,440);
		jfNewProduct.setLocation(xPosition * (openFrameCount),
				yPosition * openFrameCount);
		jfNewProduct.setLayout(new GridBagLayout());
		
		if(openFrameCount++>9) openFrameCount = 0;
		
		JButton saveButton = new JButton("Сохранить");
		JButton exitButton = new JButton("Отмена");
		
		JLabel productIdLabel = new JLabel("Код товара", SwingConstants.CENTER);
		JLabel productBarcodeLabel = new JLabel("Штрих код: ");
		JLabel productArticleLabel = new JLabel("Артикул: ");
		JLabel productGroupLabel = new JLabel("Группа товаров: ");
		JLabel productNameLabel = new JLabel("Наименование товара: ");
		JLabel productUnitOfMeasureLabel = new JLabel(
				"Единица измерения: ", SwingConstants.RIGHT);
		JLabel productPrimeCostLabel = new JLabel("Цена закупки: ");
		JLabel productConsumerPriceLabel = new JLabel(
				"Цена продажи: ", SwingConstants.RIGHT);
		JLabel productDescriptionLabel = new JLabel("Описание: ");
		
		final JTextField productIdTextField = new JTextField(10);
		final JTextField productBarcodeTextField = new JTextField(10);
		final JTextField productArticleTextField = new JTextField(10);
		final JComboBox<String> productGroupComboBox = new
				JComboBox<String>(JDBC.getAllDistinctProductGroups());
		final JTextField productNameTextField = new JTextField(20);
		final JTextField productUnitOfMeasureTextField = new JTextField(10);
		final JTextField productPrimeCostTextField = new JTextField(10);
		final JTextField productConsumerPriceTextField = new JTextField(10);
		final JTextArea productDescriptionTextArea = new JTextArea(15, 40);
		
		checkAndLimitTextOnDigits(productIdTextField, codeDigitsCount);
		productIdTextField.setText(Integer.toString(JDBC.getMaxId("product") + 1));
		productIdTextField.setHorizontalAlignment(JTextField.RIGHT);
		checkAndLimitTextOnDigits(productBarcodeTextField,
				barcodeDigitsCount);
		setTextLimit(productArticleTextField, productArticleSymbolCount);
		JTextComponent comboBoxEditor = 
				(JTextComponent) productGroupComboBox.getEditor().
					getEditorComponent();
		setTextLimit(comboBoxEditor, productGroupSymbolCount);
		productGroupComboBox.setEditable(true);
		productGroupComboBox.setSelectedItem("");
		setTextLimit(productNameTextField, NameSymbolCount);
		setTextLimit(productUnitOfMeasureTextField,
				productUnitOfMeasureSymbolCount);
		productUnitOfMeasureTextField.setText("шт.");
		checkTextOnDouble(productPrimeCostTextField, priceDigitsCount);
		checkTextOnDouble(productConsumerPriceTextField, priceDigitsCount);
		setTextLimit(productDescriptionTextArea, productDescriptionSymbolCount);
		productDescriptionTextArea.setLineWrap(true);
		productDescriptionTextArea.setWrapStyleWord(true);
		
		jfNewProduct.add(productNameLabel, new GridBagConstraints(
				0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.FIRST_LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(10,10,2,2), 0, 0));
		jfNewProduct.add(productNameTextField, new GridBagConstraints(
				1, 0, 3, 1, 1.0, 0.0, GridBagConstraints.FIRST_LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(10,2,2,50), 0, 0));
		jfNewProduct.add(productIdLabel, new GridBagConstraints(
				4, 0, 1, 1, 1.0, 0.0, GridBagConstraints.FIRST_LINE_END,
				GridBagConstraints.HORIZONTAL, new Insets(10,10,2,10), 0, 0));
		jfNewProduct.add(productBarcodeLabel, new GridBagConstraints(
				0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productBarcodeTextField, new GridBagConstraints(
				1, 1, 2, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productIdTextField, new GridBagConstraints(
				4, 1, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_END,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,10), 0, 0));
		jfNewProduct.add(productArticleLabel, new GridBagConstraints(
				0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productArticleTextField, new GridBagConstraints(
				1, 2, 2, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productGroupLabel, new GridBagConstraints(
				0, 3, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productGroupComboBox, new GridBagConstraints(
				1, 3, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productUnitOfMeasureLabel, new GridBagConstraints(
				2, 3, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productUnitOfMeasureTextField, new GridBagConstraints(
				3, 3, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,10), 0, 0));
		jfNewProduct.add(productPrimeCostLabel, new GridBagConstraints(
				0, 4, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productPrimeCostTextField, new GridBagConstraints(
				1, 4, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productConsumerPriceLabel, new GridBagConstraints(
				2, 4, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productConsumerPriceTextField, new GridBagConstraints(
				3, 4, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,10), 0, 0));
		jfNewProduct.add(productDescriptionLabel, new GridBagConstraints(
				0, 5, 1, 3, 1.0, 1.0, GridBagConstraints.LINE_START,
				GridBagConstraints.BOTH, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productDescriptionTextArea, new GridBagConstraints(
				1, 5, 3, 3, 1.0, 1.0, GridBagConstraints.LINE_START,
				GridBagConstraints.BOTH, new Insets(2,2,2,10), 0, 0));
		jfNewProduct.add(saveButton, new GridBagConstraints(
				4, 8, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_END,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,10), 0, 0));
		jfNewProduct.add(exitButton, new GridBagConstraints(
				4, 9, 1, 1, 0.0, 0.0, GridBagConstraints.LAST_LINE_END,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,10,10), 0, 0));

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (productNameTextField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(jfNewProduct,
							"Пожалуйста, укажите наименование товара!");
					return;
				}
				if (productPrimeCostTextField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(jfNewProduct,
							"Пожалуйста, укажите цену закупки!");
					return;
				}
				if (productConsumerPriceTextField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(jfNewProduct,
							"Пожалуйста, укажите цену продажи!");
					return;
				}
				if (Double.parseDouble(productConsumerPriceTextField.getText().trim()) <
						Double.parseDouble(productPrimeCostTextField.getText().trim())) {
					JOptionPane.showMessageDialog(jfNewProduct,
							"Цена продажи меньше цены закупки!"
							+ "\nПожалуйста, проверьте указанные цены!",
							"Сообщение", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(!productBarcodeTextField.getText().trim().isEmpty()) {
					if(JDBC.ValueUnicityTest("product", "barcode",
							productBarcodeTextField.getText().trim())) {
						JOptionPane.showMessageDialog(jfNewProduct,
								"Пожалуйста, проверьте указанный штрих код!"
								+ "\nТовар с таким штрих кодом уже существует!",
								"Сообщение", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if (productIdTextField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(jfNewProduct,
							"Пожалуйста, укажите код товара!");
					return;
				} else {
					if(JDBC.ValueUnicityTest("product", "product_id",
						productIdTextField.getText().trim())) {
						Object[] idOptions = {"Обновить", "Отмена"};
						int idReply = JOptionPane.showOptionDialog(jfNewProduct,
							"Товар с таким кодом уже существует!"
							+ "\nОбновите, пожалуйста, код товара",
							"Сообщение", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null,
							idOptions, idOptions[0]);
						if(idReply == 0) {
							productIdTextField.setText(
									Integer.toString(
											JDBC.getMaxId("product") + 1));
						} else if(idReply == 1) {
							return;
						}
					}
				}
				if(!productArticleTextField.getText().trim().isEmpty()) {
					if(JDBC.ValueUnicityTest("product", "article",
							productArticleTextField.getText().trim())) {
						Object[] articleOptions = {"Сохранить", "Отмена"};
						int articleReply = JOptionPane.showOptionDialog(jfNewProduct,
								"Товар с таким артикулом уже существует!"
								+ "\nПродолжить сохранение?", "Сообщение",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null, articleOptions, articleOptions[1]);
							if(articleReply == 0) {
									Product newProduct =
											getProductInfo(productNameTextField,
											productIdTextField, productBarcodeTextField,
											productArticleTextField, productGroupComboBox,
											productUnitOfMeasureTextField,
											productPrimeCostTextField,
											productConsumerPriceTextField,
											productDescriptionTextArea);
									JDBC.setNewProduct(newProduct);
									try {
										jfNewProduct.setClosed(true);
									} catch (PropertyVetoException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							} else if(articleReply == 1) {
								return;
							}
					} else {
						Product newProduct =
								getProductInfo(productNameTextField,
								productIdTextField, productBarcodeTextField,
								productArticleTextField, productGroupComboBox,
								productUnitOfMeasureTextField,
								productPrimeCostTextField,
								productConsumerPriceTextField,
								productDescriptionTextArea);
						JDBC.setNewProduct(newProduct);
						try {
							jfNewProduct.setClosed(true);
						} catch (PropertyVetoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else {
					Product newProduct =
							getProductInfo(productNameTextField,
							productIdTextField, productBarcodeTextField,
							productArticleTextField, productGroupComboBox,
							productUnitOfMeasureTextField,
							productPrimeCostTextField,
							productConsumerPriceTextField,
							productDescriptionTextArea);
					JDBC.setNewProduct(newProduct);
					try {
						jfNewProduct.setClosed(true);
					} catch (PropertyVetoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
			}
		});

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					jfNewProduct.setClosed(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			}
		});

		jfNewProduct.setVisible(true);
		jfNewProduct.pack();
		jdpDesktop.add(jfNewProduct);
		try {
			jfNewProduct.setSelected(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	//creates an internal jframe to add info about new supplier
	public static void createUINewSupplier() {
		final JInternalFrame jfNewSupplier = new JInternalFrame(
				"Новый поставщик", true, true, true, true);
		jfNewSupplier.setSize(600,400);
		jfNewSupplier.setLocation(xPosition * (openFrameCount),
				yPosition * openFrameCount);
		jfNewSupplier.setLayout(new GridBagLayout());
		
		if(openFrameCount++>9) openFrameCount = 0;
		
		JButton saveButton = new JButton("Сохранить");
		JButton exitButton = new JButton("Отмена");
		
		JLabel supplierNameLabel = new JLabel("Наименование предприятия: ");
		JLabel supplierIdLabel = new JLabel("Код", SwingConstants.CENTER);
		JLabel supplierAddressLabel = new JLabel("Адрес: ");
		JLabel supplierPhoneNumberLabel = new JLabel("Телефон: ");
		JLabel supplierFaxLabel = new JLabel("Факс: ", SwingConstants.RIGHT);
		JLabel supplierAccountCurrentLabel = new JLabel("р/с: ");
		JLabel supplierBankLabel = new JLabel("Обслуживающий банк: ");
		JLabel supplierBankCodeLabel = new JLabel("МФО банка: ");
		JLabel supplierCodeEDRPOULabel = new JLabel("Код ЕГРПОУ: ");
		JLabel supplierINNLabel = new JLabel("Код ИНН: ");
		JLabel supplierExtraInfoLabel = new JLabel("Дополнительные сведения: ");
		
		final JTextField supplierNameTextField = new JTextField(10);
		final JTextField supplierIdTextField = new JTextField(10);
		final JTextField supplierAddressTextField = new JTextField(10);
		final JTextField supplierPhoneNumberTextField = new JTextField(10);
		final JTextField supplierFaxTextField = new JTextField(10);
		final JTextField supplierAccountCurrentTextField = new JTextField(10);
		final JTextField supplierBankTextField = new JTextField(10);
		final JTextField supplierBankCodeTextField = new JTextField(10);
		final JTextField supplierCodeEDRPOUTextField = new JTextField(10);
		final JTextField supplierINNTextField = new JTextField(10);
		final JTextArea supplierExtraInfoTextArea = new JTextArea(4, 30);
		
		setTextLimit(supplierNameTextField, NameSymbolCount);
		checkAndLimitTextOnDigits(supplierIdTextField, codeDigitsCount);
		supplierIdTextField.setText(Integer.toString(JDBC.getMaxId("supplier") + 1));
		supplierIdTextField.setHorizontalAlignment(JTextField.RIGHT);
		setTextLimit(supplierAddressTextField, AddressSymbolCount);
		setTextLimit(supplierPhoneNumberTextField, PhoneFaxSymbolCount);
		setTextLimit(supplierFaxTextField, PhoneFaxSymbolCount);
		checkAndLimitTextOnDigits(supplierAccountCurrentTextField,
				accountDigitsCount);
		setTextLimit(supplierBankTextField, bankNameSymbolCount);
		checkAndLimitTextOnDigits(supplierBankCodeTextField,
				bankCodeDigitsCount);
		checkAndLimitTextOnDigits(supplierCodeEDRPOUTextField,
				codeEDRPOUdigitsCount);
		checkAndLimitTextOnDigits(supplierINNTextField,
				codeINNdigitsCount);
		setTextLimit(supplierExtraInfoTextArea, extraInfoSymbolCount);
		supplierExtraInfoTextArea.setLineWrap(true);
		supplierExtraInfoTextArea.setWrapStyleWord(true);
		
		jfNewSupplier.add(supplierNameLabel, new GridBagConstraints(
				0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.FIRST_LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(10,10,2,2), 0, 0));
		jfNewSupplier.add(supplierNameTextField, new GridBagConstraints(
				1, 0, 3, 1, 1.0, 0.0, GridBagConstraints.FIRST_LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(10,2,2,20), 0, 0));
		jfNewSupplier.add(supplierIdLabel, new GridBagConstraints(
				4, 0, 1, 1, 1.0, 0.0, GridBagConstraints.FIRST_LINE_END,
				GridBagConstraints.HORIZONTAL, new Insets(10,10,2,10), 0, 0));
		jfNewSupplier.add(supplierAddressLabel, new GridBagConstraints(
				0, 1, 1, 3, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.BOTH, new Insets(2,10,2,2), 0, 0));
		jfNewSupplier.add(supplierAddressTextField, new GridBagConstraints(
				1, 1, 3, 3, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.BOTH, new Insets(2,2,2,20), 0, 0));
		jfNewSupplier.add(supplierIdTextField, new GridBagConstraints(
				4, 1, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_END,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,10), 0, 0));
		jfNewSupplier.add(supplierPhoneNumberLabel, new GridBagConstraints(
				0, 4, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewSupplier.add(supplierPhoneNumberTextField, new GridBagConstraints(
				1, 4, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewSupplier.add(supplierFaxLabel, new GridBagConstraints(
				2, 4, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewSupplier.add(supplierFaxTextField, new GridBagConstraints(
				3, 4, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,20), 0, 0));
		jfNewSupplier.add(supplierAccountCurrentLabel, new GridBagConstraints(
				0, 5, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewSupplier.add(supplierAccountCurrentTextField, new GridBagConstraints(
				1, 5, 3, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,20), 0, 0));
		jfNewSupplier.add(supplierBankLabel, new GridBagConstraints(
				0, 6, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewSupplier.add(supplierBankTextField, new GridBagConstraints(
				1, 6, 3, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,20), 0, 0));
		jfNewSupplier.add(supplierBankCodeLabel, new GridBagConstraints(
				0, 7, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewSupplier.add(supplierBankCodeTextField, new GridBagConstraints(
				1, 7, 3, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,20), 0, 0));
		jfNewSupplier.add(supplierCodeEDRPOULabel, new GridBagConstraints(
				0, 8, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewSupplier.add(supplierCodeEDRPOUTextField, new GridBagConstraints(
				1, 8, 3, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,20), 0, 0));
		jfNewSupplier.add(supplierINNLabel, new GridBagConstraints(
				0, 9, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewSupplier.add(supplierINNTextField, new GridBagConstraints(
				1, 9, 3, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,20), 0, 0));
		jfNewSupplier.add(supplierExtraInfoLabel, new GridBagConstraints(
				0, 10, 3, 3, 1.0, 1.0, GridBagConstraints.LINE_START,
				GridBagConstraints.BOTH, new Insets(2,10,2,2), 0, 0));
		jfNewSupplier.add(supplierExtraInfoTextArea, new GridBagConstraints(
				1, 10, 3, 3, 1.0, 1.0, GridBagConstraints.LINE_START,
				GridBagConstraints.BOTH, new Insets(2,2,10,20), 0, 0));
		jfNewSupplier.add(saveButton, new GridBagConstraints(
				4, 13, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_END,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,10), 0, 0));
		jfNewSupplier.add(exitButton, new GridBagConstraints(
				4, 14, 1, 1, 0.0, 0.0, GridBagConstraints.LAST_LINE_END,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,10,10), 0, 0));

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(!supplierAccountCurrentTextField.getText().trim().isEmpty()) {
					if(JDBC.ValueUnicityTest("supplier", "supplier_account_current",
							supplierAccountCurrentTextField.getText().trim())) {
						JOptionPane.showMessageDialog(jfNewSupplier,
								"Пожалуйста, проверьте указанный расчётный счёт!"
								+ "\nПредприятие с таким р/с уже существует!",
								"Сообщение", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if(!supplierCodeEDRPOUTextField.getText().trim().isEmpty()) {
					if(JDBC.ValueUnicityTest("supplier", "supplier_edrpou_code",
							supplierCodeEDRPOUTextField.getText().trim())) {
						JOptionPane.showMessageDialog(jfNewSupplier,
								"Пожалуйста, проверьте указанный код ЕГРПОУ!"
								+ "\nПредприятие с таким кодом ЕГРПОУ уже существует!",
								"Сообщение", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if(!supplierINNTextField.getText().trim().isEmpty()) {
					if(JDBC.ValueUnicityTest("supplier", "supplier_inn",
							supplierINNTextField.getText().trim())) {
						JOptionPane.showMessageDialog(jfNewSupplier,
								"Пожалуйста, проверьте указанный код ИНН!"
								+ "\nПредприятие с таким кодом ИНН уже существует!",
								"Сообщение", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if (supplierIdTextField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(jfNewSupplier,
							"Пожалуйста, укажите код предприятия!");
					return;
				} else {
					if(JDBC.ValueUnicityTest("supplier", "supplier_id",
							supplierIdTextField.getText().trim())) {
						Object[] idOptions = {"Обновить", "Отмена"};
						int idReply = JOptionPane.showOptionDialog(jfNewSupplier,
							"Поставщик с таким кодом уже существует!"
							+ "\nОбновите, пожалуйста, код предприятия",
							"Сообщение", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null,
							idOptions, idOptions[0]);
						if(idReply == 0) {
							supplierIdTextField.setText(
									Integer.toString(
											JDBC.getMaxId("product") + 1));
						} else if(idReply == 1) {
							return;
						}
					}
				}
				if (supplierNameTextField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(jfNewSupplier,
							"Пожалуйста, укажите наименование предприятия!");
					return;
				} else {
					if(JDBC.ValueUnicityTest("supplier", "supplier_name",
							supplierNameTextField.getText().trim())) {
						Object[] supplierNameOptions = {"Сохранить", "Отмена"};
						int supplierNameReply = JOptionPane.showOptionDialog(jfNewSupplier,
								"Поставщик с таким наименованием уже существует!"
								+ "\nПродолжить сохранение?", "Сообщение",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null, supplierNameOptions, supplierNameOptions[1]);
							if(supplierNameReply == 0) {
								ShopSupplier newSupplier =
										getSupplierInfo(supplierNameTextField,
											supplierIdTextField,
											supplierAddressTextField,
											supplierPhoneNumberTextField,
											supplierFaxTextField,
											supplierAccountCurrentTextField,
											supplierBankTextField,
											supplierBankCodeTextField,
											supplierCodeEDRPOUTextField,
											supplierINNTextField,
											supplierExtraInfoTextArea);
								JDBC.insertIntoShopSupplier(newSupplier);
								try {
									jfNewSupplier.setClosed(true);
								} catch (PropertyVetoException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						} else if(supplierNameReply == 1) {
								return;
							}
					} else {
						ShopSupplier newSupplier =
								getSupplierInfo(supplierNameTextField,
									supplierIdTextField,
									supplierAddressTextField,
									supplierPhoneNumberTextField,
									supplierFaxTextField,
									supplierAccountCurrentTextField,
									supplierBankTextField,
									supplierBankCodeTextField,
									supplierCodeEDRPOUTextField,
									supplierINNTextField,
									supplierExtraInfoTextArea);
						JDBC.insertIntoShopSupplier(newSupplier);
						try {
							jfNewSupplier.setClosed(true);
						} catch (PropertyVetoException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					jfNewSupplier.setClosed(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
			}
		});

		jfNewSupplier.setVisible(true);
		jfNewSupplier.pack();
		jdpDesktop.add(jfNewSupplier);
		try {
			jfNewSupplier.setSelected(true);
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
				if (str != null && (getLength() + str.length()) < k+1) {
					super.insertString(offset, str, attr);
				}
			}
		});
	}

	//This method checks whether the input data is a positive double 
	//with specified number = k of digits
	public static void checkTextOnDouble(JTextComponent text, final int k) {
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
                        if (dotCount > 1) {
                            return;
                        }
                    }
                }
                if (getText(0, getLength()).indexOf('.') != -1 && dotCount != 0) {
                    return;
                }
                if (getLength() + str.length() < k+1) {
                    super.insertString(offset, str, attr);
                }
			}
		});
	}

	//This method checks whether the input data is
	// a certain number = k of digits
	public static void checkAndLimitTextOnDigits(JTextComponent text,
													final int k) {
		text.setDocument(new PlainDocument() {
			String chars = "0123456789";
			
			@Override
			public void insertString(int offset, String str,
					AttributeSet attr) throws BadLocationException {
				for (int i = 0; i < str.length(); i++) {
                    if (chars.indexOf(str.charAt(i)) == -1) {
                        return;
                    }
                }
                if (getLength() + str.length() < k+1) {
                    super.insertString(offset, str, attr);
                }
			}
		});
	}

	//gets text from text fields and set it into db product table
	public static Product getProductInfo(JTextField name,
			JTextField id, JTextField barcode, JTextField article,
			JComboBox<String> group, JTextField unitOfMeasure,
			JTextField primeCost, JTextField consumerPrice,
			JTextArea description){
		Product newProduct = new Product();
		if(!id.getText().trim().isEmpty()) {
		newProduct.setId(Integer.parseInt(id.getText()));
		}
		if(!barcode.getText().trim().isEmpty()) {
		newProduct.setBarcode(barcode.getText());
		}
		if(!article.getText().trim().isEmpty()) {
		newProduct.setArticle(article.getText());
		}
		if(!((String)group.getSelectedItem()).trim().isEmpty()) {
		newProduct.setProductGroup((String)group.getSelectedItem());
		}
		if(!name.getText().trim().isEmpty()) {
		newProduct.setProductName(name.getText());
		}
		if(!unitOfMeasure.getText().trim().isEmpty()) {
		newProduct.setUnitOfMeasure(unitOfMeasure.getText());
		}
		if(!primeCost.getText().trim().isEmpty()) {
		newProduct.setPrimeCost(Double.parseDouble(primeCost.getText()));
		}
		if(!consumerPrice.getText().trim().isEmpty()) {
		newProduct.setConsumerPrice(Double.parseDouble(consumerPrice.getText()));
		}
		if(!description.getText().trim().isEmpty()) {
		newProduct.setDescription(description.getText());
		}
		return newProduct;
	}

	//gets text from text fields and set it into db supplier table
	public static ShopSupplier getSupplierInfo(JTextField name,
			JTextField id, JTextField address, JTextField phone,
			JTextField fax, JTextField accountCurrent,
			JTextField bank, JTextField bankCode,
			JTextField codeEDRPOU, JTextField codeINN,
			JTextArea extraInfo){
		ShopSupplier newSupplier = new ShopSupplier();
		if(!id.getText().trim().isEmpty()) {
			newSupplier.setId(Integer.parseInt(id.getText()));
		}
		if(!name.getText().trim().isEmpty()) {
			newSupplier.setBusinessName(name.getText());
		}
		if(!address.getText().trim().isEmpty()) {
			newSupplier.setAddress(address.getText());
		}
		if(!phone.getText().trim().isEmpty()) {
			newSupplier.setPhoneNumber(phone.getText());
		}
		if(!fax.getText().trim().isEmpty()) {
			newSupplier.setFax(fax.getText());
		}
		if(!accountCurrent.getText().trim().isEmpty()) {
			newSupplier.setAccountCurrent(accountCurrent.getText());
		}
		if(!bank.getText().trim().isEmpty()) {
			newSupplier.setBank(bank.getText());
		}
		if(!bankCode.getText().trim().isEmpty()) {
			newSupplier.setBankCode(bankCode.getText());
		}
		if(!codeEDRPOU.getText().trim().isEmpty()) {
			newSupplier.setCodeEDRPOU(codeEDRPOU.getText());
		}
		if(!codeINN.getText().trim().isEmpty()) {
			newSupplier.setInn(codeINN.getText());
		}
		if(!extraInfo.getText().trim().isEmpty()) {
			newSupplier.setExtraInformation(extraInfo.getText());
		}
		return newSupplier;
	}

}
