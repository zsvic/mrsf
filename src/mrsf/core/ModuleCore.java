package mrsf.core;

import mrsf.config.ModuleConfig;

public class ModuleCore {
	
	public ModuleCore(){
		ModuleConfig mc = new ModuleConfig();
		for(String mcClassString:mc.getModuleConfig()){
			try {
				Class<?> mdClass = Class.forName(mcClassString);
				mdClass.getMethod("start").invoke(mdClass.newInstance());
				Log.echo("loaded module:"+mcClassString);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		Log.echo("loaded module complete");
	}	
}