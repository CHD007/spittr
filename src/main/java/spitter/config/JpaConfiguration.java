package spitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import spitter.data.DataPackage;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackageClasses = DataPackage.class)
public class JpaConfiguration {

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
