package es.urjc.code.toggle;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;

public enum Features implements Feature {
	
	@Label("Activates Mongo")
	MONGO_DATABASE

}
