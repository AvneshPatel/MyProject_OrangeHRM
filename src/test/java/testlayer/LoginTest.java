package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseHRMclass;
import pompackage.POMLogin;
//import testdata.Excelsheet;

public class LoginTest extends BaseHRMclass {
POMLogin log;

public LoginTest()
{
	super();
}

@BeforeMethod
public void initsetup() throws InterruptedException
{
	initiate();
	
	Thread.sleep(2000);
	screenshots("Login");
	log=new POMLogin();
}
@Test(priority=1)
public void Title()
{
	String actual=log.verify();
	System.out.println(actual);
	
	Assert.assertEquals(actual, "OrangeHRM");
}



@Test(priority=2)
public void Login() throws InterruptedException
{
log.typeusername(prop.getProperty("username"));	
Thread.sleep(2000);
log.typepassword(prop.getProperty("password"));
Thread.sleep(2000);
log.clickbtn();
Thread.sleep(5000);
}

/*@DataProvider
public Object[][] Details()
{
	Object result[][]=Excelsheet.readdata("Sheet1");
	return result;
}

@Test(priority=3, dataProvider="Details")
public void Login(String name,String password) throws InterruptedException
{
	log.typeusername(name);
	Thread.sleep(2000);
	log.typepassword(password);
	Thread.sleep(2000);
	}*/

@AfterMethod
public void close()
{
	driver.close();
	}

}
