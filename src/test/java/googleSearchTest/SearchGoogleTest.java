package googleSearchTest;

import com.codeborne.selenide.Condition;
import org.junit.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertEquals;

/**
 * Created by dmitryk on 08.11.15 22:54
 */
public class SearchGoogleTest {

    @Before
    public void openGooglePageTest() throws InterruptedException {
        open("https://www.google.com/ncr");
        getWebDriver().navigate();
    }

    @Test
    public void openSeleniumPageByGoogleSearch() {
        search("Selenium");
        assertListItemsFound(10);

        assertFirstListEntityHasText("Selenium automates browsers");
        clickOnFirstListEntity();

        assertTextOnPage("Donate to Selenium");

    }

    public void search(String text) {
        $("#lst-ib").sendKeys(text);
    }

    public void assertListItemsFound(int amount) {
        $$("#rso .srg .g").shouldHaveSize(amount);
    }

    public void assertFirstListEntityHasText(String text) {
        $(".g:nth-of-type(1) .rc .st").shouldHave(Condition.text(text));
    }

    public void clickOnFirstListEntity() {
        $(".g:nth-of-type(1) .rc .r>a").click();
    }

    public void assertTextOnPage(String text) {
        assertEquals(text, getWebDriver().getTitle());
    }

}
