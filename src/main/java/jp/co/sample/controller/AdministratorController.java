package jp.co.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Administrator;
import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.form.LoginForm;
import jp.co.sample.service.AdministratorService;

/**
 * 管理者情報を操作するコントローラ.
 * 
 * @author tsuchiyahiromu
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
	@Autowired
	private AdministratorService administratorService;
	@Autowired
	private HttpSession session;

	/**
	 * @return 登録用のリクエストパラメーターが格納されるフォームを作る
	 * 
	 */
	@ModelAttribute
	public InsertAdministratorForm setUpinsertAdministratorForm() {
		return new InsertAdministratorForm();
	}

	/**
	 * @return ログイン用のリクエストパラメーターが格納される.
	 */
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}

	/**
	 * 初期画面を表示します.
	 * 
	 * @return 初期画面
	 */
	@RequestMapping("/toInsert")
	public String toInsert() {
		return "administrator/insert";
	}

	/**
	 * 管理者情報を登録する.
	 * 
	 * @param form リクエストパラメータ
	 * @return ログイン画面にリダイレクト
	 */
	@RequestMapping("/insert")
	public String insert(InsertAdministratorForm form) {
		Administrator administrator = new Administrator();
		administrator.setMailAddress(form.getMailAddress());
		administrator.setPassword(form.getPassword());
		administrator.setName(form.getName());
		System.out.println(administrator);
		administratorService.insert(administrator);

		return "redirect:/";
	}

	@RequestMapping("/")
	public String toLogin() {
		return "administrator/login.html";
	}

	/**
	 * リクエストパラメーターの値を照合し、ログインする
	 * 
	 * @param form  リクエストパラメータ
	 * @param model リクエストスコープ
	 * @return 戻り値がnullならログイン画面へそうでなければ従業員情報一覧へ返す
	 */
	@RequestMapping("/login")
	public String login(LoginForm form, Model model) {
		Administrator administrator = administratorService.login(form.getMailAddress(), form.getPassword());
		if (administrator == null) {
			model.addAttribute("message", "メールアドレスまたはパスワードが不正です");
			return toLogin();
		}
		session.setAttribute("administratorName", administrator.getName());
		return "forward:/employee/showList";

	}
	/**
	 * ログアウト処理をする.
	 * 
	 * @return ログイン画面に返す.
	 */
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
}
