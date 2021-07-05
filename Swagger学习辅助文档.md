# Swagger学习辅助文档

> 前后端分离开发，后端需要编写接口说明文档，会耗时比较多的时间。
>
> swagger是一个用于生成服务器接口的规范性文档、并且能够对接口进行测试的工具。

## 1、作用

- 生成接口文档
- 可以对接口进行测试

## 2、整合

### 2.1、在pom.xml中添加依赖

```xml
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.9.2</version>
</dependency>
<dependency>
	<groupId>com.github.xiaoymin</groupId>
	<artifactId>swagger-bootstrap-ui</artifactId>
	<version>1.9.6</version>
</dependency>
```



### 2.2、下载swagger

https://github.com/swagger-api/swagger-ui/tree/v2.1.5



### 2.3、在maven web项目webapp下新建文件夹swagger，将下载的源码导入到文件夹下：修改url地址为"/项目名/v2/api-docs"

![](F:/%E7%AC%94%E8%AE%B0/Swagger%E5%AD%A6%E4%B9%A0%E8%BE%85%E5%8A%A9%E6%96%87%E6%A1%A3.assets/image-20210522162127682.png)



### 2.4、创建Swagger的配置（Java配置方式）

```java
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {
	
	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder().title("《小米商城后端接口说明》")
				.description("详细描述了后端提供给前端的接口的说明")
				.contact(new Contact("管理员","",""))
				.version("v 1.0.0")
				.build();
	}

}
```



### 2.5、在spring-mvc.xml下添加swagger相关配置

```xml
<bean class="com.cdzy.xmshop.config.SwaggerConfig"/>
<mvc:resources location="/swagger/" mapping="/swagger/**"/>
```



### 2.6、编写测试的Controller类

```java
@Api(tags="测试接口模板")
@RestController
@RequestMapping("api/v1")
public class TestController {
	
	@ApiOperation("test测试")
	@RequestMapping(value="/ha",method=RequestMethod.GET)
	public String test(){
		return "test测试成功";
	}
	
	@ApiOperation("Area删除")
	@RequestMapping(value="/a",method=RequestMethod.POST)
	public String ha(){
		return "Area删除成功";
	}
	
}
```



### 2.7、运行项目

http://127.0.0.1:8080/xmshop/swagger/index.html

![](F:/%E7%AC%94%E8%AE%B0/Swagger%E5%AD%A6%E4%B9%A0%E8%BE%85%E5%8A%A9%E6%96%87%E6%A1%A3.assets/image-20210522163522727.png)

http://127.0.0.1:8080/xmshop/doc.html

![](F:/%E7%AC%94%E8%AE%B0/Swagger%E5%AD%A6%E4%B9%A0%E8%BE%85%E5%8A%A9%E6%96%87%E6%A1%A3.assets/image-20210522163627876.png)

