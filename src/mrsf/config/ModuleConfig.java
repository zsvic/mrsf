package mrsf.config;

import java.util.ArrayList;
import java.util.List;

public class ModuleConfig {
	
	private static List<String> moduleConfig = new ArrayList<String>();
	
	public ModuleConfig(){
	
	}
	public void addModule(String module){
		moduleConfig.add(module);
	};
	
	public List<String> getModuleConfig(){
		
		return moduleConfig;
	}
}
