package Clases;

public class Carta {
	public int Id;
	public String Nombre_Pedido;
	
	public Carta(int id, String nombre_Pedido) {
		super();
		Id = id;
		Nombre_Pedido = nombre_Pedido;
	}

	public Carta() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre_Pedido() {
		return Nombre_Pedido;
	}

	public void setNombre_Pedido(String nombre_Pedido) {
		Nombre_Pedido = nombre_Pedido;
	}
}
