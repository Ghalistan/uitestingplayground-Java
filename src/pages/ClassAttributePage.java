import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClassAttributePage extends BasePage {
    ClassAttributePage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/classattr"));
    }

    void clickBlueButton() {
        driver.findElement(By.cssSelector("button.btn-primary")).click();
    }
}
