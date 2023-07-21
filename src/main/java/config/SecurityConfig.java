package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    @Bean
    public UserDetailsService getDetailsService()
    {
    	return new CustomUserDetailsService();
    }
    
    @Bean
    public DaoAuthenticationProvider authprovider()
    {
    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    	daoAuthenticationProvider.setUserDetailsService(getDetailsService());
    	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    	return daoAuthenticationProvider;
    }
    
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity httpsecurity) throws Exception
	{
	    httpsecurity.csrf().disable()
		.authorizeHttpRequests().requestMatchers("/index")
				.permitAll()
				.anyRequest().authenticated().and().
		formLogin();
	    
	    return httpsecurity.build();
		
	}
	
}
