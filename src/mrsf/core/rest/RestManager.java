package mrsf.core.rest;

import java.util.ArrayList;
import java.util.List;

public class RestManager {
	
	private static List<IRestRouter>  restRouters = 
			new ArrayList<IRestRouter>();
	
	public static void addRestService(IRestRouter r){
		restRouters.add(r);
	}
	
	public static List<IRestRouter> getRestService(){
		return restRouters;
	}
	
}
