package com.github.yxchange.wallet.core;

import java.math.BigInteger;

import org.bitcoinj.core.Base58;
import org.bitcoinj.core.ECKey;

public class PrivateKey {
	
	private byte[] privateKey;
	
	
	public static void main(String... args) {
		ECKey ecKey = new ECKey();
		BigInteger bi = ecKey.getPrivKey();
		System.out.println(ecKey.getPrivateKeyAsHex());
		System.out.println(Base58.encode(ecKey.getPrivKeyBytes()));
		System.out.println(ecKey.getPubKeyPoint());

//		ECKey key2 = new ECKey(bi);
	}

}
