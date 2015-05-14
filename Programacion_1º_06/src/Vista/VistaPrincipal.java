package Vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import Modelo.UsuariosModel;

import java.awt.Font;
import java.awt.Panel;
import java.sql.SQLException;
import java.util.Iterator;

public class VistaPrincipal extends JPanel {
	private JPasswordField passwordField;
	UsuariosModel usuarios;
	/**
	 * Create the panel.
	 */
	public VistaPrincipal() {
		setLayout(null);
		
		JButton btnJuegos = new JButton("Juegos >");
		btnJuegos.setBounds(224, 21, 153, 23);
		add(btnJuegos);
		
		JButton btnPerfil = new JButton("Perfil >");
		btnPerfil.setBounds(224, 55, 153, 23);
		add(btnPerfil);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(28, 160, 46, 14);
		add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(28, 223, 81, 14);
		add(lblContrasea);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setEnabled(false);
		btnLogin.setBounds(28, 298, 146, 23);
		add(btnLogin);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setEnabled(false);
		btnRegistrarse.setBounds(28, 332, 146, 23);
		add(btnRegistrarse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(28, 248, 146, 20);
		add(passwordField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(28, 185, 146, 20);
		add(comboBox);
		
		Panel panel = new Panel();
		panel.setBounds(28, 10, 127, 144);
		add(panel);
		
		usuarios = new UsuariosModel();
		Iterator<String> it;
		try {
			it = usuarios.getUsuarios().iterator();
			while(it.hasNext()){
				comboBox.addItem((String)it.next());
		}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		}

	}
}
