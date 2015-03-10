package persistence.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Tema {
    @Id
    @GeneratedValue
    private Integer id;
    
    private String nombre;
    private String pregunta;

}
