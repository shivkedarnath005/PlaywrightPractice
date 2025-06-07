package Dropdown_Handling;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTests
{
    @Test
    public void selectDropdown() throws InterruptedException
    {
        String selectURL = "https://www.lambdatest.com/selenium-playground/select-dropdown-demo";
        String jqueryURL = "https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo";

        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate(selectURL);

        //Dropdown locator xpath
        Locator dayLocator = page.locator("//select[@id='select-demo']");

        //Select by Value
        dayLocator.selectOption("Tuesday");

        //Select by Label
        dayLocator.selectOption(new SelectOption().setValue("Friday"));

        //Select by Index
        dayLocator.selectOption(new SelectOption().setIndex(3));
        System.out.println("Days locator selected");

        //Select Multiple
        Locator statesLocator = page.locator("//select[@id='multi-select']");
        statesLocator.selectOption(new String [] {"Florida", "Ohio", "Texas"});

        //Find number of options in the dropdown
        Locator options = statesLocator.locator("option");
        List<String> allInnerTexts = options.allInnerTexts();
        allInnerTexts.forEach(option -> System.out.println("option"));
        //use for each loop to iterate it
        Thread.sleep(4000);

        System.out.println("Multiple states selected");

    }

    @Test
    public void jqueryDropdown() throws InterruptedException
    {
        String selectURL = "https://www.lambdatest.com/selenium-playground/select-dropdown-demo";
        String jqueryURL = "https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo";

        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate(jqueryURL);

        //Locate the dropdown
        Locator country = page.locator("span.select2-container").first();

        //Click the dropdown use common class dynamic xpath parent locator parent to child
        country.click();
        Locator result = page.locator("span.select2-results ul li", new Page.LocatorOptions().setHasText("India"));
        result.click();

        //select groups
        Locator files = page.locator("//select[@id='files']");
        files.selectOption("Ruby");

    }

}
