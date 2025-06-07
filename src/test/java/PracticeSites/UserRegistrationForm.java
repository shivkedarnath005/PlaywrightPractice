package PracticeSites;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class UserRegistrationForm
{
    Playwright pw = Playwright.create();
    BrowserType bwType = pw.chromium();
    Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
    BrowserContext bwContext = bw.newContext();
    Page page = bwContext.newPage();

    @Test
    public void userRegistrationForm()
    {

        //Launch the application page
        page.navigate("https://demoqa.com/automation-practice-form");
        String firstName = "//input[@id='firstName']";
        String lastName = "//input[@id='lastName']";
        String email= "//input[@id='userEmail']";
        String maleGender = "//label[normalize-space()='Male']";
        String mobileNumber = "//input[@id='userNumber']";

        enterTextOnElement(firstName, "David");
        System.out.println("User Entered First Name");
        enterTextOnElement(lastName, "Cameron");
        System.out.println("User Entered Last Name");
        enterTextOnElement(email, "davidcameron@gmail.com");
        System.out.println("User Entered Email");
        click(maleGender);
        System.out.println("User Click Male Gender");
        enterTextOnElement(mobileNumber, "9860935084");
        System.out.println("User Entered Mobile Number");

    }

    public void click(String locator)
    {
        try
        {
            page.locator(locator).isVisible();
            page.locator(locator).click();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public void enterTextOnElement(String locator, String text)
    {
        try
        {
            if(page.locator(locator).isVisible())
            {
                page.locator(locator).fill(text);
            }
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
