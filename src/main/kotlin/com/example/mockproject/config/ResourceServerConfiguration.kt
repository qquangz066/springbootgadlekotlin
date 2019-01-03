package com.example.mockproject.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler

@Configuration
@EnableResourceServer
class ResourceServerConfiguration : ResourceServerConfigurerAdapter() {

    override fun configure(resources: ResourceServerSecurityConfigurer) {
        resources.resourceId(RESOURCE_ID).stateless(false)
    }

    override fun configure(http: HttpSecurity) {
        http.httpBasic().disable()
                .authorizeRequests()
                .antMatchers(
                        HttpMethod.GET, "/v2/api-docs", "/configuration/ui",
                        "/swagger-resources", "/configuration/security", "/swagger-ui.html",
                        "/webjars/**", "/swagger-resources/configuration/ui"
                ).permitAll()
                .anyRequest().authenticated()
                .and().exceptionHandling().accessDeniedHandler(OAuth2AccessDeniedHandler())
    }

    companion object {

        private const val RESOURCE_ID = "product-api"
    }

}