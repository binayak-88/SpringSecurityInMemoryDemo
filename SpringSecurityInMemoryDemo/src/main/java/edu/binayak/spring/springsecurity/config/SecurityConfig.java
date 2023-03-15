/**
 * 
 */
package edu.binayak.spring.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author HP
 *
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	// Authorization
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("binayak").password("{noop}nanda").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("rupu").password("{noop}mishra").authorities("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("gubu").password("{noop}nonu").authorities("STUDENT");
	}
	
	// Authentication
	protected void configure(HttpSecurity http) throws Exception {
		// Access URL 
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/student").hasAnyAuthority("STUDENT")
		
		// form login
		.and()
		.formLogin().defaultSuccessUrl("/welcome", true)
		
		//logout 
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		// exception handling
		.and()
		.exceptionHandling().accessDeniedPage("/denied");
	}
}
