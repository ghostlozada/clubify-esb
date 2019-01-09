/*
 * Gestorinc S.A.
 * Sistema: Gestor Bot
 * Los contenidos de este archivo son propiedad intelectual de Gestorinc S.A.
 * y se encuentran protegidos por la licencia: "GESTOR FIDUCIA/FONDOS G5".
 * Usted puede encontrar una copia de esta licencia en:
 * http://www.gestorinc.com
 * Copyright 2008-2019 Gestorinc S.A. Todos los derechos reservados.
 */
package com.clubify.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configuracion personalizada de Spring security.
 * @author Gux Lozada
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
    }
}