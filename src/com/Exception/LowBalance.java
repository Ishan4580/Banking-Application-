package com.Exception;

public class LowBalance extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void lowBalance(double balance, double amount) {
		// TODO Auto-generated method stub
		System.out.println("amount is"+(amount-balance));

	}
}
