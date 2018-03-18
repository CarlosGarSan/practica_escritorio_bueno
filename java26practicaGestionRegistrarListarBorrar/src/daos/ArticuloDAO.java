package daos;

import modelo.Articulo;

//En entorno corporativo, lo mas normal del mundo es
//definir las operaciones que se van a poder hacer sobre
//base de datos en un interfaz

//En este caso, para el interfaz actual, cada metodo
//dira que se puede hacer en base de datos de cara a 
//clientes.

public interface ArticuloDAO {

		void registrarArticulo(Articulo c);
		void borrarArticulo(int id);
		Articulo[] obtenerArticulo();
		// un array es un conjunto de datos del mismo tipo
}
