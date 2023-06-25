package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getNewInstance() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        drivers.set(driver);
        return getCurrentInstance();
    }

    public static WebDriver getCurrentInstance() {
        return drivers.get();
    }
}
