package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author kuldeep
 */
public class FileUploadTest {
    //Test file size
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
    public void testUploadedFileSize() {
        // Open the web page where you upload the file
        driver.get("https://www.simpleimageresizer.com");
        // Find the file input element
        WebElement fileInput = driver.findElement(By.id("filePath"));
        // Specify the path to the file you want to upload
        String filePath = "/Users/kuldeep/Desktop/data/pocs/selenium-demo/test-selenium-2/src/test/resources/image.jpg";
        File file = new File(filePath);
        // Get the file size in bytes
        long actualFileSize = file.length();
        double mb = (double)actualFileSize/(1024*1024);
        System.out.println("actualFileSize: " + mb + "MB");
        System.out.println("actualFileSize: " + actualFileSize + "Bytes");
        // Assert that the actual file size matches the expected file size
        assertTrue(mb < 5);
    }
}
