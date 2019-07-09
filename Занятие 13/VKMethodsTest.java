import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class VKMethodsTest {

    VkMethods vkMethods;
    static String post_id;

    @BeforeTest
    public void setUp() {
        vkMethods = new VkMethods();
    }

    @BeforeMethod
    public void postMessageTest() throws URISyntaxException, IOException {
        URIBuilder builder = vkMethods.postMessage("Home no done");
        String result = EntityUtils.toString(vkMethods.execute(builder).getEntity());
        post_id = result.substring(23, 26);
        String expectedResult = "427";
        Assert.assertEquals(expectedResult, post_id);
    }

    @Test
    public void updateMessageTest() throws URISyntaxException, IOException {
        URIBuilder builder = vkMethods.updateMessage("Home done", post_id);
        EntityUtils.toString(vkMethods.execute(builder).getEntity());
    }

    @Test
    public void deleteMessageTest() throws URISyntaxException, IOException {
        URIBuilder builder = vkMethods.deleteMessage(post_id);
        EntityUtils.toString(vkMethods.execute(builder).getEntity());
    }
}
