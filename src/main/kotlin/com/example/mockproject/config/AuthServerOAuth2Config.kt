package com.example.mockproject.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.approval.ApprovalStore
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices
import org.springframework.security.oauth2.provider.token.TokenStore


@EnableAuthorizationServer
@Configuration
class AuthServerOAuth2Config(
        private val userDetailsService: UserDetailsService,
        private val passwordEncoder: PasswordEncoder,
        private val tokenStore: TokenStore,
        private val approvalStore: ApprovalStore,
        private val authorizationCodeServices: AuthorizationCodeServices,
        private val clientDetailsService: JdbcClientDetailsService,
        private val authenticationManager: AuthenticationManager
) : AuthorizationServerConfigurerAdapter() {

    override fun configure(oauthServer: AuthorizationServerSecurityConfigurer) {
        oauthServer
                .passwordEncoder(passwordEncoder)
                .allowFormAuthenticationForClients()
    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints
                .approvalStore(approvalStore)
                .authorizationCodeServices(authorizationCodeServices)
                .tokenStore(tokenStore)
                .userDetailsService(userDetailsService)
                .authenticationManager(authenticationManager)
    }

    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients.withClientDetails(clientDetailsService)
    }
}