package moc.employee.dao;

public interface AbstractDao<M extends AbstractModel> {

	public M findById(Long id);

	public void create(M model);

	public void update(M model);

	public void delete(M model);

}