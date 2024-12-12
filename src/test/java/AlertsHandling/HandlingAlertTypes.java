package AlertsHandling;

import com.microsoft.playwright.*;
import org.junit.Assert;
import org.testng.annotations.Test;

public class HandlingAlertTypes
{
    //Two types of date picker
    //Enabled and Disabled Date Picker
    @Test
    public void simpleAlertTest() throws InterruptedException
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.onDialog(dialog ->{
            String message = dialog.message();
            System.out.println("Dialog Text is : " + message);
            Assert.assertTrue(message.contains("I am a JS Alert"));
            dialog.accept();
        });

        page.locator("//button[normalize-space()='Click for JS Alert']").click();


    }

    @Test
    public void confirmAlertTest() throws InterruptedException
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.onDialog(dialog ->{
            String message = dialog.message();
            System.out.println("Dialog Text is : " + message);
            Assert.assertTrue(message.contains("I am a JS Confirm"));
            dialog.accept();
        });

        page.locator("//button[normalize-space()='Click for JS Confirm']").click();


    }

    @Test
    public void promptAlertTest() throws InterruptedException
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.onDialog(dialog ->{
            String message = dialog.message();
            System.out.println("Dialog Text is : " + message);
            Assert.assertTrue(message.contains("I am a JS prompt"));
            dialog.accept("Mukesh Otwani");
        });

        page.locator("//button[normalize-space()='Click for JS Prompt']").click();


    }
}
