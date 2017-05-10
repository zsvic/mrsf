package mrsf.core.rest;

import org.restlet.Context;
import org.restlet.Restlet;


public interface IRestRouter {

	 // a router that attach URI with Resource(or anther router)
	 Restlet getrouter(Context context);
		
	 // return a base path ,as a sign of module
	 String basePath();
}
