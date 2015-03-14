package persistence.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Voto {
	 @Id
	 @GeneratedValue
	 private Integer id;
	 
	 private Integer puntuacion;
	 private Integer estudios;
	 private String ip;
	 @ManyToOne
	 @JoinColumn
	 private Tema tema;
	 
	public Voto() {
	}
	
	public Voto(Integer puntuacion, Integer estudios, String ip, Tema tema) {
		this.puntuacion = puntuacion;
		this.estudios = estudios;
		this.ip = ip;
		this.tema = tema;
	}

	public Integer getId() {
		return id;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Integer getEstudios() {
		return estudios;
	}

	public void setEstudios(Integer estudios) {
		this.estudios = estudios;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	 
	 
}
