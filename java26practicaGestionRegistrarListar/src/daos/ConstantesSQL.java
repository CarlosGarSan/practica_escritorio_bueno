package daos;

public class ConstantesSQL {
	final static String sqlInsercionArticulo = "insert into tabla_articulo(talla, genero, color, codigo, moda, provedor, procedencia) values (?,?,?,?,?,?,?)";
	final static String sqlSeleccionArticulo = "select * from tabla_articulo";
	final static String sqlBorradoArticulo = "delete from tabla_articulo where id=?";
}
