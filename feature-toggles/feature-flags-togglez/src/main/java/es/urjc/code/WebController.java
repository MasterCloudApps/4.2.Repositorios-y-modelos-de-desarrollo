package es.urjc.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.togglz.core.manager.FeatureManager;

@Controller
public class WebController {

	private FeatureManager featureManager;

	public WebController(FeatureManager featureManager) {
		this.featureManager = featureManager;
	}
	
	@GetMapping
	public String getHome() {
		if(featureManager.isActive(Features.NEWHOME)) {
			return "new_home";
		} else {
			return "home";
		}
	}
}
