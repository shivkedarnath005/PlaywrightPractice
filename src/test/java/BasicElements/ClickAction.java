package BasicElements;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class ClickAction
{
    @Test
    public void clickButtonTest() throws InterruptedException
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://dev.automationtesting.in/form");
        page.locator("//input[@id=':r0:']").fill("Amol");
        System.out.println("The playwright fill method is executed");
        Thread.sleep(2000);
        
    }

    @Test
    public void clickButton()
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();
        Locator loginButton = page.locator("login.sss");

    }
}
