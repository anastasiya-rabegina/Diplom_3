package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    //to run test with Yandex browser
//    @Before
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        //when running on a different machine, change path:
//        options.setBinary("C:/Users/anastasiya.rabegina/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
//        WebDriverRunner.setWebDriver(new ChromeDriver(options));
//    }
//
    //to close Yandex browser after each test
//    @After
//    public void quitDriver() {
//        WebDriverRunner.closeWebDriver();
//    }
}