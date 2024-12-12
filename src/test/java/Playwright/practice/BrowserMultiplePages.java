package Playwright.practice;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class BrowserMultiplePages
{

    @Test
    public void multiplePagesHandling()
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bwContext = bw.newContext();
        BrowserContext bwContext1 = bw.newContext();
        //two separate browsers will be opened

        Page page = bwContext.newPage();
        Page page1 = bwContext1.newPage();

        page.navigate("https://demo.automationtesting.in/Register.html");
        page1.navigate("https://dev.automationtesting.in/");

        System.out.println(page.title());
    }

    @Test
    public void multipleTabsBrowser()
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bwContext = bw.newContext();
        //Only one browser and two new tabs

        Page page = bwContext.newPage();
        Page page1 = bwContext.newPage();

        page.navigate("https://demo.automationtesting.in/Register.html");
        page1.navigate("https://dev.automationtesting.in/");

        System.out.println(page.title());
    }

}
