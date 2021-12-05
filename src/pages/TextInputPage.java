import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextInputPage extends BasePage{
    TextInputPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/textinput"));
    }

    void inputText(String text) {
        driver.findElement(By.id("newButtonName")).sendKeys(text);
    }

    void clickUpdateButton() {
        driver.findElement(By.id("updatingButton")).click();
    }
}
