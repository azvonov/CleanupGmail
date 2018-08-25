import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WhenYouPissedOffByNumberOfEmailsInYourMailbox {


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "../../drivers/chromedriver");
        Configuration.browser = "chrome";
        Configuration.timeout = 30000;
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("intl.accept_languages", "de");

        options.setExperimentalOption("prefs", prefs);
        WebDriverRunner.setWebDriver(new ChromeDriver(ChromeDriverService.createDefaultService(),options));

    }

    @Test
    public void YouStartThisJobAndRelax() throws InterruptedException {

        open("https://mail.google.com/mail/u/1/#inbox/p7");
        $x("//input[@type='email']").should(appear).setValue("testy@slated.com");
        $(byText("Next")).click();
        $x("//input[@type='password']").should(appear).setValue("ASOCXytT99WOWvXw");
        $(byText("Next")).click();
        $x("//div[@class='Cp']//tr[1]").should(appear);
        while ($$x("//div[@class='Cp']//tr").size() > 2) {
            Thread.sleep(1500L);
            $(".T-Jo-auh").shouldBe(Condition.appear).click();
//            $(".T-Jo J-J5-Ji T-Jo-auq T-Jo-Jp").shouldBe(Condition.appear).click();

            $x("//div[@class='ar9 T-I-J3 J-J5-Ji']").should(appear).click();
            $(withText("Loading...")).should(appear);
            $(withText("Loading...")).should(disappear);
            $x("//div[@class='Cp']//tr[1]").should(appear);
        }
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }
}
