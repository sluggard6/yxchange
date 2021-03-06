package com.github.yxchange.wallet;

import java.util.Properties;

import com.github.yxchange.wallet.core.Currency;
import com.github.yxchange.wallet.exception.WalletException;

public interface Wallet {
	
	Currency getCurrency();
	
	Properties getConfig();
	
	String getAccount() throws WalletException;

	String getAccountAddress(String account) throws WalletException;
	
	String getBestBlockHash() throws WalletException;

	String newAddress();

	int getHeight(String transHash);


}
