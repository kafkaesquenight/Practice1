package pan.eduard.Practice1;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pan.eduard.Practice1.service.ServiceA;
import pan.eduard.Practice1.service.ServiceB;
import pan.eduard.Practice1.service.ServiceC;
import pan.eduard.Practice1.service.ServiceD;
import pan.eduard.Practice1.repository.RepoA;
import pan.eduard.Practice1.repository.RepoB;
import pan.eduard.Practice1.repository.RepoC;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "pan")
@EnableTransactionManagement
public class MyConfiguration {
    private static Logger logger = LoggerFactory.getLogger(MyConfiguration.class);
    @Value("${value.from.application:default}:")
    private String value;
//    @Bean
//    public DataSource dataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.h2.Driver");
//        dataSourceBuilder.url("jdbc:h2:mem:test;DB_CLOSE_ON_EXIT=FALSE");
//        dataSourceBuilder.username("SA");
//        dataSourceBuilder.password("");
//        return dataSourceBuilder.build();    }
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(dataSource());
//        return jdbcTemplate;
//    }
    @Bean("serviceAFromConfiguration")
    public ServiceA getServiceA(){
        ServiceA serviceA = new ServiceA(new RepoA());
        return serviceA;
    }

    @Bean("serviceBFromConfiguration")
    public ServiceB getServiceB(){
        ServiceB serviceB = new ServiceB(new ServiceA(new RepoA()), new RepoB());
        return serviceB;
    }

    @Bean("serviceCFromConfiguration")
    public ServiceC getServiceC(){
        ServiceC serviceC = new ServiceC(new ServiceB(new ServiceA(new RepoA()), new RepoB()), new RepoC());
        return serviceC;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ServiceD getServiceD(){
        ServiceD serviceD = new ServiceD(new ServiceC(new ServiceB(new ServiceA(new RepoA()), new RepoB()), new RepoC()));
        return serviceD;
    }
    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2).addScripts("classpath:sql/schema.sql", "classpath:sql/test-data.sql").build();
        } catch (Exception e) {
            logger.error("Embedded DataSource bean cannot be created!", e);
            return null;
        }
    }
    private Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProp.put("hibernate.format_sql", true);
        hibernateProp.put("hibernate.use_sql_comments", true);
        hibernateProp.put("hibernate.show_sql", true);
        hibernateProp.put("hibernate.max_fetch_depth", 3);
        hibernateProp.put("hibernate.jdbc.batch_size", 10);
        hibernateProp.put("hibernate.jdbc.fetch_size", 50);
        return hibernateProp;
    }
    @Bean public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.apress.prospring5.ch7.entities");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }
    @Bean public PlatformTransactionManager transactionManager() throws IOException {
        return new HibernateTransactionManager(sessionFactory());
    }
}
