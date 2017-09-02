package moc.employee.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDaoImpl<M extends AbstractModel> implements AbstractDao<M> {

	@Autowired
	SessionFactory sessionFactory;

	private Class<M> clazz;

	public AbstractDaoImpl(Class<M> clazz) {
		this.clazz = clazz;
	}

	@Override
	public M findById(Long id) {
		return (M) session().get(clazz, id);
	}

	@Override
	public void create(M model) {
		session().persist(model);
	}

	@Override
	public void update(M model) {
		session().saveOrUpdate(model);
	}

	@Override
	public void delete(M model) {
		session().delete(model);
	}

	protected Criteria createCriteria() {
		return session().createCriteria(clazz);
	}

	protected Criteria createCriteria(String alias) {
		return session().createCriteria(clazz, alias);
	}

	private Session session() {
		return sessionFactory.getCurrentSession();
	}

}