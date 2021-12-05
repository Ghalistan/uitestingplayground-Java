import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    private WebElement descSection, overviewSection;

    public MainPage(WebDriver driver) {
        super(driver);
        String pageTitle = driver.findElement(By.cssSelector("h1#title")).getText().replaceAll("\n", " ");
        Assertions.assertEquals("UI Test Automation Playground", pageTitle);

        descSection = driver.findElement(By.cssSelector("section#description"));
        overviewSection = driver.findElement(By.cssSelector("section#overview"));
    }

    private void clickMenu(String url) {
        overviewSection.findElement(By.cssSelector(String.format("a[href='%s']", url))).click();
    }

    DynamicIDPage openDynamicIDPage() {
        clickMenu("/dynamicid");
        return new DynamicIDPage(driver);
    }

    ClassAttributePage openClassAttributePage() {
        clickMenu("/classattr");
        return new ClassAttributePage(driver);
    }

    HiddenLayersPage openHiddenLayersPage() {
        clickMenu("/hiddenlayers");
        return new HiddenLayersPage(driver);
    }

    LoadDelayPage openLoadDelayPage() {
        clickMenu("/loaddelay");
        return new LoadDelayPage(driver);
    }

    AJAXDataPage openAjaxDataPage() {
        clickMenu("/ajax");
        return new AJAXDataPage(driver);
    }

    ClientSideDelayPage openClientSideDelayPage() {
        clickMenu("/clientdelay");
        return new ClientSideDelayPage(driver);
    }

    ClickPage openClickPage() {
        clickMenu("/click");
        return new ClickPage(driver);
    }

    TextInputPage openTextInputPage() {
        clickMenu("/textinput");
        return new TextInputPage(driver);
    }

    ScrollBarsPage openScrollBarsPage() {
        clickMenu("/scrollbars");
        return new ScrollBarsPage(driver);
    }

    DynamicTablePage openDynamicTablePage() {
        clickMenu("/dynamictable");
        return new DynamicTablePage(driver);
    }

    VerifyTextPage openVerifyText() {
        clickMenu("/verifytext");
        return new VerifyTextPage(driver);
    }

    ProgressBarPage openProgressBarPage() {
        clickMenu("/progressbar");
        return new ProgressBarPage(driver);
    }

    VisibilityPage openVisibilityPage() {
        clickMenu("/visibility");
        return new VisibilityPage(driver);
    }

    SampleAppPage openSampleAppPage() {
        clickMenu("/sampleapp");
        return new SampleAppPage(driver);
    }

    MouseOverPage openMouseOverPage() {
        clickMenu("/mouseover");
        return new MouseOverPage(driver);
    }

    NBSPPage openNBSPPage() {
        clickMenu("/nbsp");
        return new NBSPPage(driver);
    }
}
