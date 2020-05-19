package es.sidelab;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@Profile("redis")
public class RedisApplicationConfiguration {

    private static final Log LOG = LogFactory.getLog(Ejemplobbdd1Application.class);

    @Bean
    public CacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {
    	LOG.info("Activating redis cache...");
    	return RedisCacheManager.builder(connectionFactory).build();
    }

}