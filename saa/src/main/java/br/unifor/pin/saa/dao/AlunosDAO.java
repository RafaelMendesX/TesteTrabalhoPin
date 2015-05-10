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

import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.exceptions.DAOException;


@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class AlunosDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Alunos alunos){
		entityManager.persist(alunos);
	}

	
	public void atualizar(Alunos alunos){
		entityManager.merge(alunos);
	}
	
	@SuppressWarnings("unchecked")
	public List<Alunos> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Alunos> criteriaQuery = criteriaBuilder.createQuery(Alunos.class);
		Root<Alunos> alunos = criteriaQuery.from(Alunos.class);
		criteriaQuery.where(criteriaBuilder.like(alunos.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	public Alunos buscaPorId(Integer id) throws DAOException {
		String jpql = "select a from Alunos a where a.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		
		try {
			return (Alunos) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		} 
	}
	
	public void excluir(Alunos alunos){
		entityManager.remove(alunos);
	}
}
