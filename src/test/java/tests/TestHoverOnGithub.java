package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestHoverOnGithub {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void neededPageShouldBeVisible() {
        // open main page github
        open("");
        $(byTagAndText("button","Solutions")).hover();
        $("[href=\"https://github.com/enterprise\"]").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }
}
