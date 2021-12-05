import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class DynamicIDPage extends BasePage {
    public DynamicIDPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/dynamicid"));
    }

    void clickBlueButton() {
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    }
}
