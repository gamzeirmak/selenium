package seleniumTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
 public static void main(String[] args) throws Exception {


      // The Firefox driver supports javascript 
      WebDriver driver = new FirefoxDriver();
      
      // Go to the n11.com page
      driver.get("http://www.n11.com");
      
     //login olmamýz gerekiyor.
      WebElement loginResult =null;
      WebElement loginPage = driver.findElement(By.linkText("Hesabým"));
      loginPage.click();
    
      long end = System.currentTimeMillis() + 5000;
      while (System.currentTimeMillis() < end) 
      {
          loginResult = driver.findElement(By.id("email"));
      }
      
  	WebElement txtBox = driver.findElement(By.id("searchData"));
  	txtBox.sendKeys("samsung");
  	txtBox.sendKeys(Keys.RETURN);
  	
  	WebElement resultsDiv = null;
  	WebElement resultsDiv2 =null;
      //Sayfanýn yuklenmesini bekle// Sleep until the div we want is visible or 5 seconds is over
       end = System.currentTimeMillis() + 5000;
      while (System.currentTimeMillis() < end) 
      {
          resultsDiv = driver.findElement(By.className("productArea"));
          	
          // If results have been returned, the results are displayed in a drop down.
          //Aranan kelimeler bulundu mu kontrol et.
          if (resultsDiv.isDisplayed()) {
        	  System.out.printf("Sayfa yuklendi");
        	  //þimdi listeyi ekrana yazdýrmaya calýsalým.
        	  
        	  
            break;
          }
      }
      if (resultsDiv.isDisplayed()) {
    	  //WebElement ul =driver.findElement(By.className("listView")).findElement(By.tagName("ul"));
    	  List<WebElement> lis=driver.findElements(By.className("productName "));
    	  lis.get(2).click();
    	  //System.out.printf(lis.get(3).findElement(By.className("column")). getText());
    	  long end2 = System.currentTimeMillis() + 5000;
    	 
          while (System.currentTimeMillis() < end2) 
          {
              resultsDiv2 = driver.findElement(By.className("proDetailArea"));
              
          }	
         
      }
      if (resultsDiv2.isDisplayed())
      {
    	  System.out.printf("2.Sayfa yuklendi");
      }
      

      // And now list the suggestions
      List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));
      
      for (WebElement suggestion : allSuggestions) {
          System.out.println(suggestion.getText());
      }

      driver.quit();
  }
}
