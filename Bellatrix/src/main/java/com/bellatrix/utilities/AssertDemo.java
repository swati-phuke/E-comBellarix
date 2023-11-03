package com.bellatrix.utilities;

import org.testng.Assert;

public class AssertDemo {
	public void asserEqualsMethod(String name,String name1) {
		Assert.assertEquals(name, name1);
		
	}
	public void asserContainsMethos(String name, String name2) {
		Assert.assertTrue(name.contains(name2));
	}

}
