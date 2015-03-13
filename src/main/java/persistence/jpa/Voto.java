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
	 private Tema tema_id;
}
