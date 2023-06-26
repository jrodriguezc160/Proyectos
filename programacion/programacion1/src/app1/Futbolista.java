package app1;

import java.io.Serializable;

public class Futbolista implements Serializable{
	private String nomJugador;
	private int dorsal;
	private String posicion;
	private String codEquipo;

	public Futbolista(String nomJugador, int dorsal, String posicion, String codEquipo) {
		this.nomJugador = nomJugador;
		this.dorsal = dorsal;
		this.posicion = posicion;
		this.codEquipo = codEquipo;
	}

	// Getter y Setter
	
	// Nombre del jugador
	public String getNomJugador() {
		return nomJugador;
	}
	public void setNomJugador(String nomJugador) {
		this.nomJugador = nomJugador;
	}
	
	// Dorsal
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	// Posición
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	// codEquipo
	public String getCodEquipo() {
		return codEquipo;
	}
	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}
	
    // Método toString()
    @Override
    public String toString() {
        return "Futbolista{" +
                "nomJugador='" + nomJugador + '\'' +
                ", dorsal=" + dorsal +
                ", posicion='" + posicion + '\'' +
                ", codEquipo='" + codEquipo + '\'' +
                '}';
    }
}