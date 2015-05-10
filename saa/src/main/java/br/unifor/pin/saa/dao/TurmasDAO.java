package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Turmas;
import br.unifor.pin.saa.exceptions.DAOException;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class TurmasDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Turmas turmas){
		entityManager.persist(turmas);
	}

	
	public void atualizar(Turmas turmas){
		entityManager.merge(turmas);
	}
	
	
	public Turmas buscaPorId(Integer id) throws DAOException {
		String jpql = "select p from Professores p where p.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		
		try {
			return (Turmas) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		} 
	}
	
	public void excluir(Turmas turmas){
		entityManager.remove(turmas);
	}
}
