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

import br.unifor.pin.saa.entity.Avaliacoes;
import br.unifor.pin.saa.exceptions.DAOException;


@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class AvaliacoesDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Avaliacoes avaliacoes){
		entityManager.persist(avaliacoes);
	}
	
	public void atualizar(Avaliacoes avaliacoes){
		entityManager.merge(avaliacoes);
	}
	
	@SuppressWarnings("unchecked")
	public List<Avaliacoes> listarPorNota(String notas) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Avaliacoes> criteriaQuery = criteriaBuilder.createQuery(Avaliacoes.class);
		Root<Avaliacoes> nota = criteriaQuery.from(Avaliacoes.class);
		criteriaQuery.where(criteriaBuilder.like(nota.<String>get("notas"), "%"+notas+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public Avaliacoes buscaPorId(Integer id) throws DAOException {
		String jpql = "select a from Avaliacoes a where a.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		
		try {
			return (Avaliacoes) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		} 
	}
	
	public void excluir(Avaliacoes aulas){
		entityManager.remove(aulas);
	}
}
