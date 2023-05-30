package es.urjc.code;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.jdbc.JDBCStateRepository;
import org.togglz.core.spi.FeatureProvider;

import es.urjc.code.service.JPAProductService;
import es.urjc.code.service.MongoProductService;
import es.urjc.code.service.ProductService;
import es.urjc.code.toggle.Features;

/**
 * @author J. Manuel Colmenar
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
	@Bean
	public FeatureProvider featureProvider() {
	    return new EnumBasedFeatureProvider(Features.class);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ProductService productService(FeatureManager featureManager) {
		if(featureManager.isActive(Features.MONGO_DATABASE)) {
			return new MongoProductService();
		} else {
			return new JPAProductService();
		}
	}

	@Bean
	public StateRepository stateRepository(DataSource dataSource) {
		return new JDBCStateRepository(dataSource);
	}
}
