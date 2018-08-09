package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CartDAOImpl;
import com.niit.dao.CategoryDAOImpl;
import com.niit.dao.SupplierDAOImpl;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig 
{

	@Autowired
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/S190035");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		System.out.println("Data Source Object Created");
		
		return dataSource;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties properties=new Properties();
		/*properties.setProperty("hibernate.hbm2ddl.auto", "update");*/
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.hbm2ddl.auto","update");
		
		LocalSessionFactoryBuilder sessionFactoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		sessionFactoryBuilder.addProperties(properties);
		
		sessionFactoryBuilder.addAnnotatedClass(Category.class);
		sessionFactoryBuilder.addAnnotatedClass(Product.class);
		sessionFactoryBuilder.addAnnotatedClass(Supplier.class);
		sessionFactoryBuilder.addAnnotatedClass(CartItem.class);

		
		
		SessionFactory sessionFactory=sessionFactoryBuilder.buildSessionFactory();
		
		System.out.println("SessionFactory Object Created");
		
		return sessionFactory;
	}

	@Autowired
	@Bean(name = "categoryDaoImpl")
	public CategoryDAOImpl getCategoryData(SessionFactory sf) {
		return new CategoryDAOImpl(sf);
	}
		
		@Autowired
		@Bean(name = "supplierDaoImpl")
		public SupplierDAOImpl getSuppData(SessionFactory sf) {
			return new SupplierDAOImpl(sf);
		
	}
		@Autowired
		@Bean(name = "CartDAOImpl")
		public CartDAOImpl getUserData(SessionFactory sf) {
			return new CartDAOImpl();
		}
		
	@Autowired
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Hibernate Transaction Object Created");
		return new HibernateTransactionManager(sessionFactory);
	}
	
}
