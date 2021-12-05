import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class VerifyTextPage extends BasePage{
    VerifyTextPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/verifytext"));
    }
}
