package dev.itboot.todo.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import dev.itboot.todo.util.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		//パスワードの暗号化
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.authorizeHttpRequests(authz -> authz
				//セキュリティ設定を無視するパスを指定する
				//WebSecurityConfigurerAdapterは現在非推奨
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() //cssなどはログインなしでもアクセス可
				.mvcMatchers("/register").permitAll()
				.mvcMatchers("/admin/**").hasRole(Role.ADMIN.name())
				.anyRequest().authenticated()
		).formLogin(login -> login
				.loginProcessingUrl("/login")
				//ログイン時のURLを指定
				.loginPage("/login")
				//認証後にリダイレクトする場所を指定
				.defaultSuccessUrl("/")
				//ログイン失敗時のリダイレクト先
				.failureUrl("/login?error")
				.permitAll())
		.logout(logout -> logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")))
		//ブラウザを閉じて再度開いた場合でも「ログインしたままに」
		.rememberMe();
		return http.build();		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception{
		return auth.getAuthenticationManager();
	}
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		UserDetails user = User.builder()
//			.username("user")
//			.password(passwordEncoder().encode("password"))
//			.authorities("ROLE_USER")
//			.build();
//		return new InMemoryUserDetailsManager(user);
//	}
}
