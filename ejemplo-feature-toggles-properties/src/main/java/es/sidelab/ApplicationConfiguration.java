package es.sidelab;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class ApplicationConfiguration {

    private static final Log LOG = LogFactory.getLog(Ejemplobbdd1Application.class);

    @Bean
    @ConditionalOnProperty(name = "features.cache.redis", matchIfMissing = true, havingValue = "false")
    public CacheManager memoryCacheManager() {
    	LOG.info("Activating memory cache...");
    	return new ConcurrentMapCacheManager("anuncios");
    }

    @Bean
    @ConditionalOnProperty(name = "features.cache.redis")
    public CacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {
    	LOG.info("Activating redis cache...");
    	return RedisCacheManager.builder(connectionFactory).build();
    }

}