package Clases;

import java.util.ArrayList;

public class Listado_Carta {
ArrayList<Carta> lista;

public  Listado_Carta() {
	lista=new ArrayList<Carta>(); 
}
public void agregarCarta(Carta c) {
	lista.add(c);
}
}
