package Screenshot;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class CaptureElementScreenshot
{

    @Test
    public void elementScreenshot() throws InterruptedException
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://dev.automationtesting.in/");

        page.locator("//img[@alt='logo']").screenshot(new Locator.ScreenshotOptions()
                .setPath(Paths.get("./Screenshots/logo.png")));

        page.locator("//button[normalize-space()='LOGIN']").screenshot(new Locator.ScreenshotOptions()
                .setPath(Paths.get("./Screenshots/login.png")));
        Thread.sleep(3000);
        pw.close();
    }
}
