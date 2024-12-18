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
        Browser bw = bwType.launch();
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://dev.automationtesting.in/form");
        page.locator("//input[@id=':r0:']").fill("Amol");
        Thread.sleep(2000);
        
    }
}
