package edu.deakin.sit218.examgeneration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;



@Configuration
@EnableWebSecurity
public class ExamGenSpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser(users.username("student").password("student").roles("STUDENT"))
			.withUser(users.username("lecturer").password("lecture").roles("LECTURER"))
			.withUser(users.username("admin").password("admin").roles("ADMIN"));	
	}

	  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	//authorisation part
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.anyRequest().authenticated()
			.and()
	//authentication part
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.defaultSuccessUrl("/post-login", true)
				.permitAll()
			 .and()
			 .logout().permitAll()
			 .and()
			 .exceptionHandling().accessDeniedPage("/access-denied");
	    http.sessionManagement().maximumSessions(2);
     
	}
	
	
	
}