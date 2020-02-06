package jp.co.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Administrator;
import jp.co.sample.repository.AdministratorRepository;

/**
 * 管理者情報を操作するサービス.
 * @author tsuchiyahiromu 
 */
@Service
@Transactional
public class AdministratorService {
	/**
	 * AdministratorRepositoryを使うための変数DI.
	 */
	@Autowired
	private AdministratorRepository administratorRepository;

	/**
	 * 引数で指定したadministratorオブジェクトの情報をテーブルに挿入する為のメソッド.
	 * 
	 * @param administrator
	 */
	public void insert(Administrator administrator) {
		administratorRepository.insert(administrator);
	}
	/**
	 * @param mailAddress ログイン時に照合する為のメールアドレス
	 * @param password ログイン時に照合する為のパスワード
	 * @return	引数に与えられたアドレス及びパスワードが合致された管理者情報を返す
	 */
	public Administrator login(String mailAddress,String password) {
		Administrator administrator = administratorRepository.findByMailAddressAndPassword(mailAddress, password);
		return administrator;
	}
}
