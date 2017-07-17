package gk.springboot.com.test;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import gk.springboot.com.mapper.UserMapper;
import gk.springboot.com.model.User;
import gk.springboot.com.model.UserExample;
import gk.springboot.com.property.MyTestYml;
import gk.springboot.com.service.IUserService;
import gk.springboot.com.service.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootTest {

	private static final Logger log = LoggerFactory.getLogger(BootTest.class);

	@Autowired
	private MyTestYml myTestYml;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private MailService mailService;

	@Test
	public void test01() {
		System.out.println(myTestYml.getName());
		List<String> listProp = myTestYml.getListProp();
		for (String string : listProp) {
			System.out.println(string);
		}
	}

	@Test
	public void test02() {
		PageHelper.startPage(1, 10);
		List<User> userList = userMapper.selectByExample(new UserExample());
		log.info("当前获取{}条记录！", userList.size());
		PageInfo<User> pageInfo = new PageInfo<>(userList);
		log.info("总共{}条记录!", pageInfo.getTotal());
	}

	@Test
	@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED) // 启用事务
	public void test03() {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setName("将军大道");
		user.setAge(100);
		user.setPassword("123456");
		userMapper.insertSelective(user);
		throw new RuntimeException();
	}
	
	@Test
	public void test04() {
		mailService.sendSimpleMail("gkaigk@126.com", "测试", "测试邮件内容");
	}
	
	@Test
	public void test05() {
		for(int i = 0; i < 2; i++) {
			mailService.sendHtmlMail("gkaigk@126.com", "测试HTML", "测试邮件内容<br/>换行显示：<a>www.baidu.com</a>");
		}
	}
	
	@Test
	public void test06() {
		UserExample example = new UserExample();
		example.createCriteria().andAgeEqualTo(30);
		List<User> users = userService.getUsersByExample(example);
		System.out.println(users==null);
	}

}
