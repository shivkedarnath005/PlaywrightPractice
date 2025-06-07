package PracticeSites;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

public class MercuryRegistration
{

    @Test
    public void registrationForm() throws InterruptedException
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://demo.guru99.com/test/newtours/");
        page.locator("//a[normalize-space()='REGISTER']").click();

        //User registration form fill up
        //Contact Information
        page.locator("//input[@name='firstName']").fill("David");
        page.locator("//input[@name='lastName']").fill("Cameron");
        page.locator("//input[@name='phone']").fill("9860935084");
        page.locator("//input[@id='userName']").fill("davidcameron@gmail.com");

        //Mailing Information
        String address = "J M Road Shivaji Nagar";
        page.locator("//input[@name='address1']").fill(address);
        page.locator("//input[@name='city']").fill("Pune");
        page.locator("//input[@name='state']").fill("Maharashtra");
        page.locator("//input[@name='postalCode']").fill("411015");
        Locator countryDD = page.locator("//select[@name='country']");
        countryDD.selectOption(new SelectOption().setValue("ARGENTINA"));

        //User Information
        page.locator("//input[@id='email']").fill("davidcameron@gmail.com");
        page.locator("//input[@name='password']").fill("abc123");
        page.locator("//input[@name='confirmPassword']").fill("abc123");
        page.locator("//input[@name='submit']").click();
        Thread.sleep(3000);
        System.out.println("Use has been Successfully Registered Account");
        pw.close();

    }
}
