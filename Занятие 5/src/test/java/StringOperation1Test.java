import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringOperation1Test {

    private StringOperation stringOperation;

    @BeforeMethod
    public void setUp() {
        stringOperation = new StringOperation();
    }

    @AfterMethod
    public void tearDown() {
        stringOperation = null;
    }

    @Test
    public void testGetReplace() {
        String expectedResult = "gogogogogo";
        String str = "fofofofofo";
        Assert.assertEquals(expectedResult, stringOperation.getReplace(str));
    }

    @Test
    public void testGetSplit() {
        String expectedResult = "pogoda";
        String str = " pogoda ";
        Assert.assertEquals(expectedResult, stringOperation.getTrim(str));
    }

    @DataProvider
    public Object[][] getStringUpperCase() {
        return new Object[][]{
                {"dfg", "DFG"},
                {"kok", "KOK"},
                {"pol", "POL"}
        };
    }

    @Test(dataProvider = "getStringUpperCase")
    public void testGetUppercase(String str, String expectedResult) {
        StringOperation stringOperation = new StringOperation();
        Assert.assertEquals(expectedResult, stringOperation.stringToUpperCase(str));
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testGetSubString() {
        int index = 4;
        String str = "gotgotogoto";
        String expectedResult = "gotogoto";
        Assert.assertEquals(expectedResult, stringOperation.getSubString(str, index));
    }

    @Test(enabled = false)
    public void testGetReplaceAll() {
        String expectedResult = "poplolpoplol";
        String str = "boblolboblol";
        Assert.assertEquals(expectedResult, stringOperation.getReplaceAll(str));
    }

    @Test
    public void testGetReplacesAll() {
        String expectedResult = "popalohapopalohapop";
        String str = "bobalohabobalohabob";
        Assert.assertEquals(expectedResult, stringOperation.getReplaceAll(str));
    }
}