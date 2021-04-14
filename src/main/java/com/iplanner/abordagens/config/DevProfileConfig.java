package com.iplanner.abordagens.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.transaction.ReactiveTransactionManager;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;


@Configuration
@EnableR2dbcRepositories
public class DevProfileConfig {

	@Value("${datasource.connection.hostname}")
	private String host;

	@Value("${datasource.connection.database}")
	private String database;
	
	@Value("${datasource.connection.schema}")
	private String schema;
	
	@Value("${datasource.connection.port}")
	private int port;

	@Value("${datasource.connection.user}")
	private String user;

	@Value("${datasource.connection.pass}")
	private String pass;

	@Value("${datasource.initialize}")
	private Boolean initialize;

	@Bean
	public ConnectionFactory connectionFactory() {
		return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
				.host(host)
				.port(port)
				.database(database)
				.schema(schema)
				.username(user)
				.password(pass).build());
	}

	@Bean
	ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
		return new R2dbcTransactionManager(connectionFactory);
	}

	@Bean
	public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();

		initializer.setConnectionFactory(connectionFactory);

		if (Boolean.TRUE.equals(initialize)) {
			CompositeDatabasePopulator populator = new CompositeDatabasePopulator();

			populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("database/dev-schema.sql")));
			populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("database/dev-data.sql")));

			initializer.setDatabasePopulator(populator);
		}

		return initializer;
	}
}