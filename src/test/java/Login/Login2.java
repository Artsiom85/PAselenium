package Login;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class Login2 {
    ChromeDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void Login2() {
        wd.get("https://pureaccesscloud.com/");
        wd.findElement(By.id("input-username")).click();
        wd.findElement(By.id("input-username")).clear();
        wd.findElement(By.id("input-username")).sendKeys("1E589357E2581A27");
        wd.findElement(By.id("input-pwd")).click();
        wd.findElement(By.id("input-pwd")).clear();
        wd.findElement(By.id("input-pwd")).sendKeys("31551FF077352B0459256A509C8CE45CB41566D69C8FB5555B4711BD66214326");
        wd.findElement(By.id("submit-button")).click();
        new WebDriverWait(wd, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.dropdown-item.user-info-item")));
        //wd.findElement(By.cssSelector("div.dropdown-item.user-info-item")).click();
        wd.findElement(By.cssSelector("div.dropdown-item.logoff")).click();
        wd.findElement(By.id("input-pwd")).click();
        wd.findElement(By.id("input-pwd")).sendKeys("\\undefined");
        wd.findElement(By.id("input-username")).click();
        wd.findElement(By.id("input-username")).sendKeys("\\undefined");
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
