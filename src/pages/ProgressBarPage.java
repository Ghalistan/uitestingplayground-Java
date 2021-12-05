import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProgressBarPage extends BasePage{
    ProgressBarPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/progressbar"));
    }

    void clickStartButton() {
        driver.findElement(By.id("startButton")).click();
    }

    void stopAt75() {
        new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@aria-valuenow='75']")
                ));

        driver.findElement(By.id("stopButton")).click();
    }
}
