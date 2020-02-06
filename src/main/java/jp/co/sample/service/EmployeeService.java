package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

/**
 * 従業員情報を操作するサービス.
 * @author tsuchiyahiromu
 *
 */
@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * 従業員情報を全検索する.
	 * @return 全件検索した従業員情報
	 */
	public List<Employee> showList() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	/**
	 * 一件の従業員情報を検索する.
	 * @param id 検索したい従業員id
	 * @return 取得した従業員情報
	 */
	
	public Employee showDetail(Integer id) {
		Employee employee = employeeRepository.load(id);
		return employee;
	}
	/**
	 * 従業員情報を更新する.
	 * @param employee　従業員情報
	 */
	public void update(Employee employee) {
		employeeRepository.update(employee);
	}
}
