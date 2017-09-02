package moc.employee.dao;

import java.util.List;

public interface LevelDao extends AbstractDao<LevelModel> {

	public static final Long LEVEL_MANAGER = 1L;

	public static final Long LEVEL_SENIOR = 2L;

	public static final Long LEVEL_JUNIOR = 3L;

	public List<LevelModel> list();

}