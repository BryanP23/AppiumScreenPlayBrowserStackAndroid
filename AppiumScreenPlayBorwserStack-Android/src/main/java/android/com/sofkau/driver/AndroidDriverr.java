package android.com.sofkau.driver;

import io.appium.java_client.android.AndroidElement;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverr {
    public static io.appium.java_client.android.AndroidDriver<AndroidElement> driver;

    public static AndroidDriverr configureDriver() throws MalformedURLException {

        Dotenv dotenv = Dotenv.configure().load();

        String browserstackUser = dotenv.get("BROWSERSTACK_USER");
        String browserstackKey = dotenv.get("BROWSERSTACK_KEY");

        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            // Set your access credentials
            caps.setCapability("browserstack.user", browserstackUser);
            caps.setCapability("browserstack.key", browserstackKey);

            caps.setCapability("app", "bs://bc19675c0822e02286e281e0807dcec5969ae5d9");

            // Specify device and os_version for testing
            caps.setCapability("device", "Samsung Galaxy S23 Ultra");
            caps.setCapability("android_version", "13.0");

            // Set other BrowserStack capabilities
            caps.setCapability("project", "AppiumScreenPlayBrowserStackAndroid");
            caps.setCapability("build", "Android SauceLab build");
            caps.setCapability("name", "Flujo de compra test Android");

            driver =  new io.appium.java_client.android.AndroidDriver<AndroidElement>(new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);

        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return new AndroidDriverr();
    }

    public io.appium.java_client.android.AndroidDriver<AndroidElement> start(){
        return driver;
    }

}

