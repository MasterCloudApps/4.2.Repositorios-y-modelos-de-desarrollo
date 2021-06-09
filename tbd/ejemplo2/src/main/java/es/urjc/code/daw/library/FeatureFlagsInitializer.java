package es.urjc.code.daw.library;

import javax.annotation.PostConstruct;

import org.ff4j.FF4j;
import org.springframework.stereotype.Component;

@Component
public class FeatureFlagsInitializer {
	
	public static String FEATURE_FIND_BY_TITLE = "enableFindByTitle";
	private FF4j ff4j;
	
	
	public FeatureFlagsInitializer(FF4j ff4j) {
		this.ff4j = ff4j;
	}
	
	@PostConstruct
	public void initializeFlags() {
		if(!ff4j.exist(FEATURE_FIND_BY_TITLE)) {
			ff4j.createFeature(FEATURE_FIND_BY_TITLE, false);
		}
	}

}
