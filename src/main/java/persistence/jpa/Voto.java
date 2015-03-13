package persistence.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Voto {
	 @Id
	 @GeneratedValue
	 private Integer id;
	 
	 private Integer puntuacion;
	 private Integer estudios;
	 private String ip;
	

}
