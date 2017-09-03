package moc.employee.dao;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JUnitHibernateUtil {

	public static final String DRIVER_CLASS = "org.h2.Driver";

	public static final String DATABASE_URL = "jdbc:h2:./src/test/resources/hibernate_db";

	public static final String DIALECT = "org.hibernate.dialect.H2Dialect";

	public static final String SHOW_SQL = "true";

	public static final String HBM2DDL_AUTO = "create-drop";

	@Bean
	private static DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER_CLASS);
		dataSource.setUrl(DATABASE_URL);
		return dataSource;
	}

	private static Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put(AvailableSettings.DIALECT, DIALECT);
		properties.put(AvailableSettings.SHOW_SQL, SHOW_SQL);
		properties.put(AvailableSettings.HBM2DDL_AUTO, HBM2DDL_AUTO);
		return properties;
	}

	@Bean
	public static LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "moc.employee.dao" });
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}

	@Bean
	public static HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

}