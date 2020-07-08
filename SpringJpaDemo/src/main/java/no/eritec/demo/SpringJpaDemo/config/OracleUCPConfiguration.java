package no.eritec.demo.SpringJpaDemo.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

@Configuration
@Profile("oracle-ucp")
public class OracleUCPConfiguration {
 
    @Bean
    public DataSource dataSource() throws SQLException {
    	Logger log = LoggerFactory.getLogger(OracleUCPConfiguration.class);
    	log.info("CONNECTION_POOL: Oracle UCP");
        PoolDataSource dataSource = PoolDataSourceFactory.getPoolDataSource();
        dataSource.setUser("appdata");
        dataSource.setPassword("app");
        dataSource.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
        dataSource.setURL("jdbc:oracle:thin:@//localhost:1521/ORCL");
        dataSource.setFastConnectionFailoverEnabled(true);
        dataSource.setInitialPoolSize(5);
        dataSource.setMinPoolSize(5);
        dataSource.setMaxPoolSize(5);
        return dataSource;
    }
}
