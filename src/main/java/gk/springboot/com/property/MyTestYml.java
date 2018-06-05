package gk.springboot.com.property;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 测试后无法加载yaml文件，默认加载properties文件
 * 此为第一种加载properties文件方法
 * @author gk
 * @description 
 * 2017年5月26日 下午3:56:19
 */
@Component
@ConfigurationProperties(prefix="mytest")//该注解配置需要配合@EnableConfigurationProperties使用，1.5后取消了location属性
//@PropertySource(value="classpath:/config/conf.yml")
public class MyTestYml {
	
	private String name;
	
	private List<String> listProp = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getListProp() {
		return listProp;
	}

	public void setListProp(List<String> listProp) {
		this.listProp = listProp;
	}
	
}
