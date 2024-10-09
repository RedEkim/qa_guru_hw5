package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void dragAndDropFigure() {
        // Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("/drag_and_drop");
        // Перенесите прямоугольник А на место В
        $("#column-a").shouldHave(exactText("A"));
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        // Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(exactText("B"));
    }
}
