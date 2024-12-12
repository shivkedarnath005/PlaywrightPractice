package Playwright.practice;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class FirstPlaywrightProgram
{

    @Test
    public void firstProgram()
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch();
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        //Page page1 = Playwright.create().chromium().launch().newContext().newPage();

        page.navigate("https://playwright.dev/java/docs/input");

        System.out.println(page.title());
    }

    @Test
    public void chromiumDemo()
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://playwright.dev/java/docs/input");

        System.out.println(page.title());
    }

    @Test
    public void firefoxDemo()
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.firefox();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://playwright.dev/java/docs/input");

        System.out.println(page.title());
    }

    @Test
    public void webkitDemo()
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.webkit();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://playwright.dev/java/docs/input");

        System.out.println(page.title());
    }

    @Test
    public void chromeBrowserDemo()
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("Chrome"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://playwright.dev/java/docs/input");

        System.out.println(page.title());
    }

    @Test
    public void edgeDemo()
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://playwright.dev/java/docs/input");

        System.out.println(page.title());
    }
}
