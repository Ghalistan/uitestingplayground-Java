import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClientSideDelayPage extends BasePage{
    ClientSideDelayPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/clientdelay"));
    }

    void requestData() {
        driver.findElement(By.id("ajaxButton")).click();

        new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("#content p")
                )
        );
    }
}
