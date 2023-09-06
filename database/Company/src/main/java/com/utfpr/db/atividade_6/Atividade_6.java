/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.utfpr.db.atividade_6;

import com.utfpr.db.atividade_6.entity.DepFunc;
import com.utfpr.db.atividade_6.entity.Funcionario;
import com.utfpr.db.atividade_6.service.DepFuncService;
import com.utfpr.db.atividade_6.service.DepartamentoService;
import com.utfpr.db.atividade_6.service.FuncionarioService;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author renan
 */
@Configurable
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan(basePackages = "com.utfpr.db.atividade_6")
public class Atividade_6 {

    // logger runner 
    private static Logger logger = LoggerFactory.getLogger(Atividade_6.class);

    Atividade_6() throws Exception {

    }

    public static void main(String[] args) throws Exception {
        System.out.println(" >>>> ATIVIDADE 6 PARA CONSULTA UTILIZANDO REPOSITORY <<<<");

        ApplicationContext ac = new AnnotationConfigApplicationContext(Atividade_6.class);

        CommandLineRunner clr = (CommandLineRunner) ac.getBean("executeRunner");

        clr.run("");
    }// MAIN

    @Bean
    public DataSource getDataSource() {
        System.out.println(">>>>:: Iniciando conection factory com base de dados. Obtem conexão");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/company");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("renan1994");

        return dataSourceBuilder.build();
    } // getDataSource

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();

        hibernateJpaVendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        containerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);

        containerEntityManagerFactoryBean.setPackagesToScan("com.utfpr.db.atividade_6.entity");

        containerEntityManagerFactoryBean.setDataSource(getDataSource());

        containerEntityManagerFactoryBean.afterPropertiesSet();

        return containerEntityManagerFactoryBean.getObject();
    }// entityManagerFactory

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();

        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());

        return jpaTransactionManager;
    }// transactionManager

    /**
     * @see Command line runner
     *
     */
    @Bean
    public CommandLineRunner executeRunner(
            DepFuncService depFuncService,
            DepartamentoService departamentoService,
            FuncionarioService funcionarioService
    ) {
        return (runs) -> {
            System.out.println("\n\n\t>>>> INICIANDO COMMAND LINE RUNNER <<<<\n\n\t");

            /**
            * Questão 1
            */
            System.out.println("\n\n\t>>>> QUESTÃO 1 - LISTANDO UM FUNCIONARIO <<<<\n\n\t");
            System.out.println(" >>>> " + funcionarioService.findByNomeAndQtd_dependentes("luiz", 2).toString());

            /**
            * Questão 2
            */
            List<DepFunc> df = depFuncService.listAllFuncionariosByOneDepartamento();

            System.out.println("\n\n\t>>>> QUESTÃO 2 - LISTANDO TODOS FUNCIONÁRIOS DE UM DETERMINADO DEPARATAMENTO <<<<\n\n\t");

            Iterator<DepFunc> iterableDepFunc = df.iterator();

            while (iterableDepFunc.hasNext()) {
                DepFunc _df = iterableDepFunc.next();
                System.err.println("  >>>> " + _df.toString());
            }

            /**
            * Questão 3
            */
            System.out.println("\n\n\t>>>> QUESTÃO 3 - LISTANDO PRIMEIRO DEP. <<<<\n\n\t");
            System.out.println("\n\n\t>>>> " + departamentoService.findFirt1ByOrderByIdAsc().toString());

            /**
            * Questão 4
            */
            System.out.println("\n\n\t>>>> QUESTÃO 4 - LISTANDO PRIMEIRO FUNC. COM MAIOR SALARIO <<<<\n\n\t");
            System.out.println("\n\n\t>>>> " + funcionarioService.findTopByOrderBySalarioDesc().toString());

            /**
            * Questão 5
            */
            System.out.println("\n\n\t>>>> QUESTÃO 5 - LISTANDO 3 PRIMEIRO FUNC. COM MAIOR SALARIO <<<<\n\n\t");
            Iterator<Funcionario> funcionarios = funcionarioService.findTop3ByOrderBySalarioDesc().iterator();
            while(funcionarios.hasNext())
            {
                System.out.println("\n\n\t>>>> " +funcionarios.next().toString());
            }
            
            /**
            * Questão 6
            */
            System.out.println("\n\n\t>>>> QUESTÃO 6 - LISTANDO FUNC.'s SEM DEPENDENTESORDEM OERDEM CRESCENTE JPQL @QUERY <<<<\n\n\t");
            Iterator<Funcionario> funcionariosNoDependents = funcionarioService.listAllFuncWithNoDependentes().iterator();
            while(funcionariosNoDependents.hasNext())
            {
                System.out.println("\n\n\t>>>> " +funcionariosNoDependents.next().toString());
            }
            
            /**
            * Questão 7
            */
            System.out.println("\n\n\t>>>> QUESTÃO 7 - LISTANDO FUNC.'s COM SALARIO > 2000 @QUERY SOBREESCREVENDO QUERY METHOD <<<<\n\n\t");
            Iterator<Funcionario> funcionariosComSalariosAcima2000 = funcionarioService.findBySalarioIsGreaterThen(2000).iterator();
            while(funcionariosComSalariosAcima2000.hasNext())
            {
                System.err.println("\n\n\t>>>> "+funcionariosComSalariosAcima2000.next().toString());
            }

            /**
            * Questão 8
            */
            System.out.println("\n\n\t>>>> QUESTÃO 8 - LISTANDO FUNC.'s COM SALARIO > 2000 NATIVE @QUERY <<<<\n\n\t");
            Iterator<Funcionario> funcionariosComSalariosAcima2000NativeQuery = funcionarioService.findBySalarioIsGreaterThanNativeQuery().iterator();
            while(funcionariosComSalariosAcima2000NativeQuery.hasNext())
            {
                System.err.println("\n\n\t>>>> "+funcionariosComSalariosAcima2000NativeQuery.next().toString());
            }
            
            /**
            * Questão 9
            */
            System.out.println("\n\n\t>>>> QUESTÃO 9 - LISTANDO FUNC.'s COM QTD_DEPENDETES = 2 <<<<\n\n\t");
            Iterator<Funcionario> funcionariosCom2DependentesNamedQuery = funcionarioService.allFuncionariosWith2Dependentes().iterator();
            while(funcionariosCom2DependentesNamedQuery.hasNext())
            {
                System.err.println("\n\n\t>>>> "+funcionariosCom2DependentesNamedQuery.next().toString());
            }
            
            /**
            * Questão 10
            */
            System.out.println("\n\n\t>>>> QUESTÃO 10 - LISTANDO FUNC.'s PART NAME <<<<\n\n\t");
            Iterator<Funcionario> funcionariosWithPartName = funcionarioService.allFuncionariosWithPartName("lu").iterator();
            while(funcionariosWithPartName.hasNext())
            {
                System.err.println("\n\n\t>>>> "+funcionariosWithPartName.next().toString());
            }
            
             /**
            * Questão 11
            */
            System.out.println("\n\n\t>>>> QUESTÃO 11 - REFAZ 9 & 10 <<<<\n\n\t");
//            Iterator<Funcionario> refaz10And11 = funcionarioService.allFuncionariosWithPartNameRepo("iz").iterator();
//            while(refaz10And11.hasNext())
//            {
//                System.err.println("\n\n\t>>>> "+refaz10And11.next().toString());
//            }
        };
    }// CommandLineRunner    
}
