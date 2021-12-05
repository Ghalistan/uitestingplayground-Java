import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickPage extends BasePage{
    ClickPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/click"));
    }

    void clickButton() {
        driver.findElement(By.id("badButton")).click();
    }
}
