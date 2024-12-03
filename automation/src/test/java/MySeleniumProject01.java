// Import statements to include necessary libraries
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // Selenium WebDriver library for browser automation
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; // ChromeDriver class to interact with Chrome browser
import io.github.bonigarcia.wdm.WebDriverManager; // WebDriverManager to manage browser drivers automatically
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Class representing a Selenium test.
 * This class contains methods to perform a simple test using Selenium WebDriver.
 */
public class MySeleniumProject01 {

    /**
     * The main method - entry point of the program.
     * This method sets up the WebDriver, opens a browser, and performs basic actions.
     *
     * @param args Command line arguments (not used in this program)
     */
    public static void main(String[] args) {

        // Configuration 1: Setting chromedriver manually
        /**
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
            // Create WebDriver instance
            WebDriver driver = new ChromeDriver();
        */
        // Configuration 2: for ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Automatically sets up the ChromeDriver for use with the installed version of Chrome.

        // Create a new instance of the Chrome WebDriver
        WebDriver driver = new ChromeDriver();
        // This instance will control the Chrome browser.

        try {
            // Navigate to a specified web page
            driver.get("https://getbootstrap.com/docs/5.3/examples/checkout/");
            // The get() method opens the URL in the Chrome browser.

            // Additional automation actions would be placed here

            // Fill in the form
            driver.findElement(By.id("firstName")).sendKeys("John");
            driver.findElement(By.id("lastName")).sendKeys("Doe");
            driver.findElement(By.id("email")).sendKeys("john.doe@example.com");
            driver.findElement(By.id("address2")).sendKeys("Apartment 1");
            driver.findElement(By.id("country")).sendKeys("United States");
            driver.findElement(By.id("zip")).sendKeys("90210");

            // Select a radio button
            WebElement sameAddressRadio = driver.findElement(By.id("same-address"));
            if (!sameAddressRadio.isSelected()) {
                sameAddressRadio.click();
            }

            // Select a checkbox
            WebElement saveInfoCheckbox = driver.findElement(By.id("save-info"));
            if (!saveInfoCheckbox.isSelected()) {
                saveInfoCheckbox.click();
            }

            // Select a radio button for payment method
            WebElement creditCardRadio = driver.findElement(By.id("paypal"));
            if (!creditCardRadio.isSelected()) {
                creditCardRadio.click();
            }

            // Click the Submit button by XPath
            WebElement submitButtonViaXpath = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/form/button"));
            submitButtonViaXpath.click();

            // Click the Submit button by CSS Selector
            WebElement submitButtonViaSelector = driver.findElement(By.cssSelector("body > div.container > main > div.row.g-5 > div.col-md-7.col-lg-8 > form > button"));
            submitButtonViaSelector.click();

            // Output the title of the web page
            System.out.println("Page title is: " + driver.getTitle());

            // Force wait of 5 seconds
            Thread.sleep(5000);


            /**
             * HANDS-ON EXERCISES
             * TO DO:
             * - Complete the form using Selenium Test Automation
             * - Payment should be Debit Card
             * - After the Submit button it should return no errors and return to the initial state
             * - Redundant/Duplicated Steps can be removed
             */

            /**
                Checkpoint to ensure no elements with 'invalid-feedback' class are present and the exercise is correct
                DO NOT UPDATE THIS PART
            **/
            List<WebElement> invalidFeedbackElements = driver.findElements(By.className("invalid-feedback"));
            boolean isVisible = false;
            for (WebElement element : invalidFeedbackElements) {
                if (element.isDisplayed()) {
                    isVisible = true;
                    break;
                }
            }
            if (!isVisible) {
                System.out.println("Checkpoint Passed: No visible 'invalid-feedback' elements found on the page.");
            } else {
                System.out.println("Checkpoint Failed: Visible 'invalid-feedback' elements found on the page.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
