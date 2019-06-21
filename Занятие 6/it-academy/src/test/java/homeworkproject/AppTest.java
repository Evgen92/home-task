package homeworkproject;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class AppTest {

    private App app;

    @BeforeEach
    void initApp() {
        app = new App();
    }

    @AfterEach
    void afterApp() {
        app = null;
    }

    @Test(expected = NullPointerException.class)
    public void testQCountWords() {
        Assertions.assertEquals("Byratino", app.countWords(null));
    }

    @Ignore
    @Test
    public void testWCountWords() {
        String str = "vvvv lenin milo kri";
        int exceptedResult = 5;
        int actualResult = app.countWords(str);
        Assertions.assertEquals(actualResult, exceptedResult);
    }

    @Test(expected = NullPointerException.class)
    public void testECountWords() {
        int expectedResult = 3;
        String str = "vvvv lenin milo";
        int actualResult = app.countWords(str);
        Assertions.assertEquals(actualResult, expectedResult);
    }

    @Test(expected = NullPointerException.class)
    public void testQEndWord() {
        Assertions.assertEquals("Pinokkio", app.endWord(null));
    }

    @Test(expected = NullPointerException.class)
    public void testWEndWord() {
        String str = "enot powel v korobok";
        String actualResult = app.endWord(str);
        String expectedResult = "korobok";
        Assertions.assertEquals(actualResult, expectedResult);
    }

    @RunWith(value = Parameterized.class)
    public class tstMult {

        private int passValue1;
        private int passValue2;
        private int expectedResult;
        private App app;

        @Parameterized.Parameters
        public Collection set_of_parameters() {
            return Arrays.asList(new Object[][]{
                            {8, 4, 2},
                            {6, 6, 1},
                            {20, 5, 4}
                    }
            );
        }

        public tstMult(int expectedResult, int passValue1, int passValue2) {
            this.expectedResult = expectedResult;
            this.passValue1 = passValue1;
            this.passValue2 = passValue2;
        }

        @Before
        public void setUp() {
            app = new App();
        }

        @Test
        public void tstMult() {
            Assertions.assertEquals(expectedResult, app.getMult(passValue1, passValue2));
        }
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
