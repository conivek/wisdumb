/*
 * (C) Copyright Premiere Global Services 2021 - All Rights Reserved
 * 
 * This source code and documentation is copyrighted and owned by Premiere
 * Global Services.
 * 
 * Permission to use, copy, modify, and distribute this software and its
 * documentation for ANY purposes commercial or non-commercial must be obtained
 * via licensing arrangements with Premiere Global Services.
 */
package conivek.wisdumb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private WisdumbConfigProps configProps;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // The path to enlightenment is open to all.
    http.authorizeRequests()
        .antMatchers(configProps.getPathToEnlightenment())
        .permitAll();
    super.configure(http);
  }
}
