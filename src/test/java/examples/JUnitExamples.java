package examples;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnitExamples {

    @BeforeAll
    static void BeforeAll() {
        System.out.println("### @beforeAll !");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("### @afterAll !");
    }

    @BeforeEach
    void beforeEach () {
        // open("google.com")
        System.out.println("### @beforeEach !");
    }

    @AfterEach
    void afterEach () {
        // open("google.com")
        System.out.println("### @afterEach !");
    }

    @Test
    void firstTest () {
        System.out.println("### @Test firstTest() !");
        assertTrue(3>2);
    }


    @Test
    void secondTest () {
        System.out.println("### @Test secondTest() !");
        assertFalse(3>2);
    }
}
