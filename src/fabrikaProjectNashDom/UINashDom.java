package fabrikaProjectNashDom;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class UINashDom {
	
	public static void createUINashDom() {
		JFrame frame = new JFrame("NashDom");
		frame.setSize(900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridBagLayout());
		
		JMenuBar menubar = new JMenuBar();
		
		JMenu productsMenu = new JMenu("������");
		JMenu supplyMenu = new JMenu("�������");
		JMenu buttonSlip = new JMenu("����� ���");
		JMenu reportsMenu = new JMenu("������");
		
		JMenuItem addProductItemMenu = new JMenuItem("�������� �����");
		JMenuItem stockItemMenu = new JMenuItem("������� ������");
		JMenuItem addSupplyItemMenu = new JMenuItem("�������� ������");
		JMenuItem addSupplierItemMenu = new JMenuItem("�������� ����������");
		JMenuItem reportProductsItemMenu = new JMenuItem("����� �� �������");
		JMenuItem reportSuppliesItemMenu = new JMenuItem("����� �� ��������");
		JMenuItem reportSalesItemMenu = new JMenuItem("����� �� ��������");
		JMenuItem reportSuppliersItemMenu = new JMenuItem("����� �� �����������");

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
				
			}
		});
		
		stockItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println(JDBC.selectAllNotNullProducts());
			}
		});
		
		addSupplyItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		
		addSupplierItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		
		reportProductsItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		reportSuppliesItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		
		reportSalesItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		
		reportSuppliersItemMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
			}
		});
		
		frame.setJMenuBar(menubar);
		frame.setVisible(true);
	}
}
