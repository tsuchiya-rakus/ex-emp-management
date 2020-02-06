package jp.co.sample.form;

/**
 * @author tsuchiyahiromu 管理者情報登録時に使用するフォーム.
 *
 */
public class InsertAdministratorForm {
	/**
	 * リクエストパラメーターの名前の項目を受け取る
	 */
	private String name;
	/**
	 * リクエストパラメーターのメールアドレスの項目を受け取る
	 */
	private String mailAddress;
	/**
	 * リクエストパラメーターのパスワードの項目を受け取る
	 */
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}
}
