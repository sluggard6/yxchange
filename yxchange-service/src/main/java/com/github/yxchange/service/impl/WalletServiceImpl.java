package com.github.yxchange.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.yxchange.metadata.entity.Coin;
import com.github.yxchange.service.WalletService;
import com.github.yxchange.wallet.Wallet;

public class WalletServiceImpl implements WalletService {
	
	public static Map<String, Wallet> walletMap = new HashMap<>();

	@Override
	public Wallet getWallet(Coin coin) {
		return getWallet(coin.getName());
	}

	@Override
	public Wallet getWallet(String coinName) {
		Wallet wallet = walletMap.get(coinName);
		if(wallet == null) {
//			wallet = 
		}
		return null;
	}

	@Override
	public String getAddress(String coinName) {
		return getWallet(coinName).newAddress();
	}

}
