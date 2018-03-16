package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;

public class ArticuloDAOImpl implements ArticuloDAO {

	private Connection miConexion = null;

	public ArticuloDAOImpl() {
		// preparo driver y conexion
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/practica_escritorio", "root",
					"jeveris");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver-libreria de mysql");
		} catch (SQLException e) {
			System.out.println("error de conexion o la sql esta mal");
		}

	}// end clientesDAOImpl

	@Override
	public void registrarArticulo(Articulo c) {

		// de esta forma le decimos a la base de datos que esta es la sql
		// que queremos lanzar con, en este caso 5 variables. Cuando le
		// digamos a la base de datos que es cada variable no se podra
		// inyectar sql, porque la base de datos espera variables del
		// tipo indicado: Por ejemplo la primera ? tiene que ser un nombre
		// valido
		// correspondiente al tipo de dato de nombre en la base de datos

		PreparedStatement ps;
		try {
			ps = miConexion
					.prepareStatement(ConstantesSQL.sqlInsercionArticulo);
			ps.setString(1, c.gettalla());
			ps.setString(2, c.getgenero());
			ps.setString(3, c.getcolor());
			ps.setString(4, c.getcodigo());
			ps.setString(5, c.getmoda());
			ps.setString(6, c.getprovedor());
			ps.setString(7, c.getprocedencia());

			ps.execute();
			ps.close();
			System.out.println("articulo insertado correctamente");
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		// Lo siguiente no vale por ser vulnerable a inyecciones sql:
		// statementInsercionCliente.executeUpdate(sqlInsercionCliente);
		// System.out.println("Inserción realizada correctamente");
		// statementInsercionCliente.close();

	}

	@Override
	public void borrarArticulo(int id) {
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.sqlBorradoArticulo);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("la sql de borrado esta mal");
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Articulo[] obtenerArticulo() {
		Articulo[] articulos = null;

		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.sqlSeleccionArticulo);
			// para sql tipo select debo usar el metodo execute Query
			ResultSet resultado = ps.executeQuery();
			List<Articulo> listArticulo = new ArrayList<Articulo>();
			// Next pasa al siguiente resultado de la base de datos que aun no
			// hemos procesado, si no hay ningun resultado mas devuelve false
			while (resultado.next()) {
				Articulo c = new Articulo();
				c.settalla(resultado.getString("talla"));
				c.setgenero(resultado.getString("genero"));
				c.setcolor(resultado.getString("color"));
				c.setcodigo(resultado.getString("codigo"));
				c.setmoda(resultado.getString("moda"));
				c.setprovedor(resultado.getString("provedor"));
				c.setprocedencia(resultado.getString("procedencia"));
				c.setId(resultado.getInt("id"));
				listArticulo.add(c);
			}// end while
				// transformar de list a array
			articulos = listArticulo.toArray(new Articulo[listArticulo.size()]);
		} catch (SQLException e) {
			System.out.println("fallo en la sql de seleccion de articulos");
			System.out.println(e.getMessage());
		}
		return articulos;
	}// end obtener clientes

}// end class
