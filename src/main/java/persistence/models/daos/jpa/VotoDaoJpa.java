package persistence.models.daos.jpa;

import persistence.jpa.Voto;
import persistence.models.daos.VotoDao;

public class VotoDaoJpa  extends GenericDaoJpa<Voto, Integer> implements VotoDao {

	public VotoDaoJpa() {
		super(Voto.class);
	}

}
