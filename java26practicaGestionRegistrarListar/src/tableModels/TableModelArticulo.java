package tableModels;

import javax.swing.table.AbstractTableModel;

import modelo.Articulo;
import modelo.Articulo;

public class TableModelArticulo extends AbstractTableModel{

	private String[] columnas = {"talla", "genero","color", "codigo", "moda", "provedor", "procedencia" };
	
	private String[][] datos = null;
	
	public TableModelArticulo(Articulo[] articulos) {
		//Datos va a ser tantos arrays de strings como clientes tenga que listar
		//cada uno de esos array debera tener tantos elementos como
		//queremos mostrar por cada columna
		datos = new String[articulos.length] [columnas.length];
		for (int i = 0; i < articulos.length; i++) {
			Articulo c = articulos[i];
			datos[i][0]= c.gettalla();
			datos[i][1] =c.getgenero();
			datos[i][2] =c.getcolor();
			datos[i][3] =c.getcodigo();
			datos[i][4] =c.getmoda();
			datos[i][5] =c.getprovedor();
			datos[i][6] =c.getprocedencia();
			
		}
	}//end TableModelClientes
	
	
	@Override
	public String getColumnName(int indice) {
		// TODO Auto-generated method stub
		return columnas[indice];
		
	}


	@Override
	public int getColumnCount() {
		
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.length;
	}

	@Override
	public Object getValueAt(int indiceFila, int indiceColumna) {
		
		return datos[indiceFila][indiceColumna];
	}

}
