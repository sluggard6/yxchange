package com.github.yxchange.service;

import com.github.yxchange.metadata.entity.Coin;
import com.github.yxchange.wallet.Wallet;

public interface WalletService {

	Wallet getWallet(Coin coin);

	Wallet getWallet(String coinName);

	String getAddress(String coinName);
	
}
