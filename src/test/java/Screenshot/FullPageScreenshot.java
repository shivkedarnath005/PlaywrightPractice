package Screenshot;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FullPageScreenshot
{
    @Test
    public void pageScreenshot() throws InterruptedException
    {
        Playwright pw = Playwright.create();
        Page page = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false).setChannel("chrome")).newPage();

        page.navigate("https://demo.automationtesting.in/Register.html");

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/registration.png"))
                .setFullPage(true));

        Thread.sleep(2000);
        pw.close();
    }
}
