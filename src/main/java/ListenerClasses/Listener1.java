package ListenerClasses;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener1 implements ITestListener{

	
	public void onTestStart(ITestResult result)
	{
		 System.out.println(result.getName() + "Test is Started");
    }
	
    public void onTestSuccess(ITestResult result) 
    {
    	System.out.println(result.getName() + "Test is passed");
	}
    
    public void onTestFailure(ITestResult result) 
    {
    	System.out.println(result.getName() + "Test is failed");
    }
    
    public void onTestSkipped(ITestResult result) 
    {
    	System.out.println(result.getName() + "Test is skipped");
    }

}
