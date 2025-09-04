package practice.Test;

import org.testng.annotations.Test;

public class TestNG_helper_attribute {
	
	@Test
	public void test()
	{
		System.out.println("helloooooooo");
	}
	
	@Test(priority = -1)
	public void test1()
	{
		System.out.println("heiii");
	}

}
