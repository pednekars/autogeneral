package fr.autogeneral.rest.core.model;

import java.io.Serializable;

public class BalanceTestResult implements Serializable{
	boolean isBalanced;
	String input;
	
	public BalanceTestResult() {
		
	}
	
	public BalanceTestResult(String input, boolean isBalanced) {
		this.input = input;
		this.isBalanced = isBalanced;
	}
	public boolean isBalanced() {
		return isBalanced;
	}
	public void setBalanced(boolean isBalanced) {
		this.isBalanced = isBalanced;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	
	

}
