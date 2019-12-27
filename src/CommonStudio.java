import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

public class CommonStudio {

	static RemoteWebDriver driver = null;
	
	
	public static void InitializeAppDriver() {
		//Setting desired capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Chrome");
		capabilities.setCapability("VERSION", "10.3.0"); 
		capabilities.setCapability("deviceName","OnePlus7");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("udid", "1505da8a");

		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("androidPackage", "com.android.chrome");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setCapability("autoAcceptAlerts", true); 
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	       chromePrefs.put("profile.default_content_settings.popups", 0);
	       chromePrefs.put("download.default_directory", "");
		
		options.setExperimentalOption("prefs",chromePrefs);
		
		//Initiating new remotedriver instance
		try {
			driver = new RemoteWebDriver (new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			
			System.out.println(e.getMessage());
		}
		//Loading the URL
		driver.get("https://www.howzat.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
	}
	
}
