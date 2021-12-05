import org.jsoup.select.Collector;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VisibilityPage extends BasePage{
    HashMap<String, By> buttonLocators = new HashMap<String, By>();

    VisibilityPage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/visibility"));
        buttonLocators.put("hideBtn", By.id("hideButton"));
        buttonLocators.put("removedBtn", By.id("removedButton"));
        buttonLocators.put("zeroWidthBtn", By.id("zeroWidthButton"));
        buttonLocators.put("overlappedBtn", By.id("overlappedButton"));
        buttonLocators.put("opacityZeroBtn", By.id("transparentButton"));
        buttonLocators.put("visibilityHiddenBtn", By.id("invisibleButton"));
        buttonLocators.put("displayNoneBtn", By.id("notdisplayedButton"));
        buttonLocators.put("offscreenBtn", By.id("offscreenButton"));
    }

    void clickHideButton() {
        Map.Entry<String, By> hideButton = buttonLocators.entrySet().stream().filter(loc -> loc.getKey().equals("hideBtn"))
                .collect(Collectors.toList())
                .iterator().next();
        driver.findElement(hideButton.getValue()).click();
    }
}
