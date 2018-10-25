package com.github.yxchange.wallet.core;

import java.math.BigInteger;

import org.bitcoinj.core.Base58;
import org.bitcoinj.core.ECKey;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.math.ec.ECPoint;

public class PrivateKey {
	
	private ECKey key;
	
	public PrivateKey() {
		key = new ECKey();
		ECPoint point = key.getPubKeyPoint();
		key.getPubKey();
	}
	
	public static void main(String... args) {
//		ECKey ecKey = new ECKey(Base58.decode("3fZtW2wCfZ8eh9AXwYBkm8pqAeNCo9PKXNGgGTYMJSrF"));
		ECKey ecKey = ECKey.fromPrivate(Base58.decode("3fZtW2wCfZ8eh9AXwYBkm8pqAeNCo9PKXNGgGTYMJSrF"));
		KeyParameter keyParameter = ecKey.getKeyCrypter().deriveKey("12345678");
				
		BigInteger bi = ecKey.getPrivKey();
		System.out.println(ecKey.getPrivateKeyAsHex());
		System.out.println(Base58.encode(ecKey.getPrivKeyBytes()));
		System.out.println(ecKey.getPubKeyPoint());

//		ECKey key2 = new ECKey(bi);
	}

}
