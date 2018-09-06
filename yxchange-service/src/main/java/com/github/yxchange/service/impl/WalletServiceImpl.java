package com.github.yxchange.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.yxchange.metadata.entity.Coin;
import com.github.yxchange.service.CoinService;
import com.github.yxchange.service.WalletService;
import com.github.yxchange.wallet.Wallet;
import com.github.yxchange.wallet.exception.WalletException;

@Component
public class WalletServiceImpl implements WalletService {

	public static Map<String, Wallet> walletMap = new HashMap<>();
	
	@Autowired
	private CoinService coinService;

	@Override
	public Wallet getWallet(Coin coin) {
		Wallet wallet = walletMap.get(coin.getName());
		if (wallet == null) {
			 wallet = createWallet(coin.getWalletClassName());
			 synchronized (walletMap) {
				walletMap.put(coin.getName(), wallet);
			}
		}
		return wallet;
	}

	@Override
	public Wallet getWallet(String coinName) {
		return getWallet(coinService.getCoinByName(coinName));
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Wallet createWallet(String walletClassName) {
		try {
			Class walletProviderClass = Class.forName(walletClassName);
			if (Wallet.class.isAssignableFrom(walletProviderClass)) {
				return createWalletWithoutSpecification(walletProviderClass);
			} else {
				throw new WalletException("Class '" + walletClassName + "' does not implement Exchange");
			}
		} catch (ClassNotFoundException e) {
			throw new WalletException(e);
		}
	}

	private <T extends Wallet> T createWalletWithoutSpecification(Class<T> walletProviderClass) {
		try {
			return walletProviderClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new WalletException(e);
		}
	}

	@Override
	public String getDepositAddress(String coinName) {
		return getWallet(coinName).newAddress();
	}

}
