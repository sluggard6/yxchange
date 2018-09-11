package com.github.yxchange.wallet.btc;

import java.util.Properties;

import com.github.yxchange.wallet.Wallet;
import com.github.yxchange.wallet.core.Currency;
import com.github.yxchange.wallet.exception.WalletException;
import com.neemre.btcdcli4j.core.BitcoindException;
import com.neemre.btcdcli4j.core.CommunicationException;
import com.neemre.btcdcli4j.core.client.BtcdClient;

public class BtcWallet implements Wallet {
	
	private String account;
	
	private String hotAddress;
	
	private BtcdClient client;

	@Override
	public Currency getCurrency() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Properties getConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAccount() throws WalletException {
		try {
			return client.getAccount(hotAddress);
		} catch (BitcoindException | CommunicationException e) {
			throw new WalletException(e);
		}
	}

	@Override
	public String getAccountAddress(String account) throws WalletException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBestBlockHash() throws WalletException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String newAddress() {
		return null;
	}

	@Override
	public int getHeight(String transHash) {
		return 0;
	}

}
