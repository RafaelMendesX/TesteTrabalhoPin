package br.unifor.pin.saa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.unifor.pin.saa.entity.Aulas;
import br.unifor.pin.saa.exceptions.DAOException;

public class AulasDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Aulas aulas){
		entityManager.persist(aulas);
	}

	
	public void atualizar(Aulas aulas){
		entityManager.merge(aulas);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aulas> listarPorTema(String temas) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Aulas> criteriaQuery = criteriaBuilder.createQuery(Aulas.class);
		Root<Aulas> tema = criteriaQuery.from(Aulas.class);
		criteriaQuery.where(criteriaBuilder.like(tema.<String>get("temas"), "%"+temas+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	public Aulas buscaPorId(Integer id) throws DAOException {
		String jpql = "select a from Aulas a where a.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		
		try {
			return (Aulas) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		} 
	}
	
	public void excluir(Aulas aulas){
		entityManager.remove(aulas);
	}
}
