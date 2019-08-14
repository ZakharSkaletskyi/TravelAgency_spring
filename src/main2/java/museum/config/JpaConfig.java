package museum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Configuration for Jpa logic.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
public class JpaConfig {

  /** Entity Manager Factory bean. */
  @Bean(name = "entityManagerFactory")
  public EntityManagerFactory entityManagerFactory() {
    return Persistence.createEntityManagerFactory("primary");
  }

  /** Entity Manager bean for cooperation with DB. */
  @Bean(name = "entityManager")
  public EntityManager entityManager() {
    return entityManagerFactory().createEntityManager();
  }

  /** Platform Transaction Manager bean for transaction with DB. */
  @Bean
  public PlatformTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory());
    return transactionManager;
  }
}
