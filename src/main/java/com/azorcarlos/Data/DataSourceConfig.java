package com.azorcarlos.Data;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_data?createDatabaseIfNotExist=true&useTimezone=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword(null);
		//Driver registrado automaticamente
		//dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
		return dataSource;
		
		
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		//MySQL57Dialect Versão do banco de dados
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL57Dialect");
		adapter.setPrepareConnection(true);
		
		return adapter;
		
	}
	
}
