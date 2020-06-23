import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ZipSearchEx02 extends JFrame {

	private JPanel contentPane;
	String str = "";
	private JComboBox comboBox2;
	private JComboBox comboBox1;
	private JComboBox comboBox3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipSearchEx02 frame = new ZipSearchEx02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ZipSearchEx02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox1 = new JComboBox();
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				str = (String)comboBox1.getSelectedItem();
				//System.out.println(str);
				comboBox2.setModel(new CustomComboBoxModel(str));
			}
		});
		comboBox1.setModel(new CustomComboBoxModel());
		comboBox1.setBounds(12, 10, 128, 21);
		contentPane.add(comboBox1);
		
		comboBox2 = new JComboBox();
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				str = (String)comboBox2.getSelectedItem();
				comboBox3.setModel(new CustomComboBoxModel(0,str));
				
			}
		});
		//comboBox2.setModel(new CustomComboBoxModel(str));
		comboBox2.setBounds(152, 10, 128, 21);
		contentPane.add(comboBox2);
		
		comboBox3 = new JComboBox();
		
		comboBox3.setBounds(292, 10, 130, 21);
		contentPane.add(comboBox3);
	}
}
