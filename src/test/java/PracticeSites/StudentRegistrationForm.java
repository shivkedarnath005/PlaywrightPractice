package PracticeSites;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import java.util.HashMap;

public class StudentRegistrationForm
{
    Playwright pw = Playwright.create();
    BrowserType bwType = pw.chromium();
    Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
    BrowserContext bwContext = bw.newContext();
    Page page = bwContext.newPage();

    private final HashMap<String, String> locatorMap = new HashMap<>();
    private final HashMap<String, String> infoMap = new HashMap<>();

    public StudentRegistrationForm()
    {
        //All web elements in page Locators
        locatorMap.put("studentFirstName", "//input[@placeholder='First Name']");
        locatorMap.put("studentLastName", "//input[@placeholder='Last Name']");
        locatorMap.put("studentEmail", "//input[@id='userEmail']");
        locatorMap.put("studentGender", "//label[normalize-space()='Male']");
        locatorMap.put("studentMobile", "//input[@placeholder='Mobile Number']");
        locatorMap.put("readingHobbies", "//label[normalize-space()='Reading']");
        locatorMap.put("hobbiesMusic", "//label[normalize-space()='Music']");
        locatorMap.put("currentAddress", "//textarea[@placeholder='Current Address']");
        locatorMap.put("submitButton", "//button[@id='submit']");

        //Web Elements Locators Info Map
        infoMap.put("studentFirstName", "First Name of Student");
        infoMap.put("studentLastName", "Last Name of Student");
        infoMap.put("studentEmail", "Email of Student");
        infoMap.put("studentGender", "Gender of Student");
        infoMap.put("studentMobile", "Mobile Number of Student");
        infoMap.put("readingHobbies", "Reading as Hobbies");
        infoMap.put("hobbiesMusic", "Music as Hobbies");
        infoMap.put("currentAddress", "Current Address of Stdent");
        infoMap.put("submitButton", "Submit Button of Form");

    }

    @Test
    public void fillRegistrationForm()
    {
        page.navigate("https://demoqa.com/automation-practice-form");

        enterTextOnElement("studentFirstName", "Ravi");
        System.out.println("Student First Name is entered");
        enterTextOnElement("studentLastName", "Jadhav");
        System.out.println("Student Last Name is entered");
        enterTextOnElement("studentEmail", "ravijadhav@gmail.com");
        System.out.println("Student Email is entered");
        clicks("studentGender");
        System.out.println("Student selected the Male as Gender");
        enterTextOnElement("studentMobile", "9860935084");
        System.out.println("Student Mobile Number is entered");
        clicks("readingHobbies");
        System.out.println("Student checked Reading as the Hobbies");
        clicks("hobbiesMusic");
        System.out.println("Student checked the Music as Hobbies");

        String StudentCurrentAddress = "Flat No 403, Sahara Colony, J M Road Shivaji Nagar Pune - 411015";
        enterTextOnElement("currentAddress", StudentCurrentAddress);
        System.out.println("Student Current Address is entered");
        clicks("submitButton");
        System.out.println("Student clicked on the Submit Button");
    }

    public void clicks(String locator)
    {
        try
        {
            page.locator(locator).isVisible();
            page.locator(locator).click();
        }
        catch (Exception e)
        {
            System.out.println("Fails to click " + infoMap.get(locator) + ". Locator is: " + locatorMap.get(locator));
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
            System.out.println("Fails to enter text " + infoMap.get(locator) + ". Locator is: " + locatorMap.get(locator));
            throw new RuntimeException(e);
        }
    }

}
