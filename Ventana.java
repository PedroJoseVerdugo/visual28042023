package v28;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ConnectionBuilder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 542);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewBoton = new JButton("New button");
		btnNewBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton textfiled = null;
				AbstractButton btnBoton = null;
				btnBoton.setText(textfiled.getText());
			}
		});
		btnNewBoton.setForeground(SystemColor.textHighlight);
		btnNewBoton.setBounds(80, 91, 89, 23);
		contentPane.add(btnNewBoton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(39, 21, 215, 122);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(96, 36, 114, 46);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 184, 473, 297);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(20, 5, 239, 14);
		panel_1.add(lblNewLabel_1);
		
		JButton btnConectar = new JButton("New button");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//registrar el conector lblNewLabel_1.setText(rs.toString());
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String cadena="jdbc:mysql://localhost/test";
					Connection conn=DriveManager.getConnection(cadena,"root","");
					//consulta. craete, read, update, delete, CRUD
					PreparedStatement ps = null;
					try {
						ps = conn.prepareStatement("select * from clientes");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ResultSet rs = null;
					try {
						rs = ps.executeQuery();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//lblNewLabel_1.setText(rs.toString());
					String mensaje="";
					try {
						while(rs.next()) {
							mensaje+="-"+((ResultSet) rs).getString(2);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						try {
							lblNewLabel_1.setText(rs.getString(2));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				//cierra metodo
			}
		});
		btnConectar.setBounds(109, 44, 89, 23);
		panel_1.add(btnConectar);
	}
}
