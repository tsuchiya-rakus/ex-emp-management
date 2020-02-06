package jp.co.sample.form;

/**
 * 従業員情報更新時に使用するフォーム.
 * 
 * @author tsuchiyahiromu
 *
 */
public class UpdateEmployeeForm {
	/**
	 * 従業員IDを受け取る変数
	 */
	private String id;
	/**
	 * 従業員の扶養人数を受け取る変数
	 */
	private String dependentsCount;

	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
}
