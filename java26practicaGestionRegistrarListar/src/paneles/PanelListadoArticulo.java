package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import tableModels.TableModelArticulo;
import daos.ArticuloDAOImpl;
import daos.ArticuloDAO;
import modelo.Articulo;

public class PanelListadoArticulo extends JPanel implements ActionListener {

	private ArticuloDAO daoArticulo = new ArticuloDAOImpl();
	private Articulo[] articulos;
	JTable tabla;
	JButton botonBorrar = new JButton("Borrar");

	public PanelListadoArticulo() {

		this.add(new JLabel("Soy el panel de listado de articulos"));
	}// end panel listado articulos

	public void refrescarArticulo() {
		this.articulos = daoArticulo.obtenerArticulo();
		tabla = new JTable(new TableModelArticulo(articulos));
		// en vez de agregar tabla agregar la JScroll barra
		tabla.setPreferredScrollableViewportSize(new Dimension(750, 500));
		tabla.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tabla);

		this.removeAll(); // quito todo lo que tuviera antes dentro del panel
		this.add(botonBorrar);
		this.add(scrollPane);

		// atender el boton borrar
		botonBorrar.addActionListener(this);
	}// end refrescar

	@Override
	public void actionPerformed(ActionEvent e) {
		if (tabla.getSelectedRow() == -1) {

			return;
		}
		JOptionPane.showConfirmDialog(null,
				"borrar: " + articulos[tabla.getSelectedRow()].toString());
		daoArticulo.borrarArticulo(articulos[tabla.getSelectedRow()].getId());
		refrescarArticulo();
		SwingUtilities.updateComponentTreeUI(this);

	}

}// end class
