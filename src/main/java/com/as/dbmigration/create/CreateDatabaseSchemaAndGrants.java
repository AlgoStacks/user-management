package com.as.dbmigration.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.MethodParameter;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

@Configuration
public class CreateDatabaseSchemaAndGrants {

    @Bean(name = "createDataSource")
    @ConfigurationProperties(prefix = "create.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Value("${create.schemaName}")
    private String schemaName;

    @Value("${create.asUserName}")
    private String asUserName;

    @Value("${spring.datasource.username}")
    private String flywayUserName;

    @Bean
    @Scope("prototype")
    public Logger logger(InjectionPoint injectionPoint){
        MethodParameter methodParameter = injectionPoint.getMethodParameter();
        if (Objects.isNull(methodParameter)){
            throw new IllegalStateException("can not create logger : Method parameter is null");
        }
        return LoggerFactory.getLogger(methodParameter.getContainingClass());
    }

    @Bean
    public CreateDatabaseSchemaAndGrants createSchemaIfNecessary(@Qualifier("createDataSource") DataSource dataSource, Logger logger) throws SQLException {
        logger.info("Schema Name to set up {}", schemaName);

        if (shouldSkipSchema(schemaName)){
            logger.info("Skipping schema creation if already");
            return new CreateDatabaseSchemaAndGrants();
        }

        String dropSchemaSql = String.format("DROP SCHEMA IF EXISTS %s CASCADE", schemaName);
        String createSchemaSql = String.format("CREATE SCHEMA IF NOT EXISTS %s", schemaName);

        String grantFlywaySql = String.format("GRANT USAGE, CREATE ON SCHEMA %s TO %s", schemaName, flywayUserName);
        String grantAsSql = String.format("GRANT USAGE, CREATE ON SCHEMA %s TO %s", schemaName, asUserName);

        try(Connection con = dataSource.getConnection();
            Statement stmt = con.createStatement()){

            String printFormat = "Executing sql: {}";
            logger.info(printFormat, dropSchemaSql);
            stmt.execute(dropSchemaSql);

            logger.info(printFormat, dropSchemaSql);
            stmt.execute(createSchemaSql);

            logger.info(printFormat, dropSchemaSql);
            stmt.execute(grantFlywaySql);

            logger.info(printFormat, dropSchemaSql);
            stmt.execute(grantAsSql);
        }
        return new CreateDatabaseSchemaAndGrants();
    }

    boolean shouldSkipSchema(String schemaName){
        return !schemaName.matches("as_local");
    }
}
