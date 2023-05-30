package es.sidelab;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("memory")
public class DefaultApplicationConfiguration {

    private static final Log LOG = LogFactory.getLog(Ejemplobbdd1Application.class);

    @Bean
    public CacheManager memoryCacheManager() {
    	LOG.info("Activating memory cache...");
    	return new ConcurrentMapCacheManager("anuncios");
    }

}