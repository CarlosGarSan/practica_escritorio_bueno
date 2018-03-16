package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import paneles.PanelListadoArticulo;
import paneles.PanelRegistroArticulo;

public class VentanaPrincipal extends JFrame implements ActionListener {

	// Paneles de la ventana;

	private PanelRegistroArticulo panelRegistroArticulo = new PanelRegistroArticulo();
	private PanelListadoArticulo panelListadoArticulo = new PanelListadoArticulo();

	// Barra de menu:
	private JMenuBar barraDeMenu = new JMenuBar();
	private JMenu menuArticulo = new JMenu("Articulos");
	private JMenu menuAyuda = new JMenu("Ayuda");

	public VentanaPrincipal() {
		// preparar la barra de menu:
		JMenuItem articuloInsertar = new JMenuItem("Insertar articulo");
		JMenuItem articuloListar = new JMenuItem("Listar articulo");
		menuArticulo.add(articuloInsertar);
		menuArticulo.add(articuloListar);
		barraDeMenu.add(menuArticulo);
		// preparo la barra de ayuda
		barraDeMenu.add(menuAyuda);
		this.setJMenuBar(barraDeMenu);

		// Voy a decir a las opcioens de menu quien las va a atender cuando
		// Se les haga un click

		articuloInsertar.addActionListener(this);
		articuloListar.addActionListener(this);

		// preparacion de la ventana principal
		this.setSize(800, 600);
		this.setLocation(50, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Vamos a decir que cuando arranque esta ventana se muestre el panel
		// de registro cliente
		this.setContentPane(panelRegistroArticulo);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ATIENDO A" + e.getActionCommand());
		if (e.getActionCommand().equals("Insertar articulo")) {
			setContentPane(panelRegistroArticulo);
		} else if (e.getActionCommand().equals("Listar articulo")) {
			setContentPane(panelListadoArticulo);
			panelListadoArticulo.refrescarArticulo();
		}
		SwingUtilities.updateComponentTreeUI(this); //Para que me cambie el panel segun
		//pincho en las pestañas
	}
}