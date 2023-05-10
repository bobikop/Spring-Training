package com.cydeo;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class Spring26DataCinemalLab2Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring26DataCinemalLab2Application.class, args);
	}


	public MigrateResult migrateResult(DataSource dataSource){
		return Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
	}

}
