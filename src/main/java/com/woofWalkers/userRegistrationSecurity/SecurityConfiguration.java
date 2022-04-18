package com.woofWalkers.userRegistrationSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    // We will create userService class in upcoming step
    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests()
                .antMatchers(
                        "/registration**",
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/webjars/**"
                ).permitAll()
                .mvcMatchers("/deleteUser/**").hasAnyRole("SUPERADMIN")
                .mvcMatchers("/deleteDog/**").hasAnyRole("USER", "ADMIN","SUPERADMIN")
                .mvcMatchers("/deleteAppointment/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .mvcMatchers("/allUsers/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/allDogs/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/showFormForUpdate/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/showUserForm/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .mvcMatchers("/saveUser/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .mvcMatchers("/showDogFormForUpdate/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .mvcMatchers("/adminShowDogFormForUpdate/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/adminShowAppointmentFormForUpdate/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/showDogForm/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .mvcMatchers("/saveDog/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .mvcMatchers("/allAppointments/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/showAppointmentFormForUpdate/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .mvcMatchers("/showNewAppointmentForm/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .mvcMatchers("/saveAppointment/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .antMatchers("/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .antMatchers("/showNewDogForm").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/profile", true);

//                .and()
//                .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/logout")
//                .permitAll();
        // @formatter:on
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/images/**");
    }

}