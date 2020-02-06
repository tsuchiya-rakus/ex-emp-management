package jp.co.sample.form;

/**
 * ログイン時メールアドレスとパスワードを受ける為のフォーム
 * 
 * @author tsuchiyahiromu
 */
public class LoginForm {
	/**
	 * ログイン時に必要なメールアドレスを受ける為の変数
	 */
	private String mailAddress;
	/**
	 * ログイン時に必要なパスワードを受ける為の変数
	 */
	private String password;
	@Override
	public String toString() {
		return "LoginForm [mailAddress=" + mailAddress + ", password=" + password + "]";
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
