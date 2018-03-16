package modelo;

public class Articulo {

	private String talla;
	private String genero;
	private String color;
	private String codigo;
	private String moda;
	private String provedor;
	private String procedencia;
	private int id;

	

	// Aqui hemos generado este constructor con boton derecho source generate
	// using
	// fields
	public Articulo(String talla, String genero, String color, String codigo,
			String moda, String provedor, String procedencia) {
		super();
		this.talla = talla;
		this.genero = genero;
		this.color = color;
		this.codigo = codigo;
		this.moda = moda;
		this.provedor = provedor;
		this.procedencia = procedencia;
	}

	// Aqui hemos generado con boton derecho generar getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Articulo() {

	}
	
	
	public String gettalla() {
		return talla;
	}

	public void settalla(String talla) {
		this.talla = talla;
	}

	public String getgenero() {
		return genero;
	}

	public void setgenero(String genero) {
		this.genero = genero;
	}

	public String getcolor() {
		return color;
	}

	public void setcolor(String color) {
		this.color = color;
	}

	public String getcodigo() {
		return codigo;
	}

	public void setcodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getmoda() {
		return moda;
	}

	public void setmoda(String moda) {
		this.moda = moda;
	}

	public String getprovedor() {
		return provedor;
	}

	public void setprovedor(String provedor) {
		this.provedor = provedor;
	}

	public String getprocedencia() {
		return procedencia;
	}

	public void setprocedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	// generamos en source ToString

	@Override
	public String toString() {
		return "Cliente [talla=" + talla + ", genero=" + genero + ", color="
				+ color + ", codigo=" + codigo + ", moda=" + moda
				+ ", provedor=" + provedor + ",procedencia=" + procedencia + "]";
	}

}
