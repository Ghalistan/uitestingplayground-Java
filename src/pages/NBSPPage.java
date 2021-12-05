import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NBSPPage extends BasePage{
    NBSPPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/nbsp"));
    }

    void clickButton() {
        driver.findElement(By.xpath("//button[contains(text(),'My Button')]")).click();
    }
}
