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

import br.unifor.pin.saa.entity.Cursos;
import br.unifor.pin.saa.exceptions.DAOException;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CursosDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Cursos cursos){
		entityManager.persist(cursos);
	}
	
	public void atualizar(Cursos cursos){
		entityManager.merge(cursos);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cursos> listarPorNome(String nome) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cursos> criteriaQuery = criteriaBuilder.createQuery(Cursos.class);
		Root<Cursos> curso = criteriaQuery.from(Cursos.class);
		criteriaQuery.where(criteriaBuilder.like(curso.<String>get("nome"), "%"+nome+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public Cursos buscaPorId(Integer id) throws DAOException {
		String jpql = "select c from Cursos c where c.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		
		try {
			return (Cursos) query.getSingleResult();
		} catch(NoResultException e){
			return null;
		} 
	}
	
	public void excluir(Cursos cursos){
		entityManager.remove(cursos);
	}
}
