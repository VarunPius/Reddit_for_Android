package varunpius.redditclient;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

/**
 * Created by VarunPius on 10/12/2016.
 */

public class RedditClient {
    private final String API_BASE_URL = "http://reddit.com/.json";
    private AsyncHttpClient client;

    public RedditClient(){
        this.client = new AsyncHttpClient();
    }

    public void getPosts(JsonHttpResponseHandler handler){
        client.get(API_BASE_URL, handler);
    }

}
