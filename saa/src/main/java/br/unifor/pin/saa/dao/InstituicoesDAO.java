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

import br.unifor.pin.saa.entity.Instituicoes;
import br.unifor.pin.saa.exceptions.DAOException;



@Repository
@Transactional(propagation = Propagation.REQUIRED)

public class InstituicoesDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Instituicoes instituicoes) {
		entityManager.persist(instituicoes);
	}
	
	public void atualizar(Instituicoes instituicoes){
		entityManager.merge(instituicoes);
	}

	@SuppressWarnings("unchecked")
	public List<Instituicoes> listarPoriInstituicoes(String sigla) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Instituicoes> criteriaQuery = criteriaBuilder.createQuery(Instituicoes.class);
		Root<Instituicoes> instituicoes = criteriaQuery.from(Instituicoes.class);
		criteriaQuery.where(criteriaBuilder.like(instituicoes.<String>get("sigla"), "%"+sigla+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	public Instituicoes buscarporInstituicoes(String sigla) throws DAOException {
		String jpql = "select i from Instituicoes i where i.sigla = :sigla";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("sigla", sigla);
		
		try {
			return (Instituicoes) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		} 
	}
	
	public void excluir(Instituicoes instituicoes){
		entityManager.remove(instituicoes);
	}
}