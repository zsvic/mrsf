package mrsf.core;

import java.util.List;

import mrsf.core.rest.IRestRouter;
import mrsf.core.rest.RestManager;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class RestCore {
	
	private Component component;
	
	
	public RestCore(){
		
		component = new Component();
		//set server connector
		component.getServers().add(Protocol.HTTP, 8888);	
	}
	
	public void start() throws Exception{
		//set Virtual Host, addition a application
		component.getDefaultHost().attach(new RestApplication(RestManager.getRestService()));
		component.start();
		Log.echo("rest start complete");
	}
	
}

class RestApplication extends Application{
	
	private List<IRestRouter> restRouters;
	
	public RestApplication(List<IRestRouter> restRouters){
		this.restRouters = restRouters;
	}
	
	@Override
    public synchronized Restlet createInboundRoot() {
		
        Router baserouter = new Router(getContext());

        for(IRestRouter rs:restRouters){
        	baserouter.attach(rs.basePath(), rs.getrouter(getContext()));
        }
        
        
        return baserouter;
	}
	
}