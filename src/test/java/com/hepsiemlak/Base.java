package com.hepsiemlak;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class Base {
    public static AppiumDriver webDriver;
    ChromeOptions options = new ChromeOptions();
    public Logger log = Logger.getLogger(Base.class);

    @Before
    public void setup() throws MalformedURLException {
        BasicConfigurator.configure();
        log.info("------Mobile Web Testler Başlatılıyor------");
        String BaseUrl = "https://www.hepsiemlak.com/";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.out.println("android");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        capabilities.setCapability("ensureWebviewsHavePages", true);
        options.addArguments("test-type");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-translate");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-cache");

        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        webDriver = new AndroidDriver(url, capabilities);
        webDriver.get(BaseUrl);

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
