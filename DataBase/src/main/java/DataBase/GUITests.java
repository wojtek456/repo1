package DataBase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;

import java.awt.GridBagConstraints;
import javax.swing.JDesktopPane;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTree;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GUITests {

	private JFrame frame;
	private JTable table;
	private JTextField textFieldIDKlienta;
	private JTextField textFieldImie;
	private JTextField textFieldNazwisko;
	private JTextField textFieldMiejscowosc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUITests window = new GUITests();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public GUITests() throws SQLException, ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws SQLException, ClassNotFoundException {
		frame = new JFrame();
		frame.setBounds(100, 100, 955, 644);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		frame.getContentPane().setLayout(null);

		table = new JTable();
		table.setBounds(425, 73, 500, 407);
		frame.getContentPane().add(table);

		JButton btnLoadDatabase = new JButton("Load Klienci Data");
		btnLoadDatabase.addActionListener(new ActionListener() {
			private Component parentComponent;

			public void actionPerformed(ActionEvent e) {
				DataBaseSelect objSelect = new DataBaseSelect();
				objSelect.setSqlQuery("SELECT * FROM klienci");

				try {
					objSelect.execute();
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(parentComponent, "Nie uda³o siê pobraæ danych");
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(parentComponent, "Nie uda³o siê pobraæ danych");
					e1.printStackTrace();
				}
				table.setModel(DbUtils.resultSetToTableModel(objSelect.getResult()));

			}
		});
		btnLoadDatabase.setBounds(463, 28, 390, 32);
		frame.getContentPane().add(btnLoadDatabase);

		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String nazwisko = (String) comboBox.getSelectedItem();
				String query = "SELECT * FROM klienci WHERE nazwisko = " + "'" + nazwisko + "'";
				System.out.println(query);

				DataBaseSelect objSelect = new DataBaseSelect();
				objSelect.setSqlQuery(query);
				try {
					objSelect.execute();
					ResultSet rs = objSelect.getResult();
					// ResultSetMetaData metadane = rs.getMetaData();
					// System.out.println(metadane.getColumnCount());
					while (rs.next()) {
						textFieldIDKlienta.setText(rs.getString(1));
						textFieldImie.setText(rs.getString(2));
						textFieldNazwisko.setText(rs.getString(3));
						textFieldMiejscowosc.setText(rs.getString(4));
						System.out.println(rs.getString(2) + "---------");
					}
				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

				// textFieldIDKlienta.setText(imie);
			}
		});

		comboBox.setToolTipText("");
		comboBox.setBounds(12, 33, 195, 22);
		frame.getContentPane().add(comboBox);

		textFieldIDKlienta = new JTextField();
		textFieldIDKlienta.setBounds(209, 274, 173, 22);
		frame.getContentPane().add(textFieldIDKlienta);
		textFieldIDKlienta.setColumns(10);

		JLabel lblIdklienta = new JLabel("idklienta");
		lblIdklienta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdklienta.setBounds(47, 275, 67, 19);
		frame.getContentPane().add(lblIdklienta);

		textFieldImie = new JTextField();
		textFieldImie.setColumns(10);
		textFieldImie.setBounds(209, 309, 173, 22);
		frame.getContentPane().add(textFieldImie);

		textFieldNazwisko = new JTextField();
		textFieldNazwisko.setColumns(10);
		textFieldNazwisko.setBounds(209, 344, 173, 22);
		frame.getContentPane().add(textFieldNazwisko);

		textFieldMiejscowosc = new JTextField();
		textFieldMiejscowosc.setColumns(10);
		textFieldMiejscowosc.setBounds(209, 386, 173, 22);
		frame.getContentPane().add(textFieldMiejscowosc);

		JLabel lblImie = new JLabel("imie");
		lblImie.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblImie.setBounds(47, 310, 67, 19);
		frame.getContentPane().add(lblImie);

		JLabel lblNazwisko = new JLabel("nazwisko");
		lblNazwisko.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNazwisko.setBounds(47, 347, 79, 19);
		frame.getContentPane().add(lblNazwisko);

		JLabel lblMiejscowosc = new JLabel("miejscowosc");
		lblMiejscowosc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiejscowosc.setBounds(49, 387, 107, 19);
		frame.getContentPane().add(lblMiejscowosc);

		DataBaseSelect objSelect = new DataBaseSelect();
		objSelect.setSqlQuery("SELECT klienci.nazwisko FROM klienci");
		objSelect.execute();
		ResultSet rs = objSelect.getResult();

		while (rs.next()) {
			comboBox.addItem(rs.getString(1));
		}

	}
}
