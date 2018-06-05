package gk.springboot.com.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 测试后无法加载yaml文件，默认加载properties文件
 * 此为第一种加载properties文件方法
 * @author gk
 * @description 
 * 2017年5月26日 下午3:56:19
 */
@Component
//@EnableConfigurationProperties(value = MyConfiguration.class)
@ConfigurationProperties(prefix="mytest")//该注解配置需要配合@EnableConfigurationProperties使用，1.5后取消了location属性
@PropertySource(value="classpath:/config/config.properties")
public class MyConfiguration {
	
	private String name;
	
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
