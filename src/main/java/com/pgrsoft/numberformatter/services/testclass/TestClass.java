package com.pgrsoft.numberformatter.services.testclass;

import com.pgrsoft.numberformatter.services.NumberFormatter;
import com.pgrsoft.numberformatter.services.impl.NumberFormatterImpl;

public class TestClass {

	private NumberFormatter numberFormatter;
	
	private void run() {
		
		for(int i = 0; i < 1000; i++) {
			System.out.println(i + ": " + numberFormatter.convert(i));
		}
		
	}
	
	public TestClass() {
		this.numberFormatter = new NumberFormatterImpl();
	}
	
	public static void main(String[] args) {
		
		new TestClass().run();
	}

}
