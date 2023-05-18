package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AppTest {

    private static final String APP1_NAME = "App1";
    private static final String APP2_NAME = "App2";

    private App app;

    @BeforeEach
    void tearUp() {
        System.out.println("tearUp");
        app = new App(APP1_NAME);
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
        app = null;
    }

    @Test
    @Issue("DEV-123456")
    @Tag("tag1") @Tag("Merchant Hat")
    @Epic("Deferred")
    @Story("Advanced support for bdd annotations")
    @Feature("Expire Split Token")
    void testConstructor() {
        Assertions.assertEquals(APP1_NAME, app.getName());
    }

    @Test
    @Issue("DEV-123456")
    @Tag("tag2") @Tag("Risk")
    @Epic("Deferred")
    @Feature("Getting the Authorization")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Base support for bdd annotations")
    void testRunning() {
        Assertions.assertDoesNotThrow(() -> {
            app.run();
        });

        Assertions.assertTrue(app.isRunning());
    }

    @Test
    @Tag("tag1") @Tag("plataform")
    @Epic("Instant")
    @Feature("Not Sufficient Funds")
    @Story("Base support for bdd annotations")
    @Story("Advanced support for bdd annotations")
    @Severity(SeverityLevel.BLOCKER)
    void testRunningInvalidTest() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            app.shutdown();
        });

        Assertions.assertFalse(app.isRunning());
    }
}
