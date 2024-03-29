package gt.seguridad.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "restservice";
	
        @Autowired
        private TokenStore tokenStore;
        
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
                // @formatter:off
                resources
                        .tokenStore(tokenStore)
                        .resourceId(RESOURCE_ID);
                // @formatter:on
        }

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
                    authorizeRequests()
                .antMatchers("/general/**").authenticated()
                .antMatchers("/riesgo/**").authenticated()
                .antMatchers("/dashboard/**").authenticated()
                //.antMatchers("/evaluacion/**").authenticated()
		.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

}