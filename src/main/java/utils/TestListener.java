
package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author manish.kumar
 *
 */
public class TestListener implements ITestListener {
	
	Helper helper = new Helper();

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestStart(org.testng.ITestResult)
	 */
	@Override
	public void onTestStart(ITestResult result) {
		//System.out.println(result.getName() + " test has started *****"+"\n");
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestSuccess(org.testng.ITestResult)
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " Test has PASSED *****"+"\n");
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestFailure(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " Test has FAILED *****"+"\n");
		
		String testClassName = helper.getTestClassName(result.getInstanceName()).trim();
    	String testMethodName = result.getName().toString().trim();
    	helper.takeScreenShot(testClassName, testMethodName);
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestSkipped(org.testng.ITestResult)
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + " Test has SKIPPED *****"+"\n");
	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onStart(org.testng.ITestContext)
	 */
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onFinish(org.testng.ITestContext)
	 */
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}
	
}
