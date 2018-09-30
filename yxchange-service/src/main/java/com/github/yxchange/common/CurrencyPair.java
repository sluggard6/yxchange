package com.github.yxchange.common;

import com.github.yxchange.metadata.entity.Coin;

public class CurrencyPair {

	public final Coin base;

	public final Coin counter;

	/**
	 * Full constructor In general the CurrencyPair.base is what you're wanting to
	 * buy/sell. The CurrencyPair.counter is what currency you want to use to
	 * pay/receive for your purchase/sale.
	 *
	 * @param base
	 *            The base currency is what you're wanting to buy/sell
	 * @param counter
	 *            The counter currency is what currency you want to use to
	 *            pay/receive for your purchase/sale.
	 */
	public CurrencyPair(Coin base, Coin counter) {

		this.base = base;
		this.counter = counter;
	}

	@Override
	public String toString() {
		return base + "/" + counter;
	}

}
