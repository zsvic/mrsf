package mrsf.core.handle;

import mrsf.config.ModuleConfig;
import mrsf.core.ModuleCore;
import mrsf.core.RestCore;

public class MrsfHandle {
	
	private ModuleConfig mc;
	
	public MrsfHandle(){
		mc = new ModuleConfig();
	}
	
	public void addModule(String module){
		mc.addModule(module);
	}
	
	public void start(){
		//Load module
		new ModuleCore();
				
		//start rest
		try {
				new RestCore().start();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
}
