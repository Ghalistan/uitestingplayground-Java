import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DynamicTablePage extends BasePage{
    DynamicTablePage(WebDriver driver) {
        super(driver);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/dynamictable"));
    }

    String getChromeCPUPercentage() {
        List<WebElement> headers = driver.findElements(By.cssSelector("span[role='columnheader']"));
        List<String> headerName = headers.stream().map(h -> h.getText()).collect(Collectors.toList());

        List<WebElement> content = driver.findElements(By.cssSelector("div[role='rowgroup']:nth-child(3) div"));
        List<WebElement> chromeContent = content.stream()
                .filter(c -> c.findElement(By.cssSelector("span")).getText().equals("Chrome"))
                .collect(Collectors.toList());

        Iterator itr = chromeContent.iterator();
        WebElement chrome = (WebElement) itr.next();
        String cpuPercentage = chrome.findElement(By.cssSelector(
                String.format("span:nth-child(%s)", headerName.indexOf("CPU") + 1)
                )).getText();

        return cpuPercentage;
    }
}
