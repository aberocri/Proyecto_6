package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.CardLayout;

public class VistaApp extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public VistaApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 435);
		VistaPrincipal VistaPrincipal = new VistaPrincipal();

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPrincipal = new JMenu("Principal");
		menuBar.add(mnPrincipal);
		
		JMenu mnSubPrinpal = new JMenu("Principal");
		mnPrincipal.add(mnSubPrinpal);
		
		JMenu mnJuegos = new JMenu("Juegos");
		menuBar.add(mnJuegos);
		
		JMenu mnSubJuegos = new JMenu("Juegos");
		mnJuegos.add(mnSubJuegos);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		JMenu mnSubPrincipal = new JMenu("Perfil");
		mnPerfil.add(mnSubPrincipal);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.add(VistaPrincipal);
		contentPane.setLayout(new CardLayout(0, 0));

	}

}
