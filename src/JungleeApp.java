import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import java.util.Random;
import junit.framework.Assert;


public class JungleeApp extends CommonStudio {
	
	//Test to verify Dowloaded apk
		@Test
		public static void DownloadApp() {
			CommonStudio.InitializeAppDriver();
			driver.findElement(MobileBy.xpath("//*[text()='Download App']")).click();
			Assert.assertTrue(Utils.VerifyDownloads("/root/sdcard/Downloads", "howzat.apk"));
			
		}
	
	//Test to register a new user and login 
	
	@Test
	public static void Register_Login() {
		//Initializing RemoteWebDriver with the Android capabilities
		CommonStudio.InitializeAppDriver();
		
		driver.findElement(MobileBy.xpath("//*[text()='Register Now']")).click();
		Utils.ExplicitWaitForElementDisplay(driver.findElement(MobileBy.xpath("//*[@placeholder='Email or mobile'])[1])")));
		
		//generating a random email address
		Random random= new Random();
		int n = (int )(Math.random() * 10000 + 1); 
		String email = "abc"+Integer.toString(n)+"@gmail.com";
		
		//finding the locators for the fields in the registration form
		driver.findElement(MobileBy.xpath("(//*[@placeholder='Email or mobile'])[1]")).sendKeys(email);
		driver.findElement(MobileBy.xpath("(//*[@placeholder='Password'])[1]")).sendKeys("Password@123");
		driver.findElement(MobileBy.xpath("(//*[contains (text(),'Register')])[3]")).click();
		driver.close();
		
		//Initializing RemoteWebDriver with the Android capabilities
		CommonStudio.InitializeAppDriver();
		//finding locators in login page and signing up
		driver.get("https://www.howzat.com");
		Utils.ExplicitWaitForElementDisplay(driver.findElement(MobileBy.xpath("//*[@placeholder='Email or mobile'])[1])")));
		driver.findElement(MobileBy.xpath("//*[@class='android.view.View' and ./*[@text='Login']]")).click();
		driver.findElement(MobileBy.xpath("(//*[@placeholder='Email or mobile'])[1]")).sendKeys(email);
		driver.findElement(MobileBy.xpath("(//*[@placeholder='Password'])[1]")).sendKeys("Password@123");
		driver.findElement(MobileBy.xpath("//*[@text='Login']")).click();
		driver.findElement(MobileBy.xpath("(//*[@class='tab-icon'])[last()]")).click();
		driver.findElement(MobileBy.xpath("//*[@class='avatar']")).click();
		String email2=driver.findElement(MobileBy.xpath("//*[@name='email'][1]")).getAttribute("text");
		
		//Validating the user logged in is same as user registered
		Assert.assertTrue(email2.equals(email));
		
	}
	
}
