package persistence.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Tema {
    public static final String TABLE = "tema";

    public static final String ID = "ID";
    @Id
    @GeneratedValue
    private Integer id;
    
    public static final String NOMBRE = "NOMBRE";
    private String nombre;
    
    public static final String PREGUNTA = "PREGUNTA";
    private String pregunta;
    
	public Tema() {
	}

	public Tema(String nombre, String pregunta) {
		this.nombre = nombre;
		this.pregunta = pregunta;
	}

	public Integer getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPregunta() {
		return pregunta;
	}
	
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	@Override
	public boolean equals(Object obj){
		assert obj != null;
		Tema other = (Tema) obj;
		return this.id.equals(other.id)&&this.nombre.equals(other.nombre)&&this.pregunta.equals(other.pregunta);
	}
}
