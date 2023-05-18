package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
    @Tag("tag1")
    void testConstructor() {
        Assertions.assertEquals(APP1_NAME, app.getName());
    }

    @Test
    @Tag("tag2")
    void testRunning() {
        Assertions.assertDoesNotThrow(() -> {
            app.run();
        });

        Assertions.assertTrue(app.isRunning());
    }

    @Test
    @Tag("tag1")
    void testRunningInvalidTest() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            app.shutdown();
        });

        Assertions.assertFalse(app.isRunning());
    }
}
