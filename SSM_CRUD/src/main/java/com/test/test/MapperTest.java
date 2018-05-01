package com.test.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.bean.Department;
import com.test.bean.Employee;
import com.test.dao.DepartmentMapper;
import com.test.dao.EmployeeMapper;

/**
 * 测试dao层的工作
 * 推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1.导入SpringText模块
 * 2.@ContextConfiguration指定Spring配置文件的位置
 * 3.直接autowired要使用的组件即可
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {

	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testCRUD(){
//		//1.根据spring配置文件创建SpringIOC容器
//	    ApplicationContext ioc =new ClassPathXmlApplicationContext("applicationContext.xml");
//		//2.从容器中获取mapper
//		ioc.getBean(DepartmentMapper.class);
//		System.out.println(ioc);
		
//		System.out.println(departmentMapper);
		
		//1.插入几个部门
//		departmentMapper.insertSelective(new Department(null,"开发部"));
//		departmentMapper.insertSelective(new Department(null,"测试部"));
//		
		// 2.成功员工数据，测试员工
		
//		employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@test.com",1));

		// 3.批量插入多个员工:批量:使用可以执行批量操作的sqlSession

		
		 EmployeeMapper mapper= sqlSession.getMapper(EmployeeMapper.class);
		 
		 for(int i=0;i<1000;i++){ 
			 String uid = UUID.randomUUID().toString().substring(0, 5)+i; //利用uid自动生成姓名
			 mapper.insertSelective(new Employee(null,uid,"M",uid+"@test.com",1)); 
		 }
		 System.out.println("批量完成");
		 
	}
}
