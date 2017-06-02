package br.unipe.javaweb.controleacademico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan({"br.unipe.javaweb.controleacademico.controller", "br.unipe.javaweb.controleacademico.dao", "br.unipe.javaweb.controleacademico.model", "br.unipe.javaweb.controleacademico.service"})
@EntityScan(basePackages = {"br.unipe.javaweb.controleacademico.model"})
@EnableJpaRepositories(basePackages = {"br.unipe.javaweb.controleacademico.dao"})
@EnableTransactionManagement
public class ControleAcademicoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ControleAcademicoApplication.class, args);
	}
}
