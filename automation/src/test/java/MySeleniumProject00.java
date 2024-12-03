import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * Class representing a Selenium test.
 * This class contains methods to perform a simple test using Selenium WebDriver.
 */
public class MySeleniumProject00 {

    /**
     * The main method - entry point of the program.
     * This method sets up the WebDriver, opens a browser, and performs basic actions.
     *
     * @param args Command line arguments (not used in this program)
     */
    public static void main(String[] args) {

        // Configuration for ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Automatically sets up the ChromeDriver for use with the installed version of Chrome.

        // Create a new instance of the Chrome WebDriver
        WebDriver driver = new ChromeDriver();
        // This instance will control the Chrome browser.

        try {
            // Navigate to the specified web page
            driver.get("https://getbootstrap.com/docs/5.3/examples/checkout/");

            // Fill in the form
            driver.findElement(By.id("firstName")).sendKeys("John");
            driver.findElement(By.id("lastName")).sendKeys("Doe");
            driver.findElement(By.id("username")).sendKeys("lolyou1993");
            driver.findElement(By.id("email")).sendKeys("Johnnyboy@gmail.com");
            driver.findElement(By.id("address")).sendKeys("Block 369 ave 2");
            driver.findElement(By.id("address2")).sendKeys("Block 619 ave1");

            // Dropdown for Country
            WebElement countryDropdown = driver.findElement(By.id("country"));
            Select countrySelect = new Select(countryDropdown);
            countrySelect.selectByIndex(1); // Select the second country
            Thread.sleep(1000);
            System.out.println("Selected Country: " + countrySelect.getFirstSelectedOption().getText());

            // Dropdown for State
            WebElement stateDropdown = driver.findElement(By.id("state"));
            Select stateSelect = new Select(stateDropdown);
            stateSelect.selectByIndex(1); // Select the second state
            Thread.sleep(1000);
            System.out.println("Selected State: " + stateSelect.getFirstSelectedOption().getText());

            // Click checkboxes
            driver.findElement(By.id("same-address")).click();
            driver.findElement(By.id("save-info")).click();

            // Fill in additional fields
            driver.findElement(By.id("zip")).sendKeys("537619");
            driver.findElement(By.id("debit")).click();
            Thread.sleep(1000);

            driver.findElement(By.id("cc-name")).sendKeys("Mr World Wide");
            driver.findElement(By.id("cc-number")).sendKeys("6666666");
            driver.findElement(By.id("cc-expiration")).sendKeys("31/23");
            driver.findElement(By.id("cc-cvv")).sendKeys("123");
            Thread.sleep(1000);

            // Wait for the Submit button to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary.btn-lg")));

            // Scroll to the Submit button
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
            Thread.sleep(1000); // Allow time for scrolling

            // Click the Submit button
            submitButton.click();

            // Output the title of the web page
            System.out.println("Page title is: " + driver.getTitle());

        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
//Completed
