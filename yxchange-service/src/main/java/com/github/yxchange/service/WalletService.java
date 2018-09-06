package com.github.yxchange.service;

import com.github.yxchange.metadata.entity.Coin;
import com.github.yxchange.wallet.Wallet;

public interface WalletService {

	Wallet getWallet(Coin coin);

	Wallet getWallet(String coinName);

	/**
	 * 根据币种名称生成充币地址
	 * 预留支持充币地址池
	 * @param coinName 币种名称
	 * @return
	 */
	String getDepositAddress(String coinName);
	
}
