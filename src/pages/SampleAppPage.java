import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SampleAppPage extends BasePage{
    SampleAppPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/sampleapp"));
    }

    void inputUsername(String name) {
        driver.findElement(By.name("UserName")).sendKeys(name);
    }

    void inputPassword(String password) {
        driver.findElement(By.name("Password")).sendKeys(password);
    }

    void clickLogin() {
        driver.findElement(By.id("login")).click();
    }
}
