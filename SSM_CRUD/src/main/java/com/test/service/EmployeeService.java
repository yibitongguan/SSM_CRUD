package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.Employee;
import com.test.bean.EmployeeExample;
import com.test.bean.EmployeeExample.Criteria;
import com.test.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;

	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Employee> getAll() {
		return employeeMapper.selectByExampleWithDept(null);
	}

	/**
	 * 保存员工
	 */
	public void saveEmp( Employee employee) {
		employeeMapper.insertSelective(employee);
	}

	/**
	 * 检验用户名是否可用
	 * @param empName
	 * @return
	 */
	public Boolean checkUser(String empName) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria =  example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count == 0;
	}

	/**
	 * 根据员工ID查询员工
	 * @param id
	 * @return
	 */
	public Employee getEmp(Integer id) {
		Employee employee  = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}

	/**
	 * 员工更新
	 * @param employee
	 */
	public void updateEmp(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

	/**
	 * 删除单个员工
	 * @param ids
	 */
	public void deleteEmp(Integer id) {
		employeeMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 删除多个员工
	 * @param del_ids
	 */
	public void deleteBatch(List<Integer> del_ids) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria =  example.createCriteria();
		criteria.andEmpIdIn(del_ids);
		employeeMapper.deleteByExample(example);
	}

}
