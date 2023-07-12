package selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author kuldeep
 */
public class PageTitleTest {
    private WebDriver driver;
    @BeforeAll
    public static void setupBeforeAll() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "/src/test/resources/chromedriver");
    }

    @BeforeEach
    public void setupBefore() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void test() {
        driver.get("https://www.selenium.dev");
        assertThat(driver.getTitle(), containsString("Selenium"));
    }

}
