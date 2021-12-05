import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoadDelayPage extends BasePage{
    LoadDelayPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/loaddelay"));
    }
}
