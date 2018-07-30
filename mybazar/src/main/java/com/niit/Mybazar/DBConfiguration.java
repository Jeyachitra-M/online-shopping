package com.niit.Mybazar;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Model.CartItem;
import com.niit.Model.CategoryModel;
import com.niit.Model.OrderDetails;
import com.niit.Model.ProductModel;
import com.niit.Model.SupplierModel;
import com.niit.Model.UserModel;

@Configuration
@EnableTransactionManagement
public class DBConfiguration {


@Autowired
@Bean(name="data")
public DriverManagerDataSource getH2DataSource()
{
	DriverManagerDataSource data=new DriverManagerDataSource();
	data.setDriverClassName("org.h2.Driver");
    data.setUrl("jdbc:h2:tcp://localhost/~/test18");
    data.setUsername("sa");
    data.setPassword("");
    System.out.println("data source object created");
    return data;
}

@Autowired
@Bean(name="sessionfactory")
public SessionFactory getSessionFactory()
{
	Properties prop=new Properties();
	prop.put("hibernate.hbm2ddl.auto","update");
	prop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
    LocalSessionFactoryBuilder sessionfactorybuilder=new LocalSessionFactoryBuilder(getH2DataSource());
    System.out.println(sessionfactorybuilder);
    sessionfactorybuilder.addProperties(prop);
    sessionfactorybuilder.addAnnotatedClass(CategoryModel.class);
    sessionfactorybuilder.addAnnotatedClass(ProductModel.class);
    sessionfactorybuilder.addAnnotatedClass(SupplierModel.class);
    sessionfactorybuilder.addAnnotatedClass(UserModel.class);
    sessionfactorybuilder.addAnnotatedClass(CartItem.class);
    sessionfactorybuilder.addAnnotatedClass(OrderDetails.class);

    System.out.println("scanned");
    System.out.println(sessionfactorybuilder.buildSessionFactory());
    SessionFactory sessionfactory=sessionfactorybuilder.buildSessionFactory();
    System.out.println("session object created");
    return sessionfactory;
    }

@Autowired
@Bean
public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionfactory)
{
	System.out.println("Transaction created");
	return new HibernateTransactionManager(sessionfactory);
	}
}

