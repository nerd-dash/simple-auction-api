package net.nerddash.simpleauctionapi.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

@EnableWebSecurity
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApiResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Bean
	public MethodSecurityExpressionHandler createExpressionHandler() {
		return new OAuth2MethodSecurityExpressionHandler();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			 
		.antMatchers(HttpMethod.GET, "/ages/*").permitAll()
		.antMatchers(HttpMethod.GET, "/races/*").permitAll()
		.antMatchers(HttpMethod.GET, "/auctions/*").permitAll()
		.antMatchers(HttpMethod.GET, "/batches/*").permitAll()		
		.anyRequest().permitAll()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}
}
