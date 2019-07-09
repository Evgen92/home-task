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
        builder.setParameter("access_token", "76a27e693fd0ec17ed6351053a229539baf5b19380f40d4581e02f2e1559c37f07ad083af763753298e2d")
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

    public URIBuilder updateMessage(String message, String post_id) throws URISyntaxException {
        URIBuilder builder = createBasicUrl("edit");
        builder.setParameter("post_id", post_id);
        builder.setParameter("message", message);
        return builder;
    }

    public URIBuilder deleteMessage(String post_id) throws URISyntaxException {
        URIBuilder builder = createBasicUrl("delete");
        builder.setParameter("post_id", post_id);
        return builder;
    }
}
