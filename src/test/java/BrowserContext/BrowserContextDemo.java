package BrowserContext;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class BrowserContextDemo
{

    @Test
    public void browserContextDemo() throws InterruptedException {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        Browser browser = browserType.launch();
        //Create new incognito browser context Headless
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("https://demo.automationtesting.in/Register.html");
        Thread.sleep(5000);
        browserContext.close();
    }

}
