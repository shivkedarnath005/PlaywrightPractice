package BrowserContext;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.HttpCredentials;
import org.testng.annotations.Test;

public class BrowserAuthentication {

    @Test
    public void browserAuthTest()
    {
        Playwright playwright = Playwright.create();
        BrowserType bwType = playwright.chromium();
        Browser browser  = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        Browser.NewContextOptions options = new Browser.NewContextOptions()
                .setHttpCredentials(new HttpCredentials("username", "password"));
        BrowserContext bwContext = browser.newContext(options);
        Page page = bwContext.newPage();
        page.navigate("https://playwright.dev/java/docs/test-assertions");

    }
}
