# mrsf
一个模块化的Rest服务框架。使用restlet框架，对其进行再封装，提供一个模块化开发的环境

# 使用方法

## 1 打包源码或下载release版jar包，得到mrsf.jar

## 2 新建java项目

## 3 将mrsf.jar包与mrsf项目中的lib中的第三方jar包都引入新建的java项目

    示例：
        将 mrsf-1.0.jar，mrsf源码中的lib目录下的org.restlet.ext.jaxrs.jar ，org.restlet.jar 
        同时放入到新项目中的 lib目录下，并加入到eclipse的Bulid Path中

## 4 新建模块

### 新建一个模块包：test.helloworld

### 建立模块入口类

    建立入口类helloworld,并实现接口 mrsf.core.module.IModule

```java
package mrsf.core.module;

public interface IModule {
	
	void init();
	
	void start();
}
```
    start方法是该入口类的入口方法

### 建立模块资源类

    建立模块资源类：helloworldResource,并继承类： mrsf.core.rest.RestResource 类

示例：

```java
import org.restlet.resource.Get;
import mrsf.core.rest.RestResource;

public class helloworldResource extends RestResource {

	@Get
	public String Hello(){
		
		return "Hello world";
	}
}
```

### 建立模块路由类

    建立模块路由类：helloworldRouter,并实现 mrsf.core.rest.IRestRouter 接口

示例：

```java
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import mrsf.core.rest.IRestRouter;

public class helloworldRouter implements IRestRouter {

	@Override
	public Restlet getrouter(Context context) {
		Router r = new Router(context);
		r.attach("/hello", helloworldResource.class);
		return r;
	}

	@Override
	public String basePath() {
		// TODO Auto-generated method stub
		return "/helloworld";
	}

}
```

### 在入口类中添加Rest服务

    在入口类中使用 RestManager.addRestService（Router）添加服务
示例：

```java
import mrsf.core.module.IModule;
import mrsf.core.rest.RestManager;

public class helloworldModule implements IModule {

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		RestManager.addRestService(new helloworldRouter());
		
	}

}
```

## 完成
   mrsf默认监听端口为8888，使用 http:127.0.0.1:8888/helloworld/hello 访问服务，返回“hello world”