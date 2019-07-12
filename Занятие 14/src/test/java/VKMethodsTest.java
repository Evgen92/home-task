import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class VKMethodsTest {

    VkMethods vkMethods;
    String post_id;
    private static final Logger log = Logger.getLogger(VKMethodsTest.class);

    @BeforeTest
    public void setUp() {
        vkMethods = new VkMethods();
    }

    @Test
    public void postMessageTest() throws URISyntaxException, IOException {
        URIBuilder builder = vkMethods.postMessage("Bugaga");
        log.info("First log");
        String result = EntityUtils.toString(vkMethods.execute(builder).getEntity());
        post_id = result.substring(23, 26);
        URIBuilder builder1 = vkMethods.getById(post_id);
        Assert.assertNotNull(builder1);
        log.error("You make a mistake");
        URIBuilder builder2 = vkMethods.updateMessage("Bugagaga", post_id);
        String result1 = EntityUtils.toString(vkMethods.execute(builder2).getEntity());
        log.fatal("Explosion");
        URIBuilder builder3 = vkMethods.deleteMessage(post_id);
        String result2 = EntityUtils.toString(vkMethods.execute(builder3).getEntity());
        log.info("Happy End");
    }
}
