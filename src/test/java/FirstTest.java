import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;

public class FirstTest {

    WebDriver driver = null;

    @Test
    public void testWiki(){
        String driverPath = "D:\\brian\\Estudio\\Test Automation\\WebAutomation\\src\\Utils\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath); //Conexión entre el código y el browser
        driver = new ChromeDriver();
        driver.navigate().to("https://www.wikipedia.org/");
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        WebElement footerLink = driver.findElement(By.cssSelector(".footer-sidebar-text + div"));
        WebElement searchButton = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        searchInput.sendKeys("Microsoft");
        Assert.assertEquals(footerLink.getText(),"Puedes apoyar nuestro trabajo con una donación","Error");
        Assert.assertTrue(searchButton.isDisplayed());
        List<WebElement> langList= driver.findElements(By.className("central-featured-lang"));
        Assert.assertEquals(langList.size(),10);
        searchButton.click();
        driver.close();
    }
}
