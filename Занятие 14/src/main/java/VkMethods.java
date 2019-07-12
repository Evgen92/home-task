import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URISyntaxException;

public class VkMethods {

    private URIBuilder builder;

    public URIBuilder createBasicUrl(String methodName) throws URISyntaxException {
        String urlName = String.format("https://api.vk.com/method/wall.%s?", methodName);
        builder = new URIBuilder(urlName);
        builder.setParameter("access_token", "2b8c8742b1766dc6081afb4a9c105f6677c3df9c93a965fa9f5b3c47664e8d9d0775270707102275277ef")
                .setParameter("owner_id", "115125698")
                .setParameter("v", "5.101");
        return builder;
    }

    public URIBuilder postMessage(String message) throws URISyntaxException {
        URIBuilder builder = createBasicUrl("post");
        builder.setParameter("message", message);
        return builder;
    }

    public HttpResponse execute(URIBuilder builder) throws IOException, URISyntaxException {
        HttpGet request = new HttpGet(builder.build());
        HttpClient client = HttpClientBuilder.create().build();
        return client.execute(request);
    }

    public URIBuilder getById(String post_id) throws URISyntaxException {
        URIBuilder builder = createBasicUrl("getById");
        builder.setParameter("post_id", post_id);
        return builder;
    }

    public URIBuilder updateMessage(String message, String post_id) throws URISyntaxException {
        URIBuilder builder = createBasicUrl("edit");
        builder.setParameter("message", message);
        builder.setParameter("post_id", post_id);
        return builder;
    }

    public URIBuilder deleteMessage(String post_id) throws URISyntaxException {
        URIBuilder builder = createBasicUrl("delete");
        builder.setParameter("post_id", post_id);
        return builder;
    }
}
