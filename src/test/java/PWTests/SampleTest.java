package PWTests;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class SampleTest
{
    @Test
    public void sampleTest()
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://demo.automationtesting.in/Register.html");


    }
}
