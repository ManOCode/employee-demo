package moc.employee.util;

import moc.employee.dao.AbstractModel;

public class ModelUtils {

	public static boolean hasValue(AbstractModel model) {
		return !noValue(model);
	}

	public static boolean noValue(AbstractModel model) {
		return model == null || model.getId() == null;
	}

}