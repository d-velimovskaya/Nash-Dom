package fabrikaProjectNashDom;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UINashDom {
	static JDesktopPane jdpDesktop;
	static int openFrameCount = 0;
	static final int xPosition = 20, yPosition = 20;

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
	
	public static JMenuBar createMenuBar() {
		JMenuBar menubar = new JMenuBar();
		
		JMenu productsMenu = new JMenu("Товары");
		JMenu supplyMenu = new JMenu("Приходы");
		JMenu buttonSlip = new JMenu("Новый чек");
		JMenu reportsMenu = new JMenu("Отчёты");
		
		JMenuItem addProductItemMenu = new JMenuItem("Добавить товар");
		JMenuItem stockItemMenu = new JMenuItem("Остатки товара");
		JMenuItem addSupplyItemMenu = new JMenuItem("Добавить приход");
		JMenuItem addSupplierItemMenu = new JMenuItem("Добавить поставщика");
		JMenuItem reportProductsItemMenu = new JMenuItem("Отчёт по товарам");
		JMenuItem reportSuppliesItemMenu = new JMenuItem("Отчёт по приходам");
		JMenuItem reportSalesItemMenu = new JMenuItem("Отчёт по продажам");
		JMenuItem reportSuppliersItemMenu = new JMenuItem("Отчёт по поставщикам");

		productsMenu.add(addProductItemMenu);
		productsMenu.add(stockItemMenu);
		supplyMenu.add(addSupplyItemMenu);
		supplyMenu.add(addSupplierItemMenu);
		reportsMenu.add(reportProductsItemMenu);
		reportsMenu.add(reportSuppliesItemMenu);
		reportsMenu.add(reportSalesItemMenu);
		reportsMenu.add(reportSuppliersItemMenu);

		menubar.add(productsMenu);
		menubar.add(supplyMenu);
		menubar.add(buttonSlip);
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
	
	public static void createUINewProduct() {
		final JInternalFrame jfNewProduct = new JInternalFrame(
				"Новый товар", true, true, true, true);
		jfNewProduct.setSize(700,400);
		jfNewProduct.setLocation(xPosition * (++openFrameCount),
				yPosition * openFrameCount);
		jfNewProduct.setLayout(new GridBagLayout());
		
		JButton saveButton = new JButton("Сохранить");
		JButton exitButton = new JButton("Отмена");
		
		JLabel productIdLabel = new JLabel("Id товара: ");
		JLabel productBarcodeLabel = new JLabel("Штрихкод: ");
		JLabel productArticleLabel = new JLabel("Артикул: ");
		JLabel productGroupLabel = new JLabel("Группа товаров: ");
		JLabel productNameLabel = new JLabel("Наименование товара: ");
		JLabel productUnitOfMeasureLabel = new JLabel("Единица измерения: ");
		JLabel productPrimeCostLabel = new JLabel("Цена закупки: ");
		JLabel productConsumerPriceLabel = new JLabel("Цена продажи: ");
		JLabel productDescriptionLabel = new JLabel("Описание: ");
		
		JTextField productIdTextField = new JTextField(15);
		JTextField productBarcodeTextField = new JTextField(15);
		JTextField productArticleTextField = new JTextField(15);
		JTextField productGroupTextField = new JTextField(15);
		JTextField productNameTextField = new JTextField(15);
		JTextField productUnitOfMeasureTextField = new JTextField("шт.", 15);
		JTextField productPrimeCostTextField = new JTextField(15);
		JTextField productConsumerPriceTextField = new JTextField(15);
		JTextArea productDescriptionTextArea = new JTextArea(3, 30);
		
		productDescriptionTextArea.setLineWrap(true);
		
		jfNewProduct.add(productIdLabel, new GridBagConstraints(
				0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10,10,2,2), 0, 0));
		jfNewProduct.add(productBarcodeLabel, new GridBagConstraints(
				0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productArticleLabel, new GridBagConstraints(
				0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productGroupLabel, new GridBagConstraints(
				0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productNameLabel, new GridBagConstraints(
				0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productUnitOfMeasureLabel, new GridBagConstraints(
				0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productPrimeCostLabel, new GridBagConstraints(
				0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productConsumerPriceLabel, new GridBagConstraints(
				0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productDescriptionLabel, new GridBagConstraints(
				0, 8, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(2,10,2,2), 0, 0));
		jfNewProduct.add(productIdTextField, new GridBagConstraints(
				1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(10,2,2,2), 0, 0));
		jfNewProduct.add(productBarcodeTextField, new GridBagConstraints(
				1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productArticleTextField, new GridBagConstraints(
				1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productGroupTextField, new GridBagConstraints(
				1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productNameTextField, new GridBagConstraints(
				1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productUnitOfMeasureTextField, new GridBagConstraints(
				1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productPrimeCostTextField, new GridBagConstraints(
				1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productConsumerPriceTextField, new GridBagConstraints(
				1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(productDescriptionTextArea, new GridBagConstraints(
				1, 8, 2, 3, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,2), 0, 0));
		jfNewProduct.add(saveButton, new GridBagConstraints(
				2, 11, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTH,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,2,10), 0, 0));
		jfNewProduct.add(exitButton, new GridBagConstraints(
				2, 12, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTH,
				GridBagConstraints.HORIZONTAL, new Insets(2,2,10,10), 0, 0));

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					jfNewProduct.setClosed(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jfNewProduct.setVisible(true);
		jdpDesktop.add(jfNewProduct);
		try {
			jfNewProduct.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
