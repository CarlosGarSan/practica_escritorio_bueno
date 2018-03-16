package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.ArticuloDAOImpl;
import daos.ArticuloDAO;
import modelo.Articulo;

public class PanelRegistroArticulo extends JPanel implements ActionListener {

	JTextField campoTalla = new JTextField(15);
	JTextField campoGenero = new JTextField(15);
	JTextField campoColor = new JTextField(15);
	JTextField campoCodigo = new JTextField(15);
	JTextField campoModa = new JTextField(15);
	JTextField campoProvedor = new JTextField(15);
	JTextField campoProcedencia = new JTextField(15);

	public PanelRegistroArticulo() {

		// Asi asigno un gestor de diseño que me permite colocar
		// las cosas en forma de filas y celdas.
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		// primera fila:
		gbc.gridwidth = 2; // Es para que el Introduce los datos de los clientes
		// ocupe dos celdas
		gbc.gridy = 0;
		gbc.gridx = 0;
		this.add(new JLabel("Introduce los datos del articulo"), gbc);

		// dos columnas
		// Vuelvo a decir que cada componente ocupe un solo elemento
		gbc.gridwidth = 1;
		// segunda fila:
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("Talla:"), gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoTalla, gbc);
		// tercera fila:
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Genero:"), gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoGenero, gbc);
		// cuarta fila:
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("Color:"), gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoColor, gbc);
		// quinta fila:
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("Código:"), gbc);
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoCodigo, gbc);
		// sexta fila:
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("Moda:"), gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoModa, gbc);
		// septima fila:
		gbc.gridy = 6;
		gbc.gridx = 0;
		this.add(new JLabel("Provedor:"), gbc);
		gbc.gridy = 6;
		gbc.gridx = 1;
		this.add(campoProvedor, gbc);
		// Octava fila:
		gbc.gridy = 7;
		gbc.gridx = 0;
		this.add(new JLabel("Procedencia:"), gbc);
		gbc.gridy = 7;
		gbc.gridx = 1;
		this.add(campoProcedencia, gbc);

		// novena fila
		JButton botonRegistroArticulo = new JButton("Registrar");
		botonRegistroArticulo.addActionListener(this); // aqui es cuando hay que

		// implementar el action listener y posteriormente añadir metodos

		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroArticulo, gbc);

	} // end PanelRegistroCliente(); (constructor)

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed del panelRegistroArticulo");
		String Talla = campoTalla.getText();
		String Genero = campoGenero.getText();
		String Color = campoColor.getText();
		String Codigo = campoCodigo.getText();
		String Moda = campoModa.getText();
		String Provedor = campoProvedor.getText();
		String Procedencia = campoProcedencia.getText();

		// Ahora habría que validar estos datos
		// TODO
		// Una vez validados todos los datos registramos en base de datos:

		Articulo articuloAregistrar = new Articulo(Talla, Genero, Color,
				Codigo, Moda, Provedor, Procedencia);
		System.out.println("Voy a registrar: " + articuloAregistrar.toString());
		// invoco a lo necesario de la capa de dtos, para registrar el cliente
		// en base de datos
		ArticuloDAOImpl articuloDAO = new ArticuloDAOImpl();
		articuloDAO.registrarArticulo(articuloAregistrar);
		
		

	}// end actionPerformed
}// end class
