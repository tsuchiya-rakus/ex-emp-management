package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.form.UpdateEmployeeForm;
import jp.co.sample.service.EmployeeService;

/**
 * 従業員情報を操作するコントローラー.
 * 
 * @author tsuchiyahiromu
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@ModelAttribute
	public UpdateEmployeeForm setUpUpdateEmployeeForm() {
		return new UpdateEmployeeForm();
	}

	/**
	 * 従業員一覧をリクエストスコープに入れるメソッド.
	 * 
	 * @param model リクエストスコープ
	 * @return 従業員一覧ページを返す
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Employee> list = employeeService.showList();
		model.addAttribute("employeeList", list);
		return "employee/list.html";
	}

	/**
	 * 送られてきたidをもとに一見検索をし、詳細ページに返す。
	 * @param id 一覧から送られきた従業員id
	 * @param model　リクエストスコープ
	 * @return　詳細ページに返す
	 */
	@RequestMapping("/showDetail")
	public String showDetail(String id, Model model) {
		int realId = Integer.parseInt(id);
		Employee employee = employeeService.showDetail(realId);
		model.addAttribute("employee", employee);
		return "employee/detail.html";
	}
	/**
	 * 扶養人数を変更するメソッド
	 * @param form id及び扶養人数情報が入っている
	 * @return 変更後一覧に返す
	 */
	@RequestMapping("/update")
	public String update (UpdateEmployeeForm form) {
		Employee employee = new Employee();
		employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
		employee.setId(Integer.parseInt(form.getId()));
		employeeService.update(employee);
		return "redirect:/employee/showList";
	}
}
