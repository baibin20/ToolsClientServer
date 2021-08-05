package cv.tools.tools.Config;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import java.util.Collections;

@Configuration
public class CorsConfig  {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 1
        corsConfiguration.addAllowedOrigin("*");
        // 2
        corsConfiguration.addAllowedHeader("*");
        // 3
        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));

        return corsConfiguration;
    }

    @Bean
    public FilterRegistrationBean corsFilter() {
        CorsRegistry corsRegistry = new CorsRegistry();
        corsRegistry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT","OPTION","OPTIONS")
                .allowedHeaders("x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN,token,username,client")
                .exposedHeaders("x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN,token,username,client")
                .maxAge(18000);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // step 4
        source.registerCorsConfiguration("/**", buildConfig());
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
