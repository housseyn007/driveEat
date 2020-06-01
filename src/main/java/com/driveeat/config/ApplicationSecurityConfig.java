package com.driveeat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.driveeat.service.UserPrincipalDetailsService;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserPrincipalDetailsService userPrincipalDetailsService; 
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		
		//URLs matching for access rights
		.authorizeRequests()
		.antMatchers("/**").permitAll()
		.antMatchers("/utilisateurs/**").authenticated()
		.and()
		
		//From login
		
		.formLogin()
		.loginProcessingUrl("/connexion")
		.loginPage("/login").permitAll()
		.usernameParameter("email")
		.defaultSuccessUrl("/")
		.and()
		
		//From logout
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/déconnexion")).logoutSuccessUrl("/connexion");
	}

	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/DriveatBackend/public/img/specialities/**", "/resources/**", "/css/**", "/fonts/**", "/images/**", "/pdf/**", "/js/**");
	}

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
