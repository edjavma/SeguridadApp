package gt.seguridad.security;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Autowired
        DataSource dataSource;

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
        

        @Autowired
        private CustomUserDetailsService userDetailsService;
        
        @Override
        public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        }
        
        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints)
                        throws Exception {
            // @formatter:off
            endpoints
                    .tokenStore(tokenStore())
                    .authenticationManager(authenticationManager)
                    .userDetailsService(userDetailsService);
                // @formatter:on
        }
        
        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
                // @formatter:off
                clients
                    .jdbc(dataSource);
                // @formatter:on
        }
        
        @Bean
        @Primary
        public DefaultTokenServices tokenServices() {
                DefaultTokenServices tokenServices = new DefaultTokenServices();
                tokenServices.setSupportRefreshToken(true);
                tokenServices.setTokenStore(tokenStore());
                return tokenServices;
        }

        
        @Bean
        public JdbcTokenStore tokenStore() {
            return new JdbcTokenStore(dataSource);
        }
        
        @Bean
    public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
    }
}