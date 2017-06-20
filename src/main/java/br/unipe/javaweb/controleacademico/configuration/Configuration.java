package br.unipe.javaweb.controleacademico.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.unipe.javaweb.controleacademico.interceptors.LoginInterceptor;

public class Configuration extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getInterceptor());
	}
	
	@Bean
	public LoginInterceptor getInterceptor() {
	    return new LoginInterceptor();
	}
}
