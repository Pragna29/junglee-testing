import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	//Method to verify downloaded file and deletes if already exists
	
	public static Boolean VerifyDownloads( String downloadPath, String fileName) {
		
	File dir = new File(downloadPath);
	File[] dirContents = dir.listFiles();
	for (int i = 0; i < dirContents.length; i++) {
	if (dirContents[i].getName().equals(fileName)) {
	// File has been found, it can now be deleted:
	dirContents[i].delete();
	return true;
	}
	}
	return false;
	} 
	
	//Method to explicitly wait for visibility of element
	public static void ExplicitWaitForElementDisplay(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(CommonStudio.driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
		
		
	
	
	
}
