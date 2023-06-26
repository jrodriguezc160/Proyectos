package app1;

import java.io.Serializable;

public class Equipo implements Serializable{
	private String nomEquipo;
	private String codEquipo;

	public Equipo(String nomEquipo, String codEquipo) {
		this.nomEquipo = nomEquipo;
		this.codEquipo = codEquipo;
	}

	// Getter y Setter
	
	// nomEquipo
	public String getNomEquipo() {
		return nomEquipo;
	}
	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
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
        return "Equipo{" +
                "nomEquipo='" + nomEquipo + '\'' +
                ", codEquipo='" + codEquipo + '\'' +
                '}';
    }
}