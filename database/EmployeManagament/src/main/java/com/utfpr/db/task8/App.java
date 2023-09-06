package com.utfpr.db.task8;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.utfpr.db.task8.service.DepFuncService;
import com.utfpr.db.task8.service.DepartamentoService;

@Configurable
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan(basePackages = "com.utfpr.db.task8")
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext ac = new AnnotationConfigApplicationContext(App.class);
    }
    
    @Bean
    @Order(1)
    public DataSource getDataSource() 
    {
        System.out.println(">>>>:: Iniciando conection factory com base de dados. Obtem conexão");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/company");
        dataSourceBuilder.username("dev");
        dataSourceBuilder.password("dev");

        return dataSourceBuilder.build();
    } // getDataSource

    @Bean
    @Order(2)
    public EntityManagerFactory entityManagerFactory() 
    {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();

        hibernateJpaVendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        containerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);

        containerEntityManagerFactoryBean.setPackagesToScan("com.utfpr.db.task8");

        containerEntityManagerFactoryBean.setDataSource(getDataSource());

        containerEntityManagerFactoryBean.afterPropertiesSet();

        return containerEntityManagerFactoryBean.getObject();
    }// entityManagerFactory

    @Bean
    @Order(3)
    public PlatformTransactionManager transactionManager() 
    {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
        jpaTransactionManager.setGlobalRollbackOnParticipationFailure(false);
        return jpaTransactionManager;
    }// transactionManager

    /**
     * @param depFuncService
     * @param departamentoService
     * @param funcionarioService
     * @return 
     * @throws InterruptedException 
     * @see Command line runner
     *
     */
    @Bean
    @Order(4)
    public boolean executeRunners(DepFuncService depFuncService, DepartamentoService ds) 
    {
    	System.err.println(" \n\n // ##################################### ATIVIDADE 8 ##################################### // \n");
    	ds.saveDepartamentoAndFuncionarioAndVincule();
    	
    	return true;
    }// CommandLineRunner
}// class
