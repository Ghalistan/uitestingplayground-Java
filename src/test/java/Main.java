import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Main {
    WebDriver driver;
    Properties prop;

    @BeforeAll
    void initAll() {
        WebDriverManager.chromedriver().setup();
        prop = new Properties();
    }

    @BeforeEach
    void setup() throws IOException {
        prop.load(new FileInputStream("live.properties"));

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("baseUrl"));
    }

    @AfterEach
    void close() {
        driver.quit();
    }

    @Nested
    class mainPage {
        MainPage mainPage;

        @BeforeEach
        void atMainPage() {
            mainPage = new MainPage(driver);
        }

        @Test
        void dynamicID() {
            DynamicIDPage dynamicIDPage = mainPage.openDynamicIDPage();
            dynamicIDPage.clickBlueButton();
        }

        @Test
        void classAttribute() {
            ClassAttributePage classAttributePage = mainPage.openClassAttributePage();
            classAttributePage.clickBlueButton();

            Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
            Assertions.assertEquals("Primary button pressed", alert.getText());
            alert.accept();
        }

        @Test
        void hiddenLayers() {
            HiddenLayersPage hiddenLayersPage = mainPage.openHiddenLayersPage();
            hiddenLayersPage.clickGreenButton();

            try {
                hiddenLayersPage.clickGreenButton();
            } catch (Exception e) {
                Assertions.assertTrue(e.getMessage().contains("element click intercepted"));
            }
        }

        @Test
        void loadDelay() {
            LoadDelayPage loadDelayPage = mainPage.openLoadDelayPage();

            By button = By.xpath("//button[text()='Button Appearing After Delay']");
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(button));

            Assertions.assertTrue(driver.findElement(button).isDisplayed());
        }

        @Test
        void ajaxData() {
            AJAXDataPage ajaxDataPage = mainPage.openAjaxDataPage();
            ajaxDataPage.requestAjaxData();

            Assertions.assertEquals(
                    "Data loaded with AJAX get request.",
                    driver.findElement(By.cssSelector("#content p")).getText()
            );
        }

        @Test
        void clientSideDelay() {
            ClientSideDelayPage clientSideDelayPage = mainPage.openClientSideDelayPage();
            clientSideDelayPage.requestData();

            Assertions.assertEquals(
                    "Data calculated on the client side.",
                    driver.findElement(By.cssSelector("#content p")).getText()
            );
        }

        @Test
        void clickPage() {
            ClickPage clickPage = mainPage.openClickPage();
            clickPage.clickButton();

            Assertions.assertTrue(
                    driver.findElement(By.id("badButton"))
                            .getAttribute("class")
                            .contains("btn-success")
            );
        }

        @Test
        void textInput() {
            String newName = "AnotherName";
            TextInputPage textInputPage = mainPage.openTextInputPage();
            textInputPage.inputText(newName);
            textInputPage.clickUpdateButton();

            Assertions.assertEquals(
                    newName,
                    driver.findElement(By.id("updatingButton")).getText()
            );
        }

        @Test
        void scrollBars() {
            ScrollBarsPage scrollBarsPage = mainPage.openScrollBarsPage();
            scrollBarsPage.scrollButtonToView();

            Assertions.assertTrue(driver.findElement(By.id("hidingButton")).isDisplayed());
        }

        @Test
        void dynamicTable() {
            DynamicTablePage dynamicTablePage = mainPage.openDynamicTablePage();
            String cpuPercentage = dynamicTablePage.getChromeCPUPercentage();

            Assertions.assertEquals(
                    String.format("Chrome CPU: %s", cpuPercentage),
                    driver.findElement(By.className("bg-warning")).getText()
            );
        }

        @Test
        void verifyText() {
            VerifyTextPage verifyTextPage = mainPage.openVerifyText();

            Assertions.assertTrue(
                    driver.findElement(By.xpath("//span[normalize-space(.)='Welcome UserName!']")).isDisplayed()
            );
        }

        @Test
        void progressBar() {
            ProgressBarPage progressBarPage = mainPage.openProgressBarPage();
            progressBarPage.clickStartButton();
            progressBarPage.stopAt75();
            System.out.println(driver.findElement(By.id("result")).getText());
        }

        @Test
        void visibilityPage() {
            VisibilityPage visibilityPage = mainPage.openVisibilityPage();
            visibilityPage.clickHideButton();

            visibilityPage.buttonLocators.forEach((key, value) -> {
                try {
                    driver.findElement(value).isDisplayed();
                } catch (NoSuchElementException e) {
                    Assertions.assertTrue(true);
                }
            });
        }

        @Test
        void sampleApp() {
            String username = "testName";
            String password = "pwd";

            SampleAppPage sampleAppPage = mainPage.openSampleAppPage();
            sampleAppPage.inputUsername(username);
            sampleAppPage.inputPassword(password);
            sampleAppPage.clickLogin();

            Assertions.assertEquals(
                    String.format("Welcome, %s!", username),
                    driver.findElement(By.id("loginstatus")).getText()
            );
        }

        @Test
        void mouseOver() {
            MouseOverPage mouseOverPage = mainPage.openMouseOverPage();
            mouseOverPage.clickHyperlink();
            mouseOverPage.clickHyperlink();

            Assertions.assertEquals(
                    "2",
                    driver.findElement(By.id("clickCount")).getText()
            );
        }

        @Test
        void NBSPPage() {
            NBSPPage nbspPage = mainPage.openNBSPPage();
            nbspPage.clickButton();
        }
    }
}
