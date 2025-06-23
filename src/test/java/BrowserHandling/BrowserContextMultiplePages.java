package BrowserContext;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class BrowserContextMultiplePages
{
    @Test
    public void multiplePagesBrowserContext()
    {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        //Create new browser Multiple Browser Pages
        BrowserContext browserContext = browser.newContext();
        BrowserContext browserContext1 = browser.newContext();

        //Multiple browsers opening
        Page page = browserContext.newPage(); //open browser
        Page page1 = browserContext1.newPage(); //open another browser

        page.navigate("https://demo.automationtesting.in/Register.html");
        page1.navigate("https://dev.automationtesting.in/form");
    }

    @Test
    public void multipleTabsBrowserContext() throws InterruptedException {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        //Single Browser Multiple tabs pages
        BrowserContext browserContext = browser.newContext();

        Page page = browserContext.newPage(); //open browser
        Page page1 = browserContext.newPage(); //open another browser

        page.navigate("https://demo.automationtesting.in/Register.html");
        page1.navigate("https://dev.automationtesting.in/form");

        Thread.sleep(10000);
    }
}
