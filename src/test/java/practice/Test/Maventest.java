package practice.Test;

import org.testng.annotations.Test;

public class Maventest {
	
	@Test(groups = "smoke")
	public void test1()
	{
		System.out.println("execute TEST1");
	}
	
	@Test(groups = "smoke")
	public void test2()
	{
		System.out.println("execute TEST2");
	}
	
	@Test(groups = "smoke")
	public void test3()
	{
		System.out.println("execute TEST3");
	}
	
	@Test(groups = "regression")
	public void test4()
	{
		System.out.println("execute TEST4");
	}
	
	@Test(groups = "regression")
	public void test5()
	{
		System.out.println("execute TEST5");
	}

}
