package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void dragAndDropAandBActions() {
        // Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("/drag_and_drop");
        // Перенесите прямоугольник А на место В
//        $("#column-a").shouldHave(exactText("A"));
//        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        actions()
                .dragAndDrop($("#column-a"), $("#column-b"))
                .perform();
        // Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void dragAndDropAandBSelenide() {
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
