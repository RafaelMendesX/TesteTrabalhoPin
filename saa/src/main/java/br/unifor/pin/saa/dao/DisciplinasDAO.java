package br.unifor.pin.saa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Disciplinas;
import br.unifor.pin.saa.exceptions.DAOException;

/**
 * @author rafael.mendes
 * 
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class DisciplinasDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Disciplinas disciplinas){
		entityManager.persist(disciplinas);
	}

	
	public void atualizar(Disciplinas disciplinas){
		entityManager.merge(disciplinas);
	}
	
	@SuppressWarnings("unchecked")
	public List<Disciplinas> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Disciplinas> criteriaQuery = criteriaBuilder.createQuery(Disciplinas.class);
		Root<Disciplinas> disciplinas = criteriaQuery.from(Disciplinas.class);
		criteriaQuery.where(criteriaBuilder.like(disciplinas.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	public Disciplinas buscaPorId(Integer id) throws DAOException {
		String jpql = "select d from Disciplinas d where d.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		
		try {
			return (Disciplinas) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		} 
	}
	
	public void excluir(Disciplinas disciplinas){
		entityManager.remove(disciplinas);
	}
}
