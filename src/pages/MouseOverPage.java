import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MouseOverPage extends BasePage{
    MouseOverPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/mouseover"));
    }

    void clickHyperlink() {
        driver.findElement(By.linkText("Click me")).click();
    }
}
