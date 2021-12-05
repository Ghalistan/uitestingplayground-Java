import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HiddenLayersPage extends BasePage{
    HiddenLayersPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/hiddenlayers"));
    }

    void clickGreenButton() {
        driver.findElement(By.cssSelector("button#greenButton")).click();
    }
}
