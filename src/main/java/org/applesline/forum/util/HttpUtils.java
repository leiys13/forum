package org.applesline.forum.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
/**
 * http工具类。
 *
 * Created by liuyaping on 2018/3/26
 */
public class HttpUtils {

    private static ConnectionSocketFactory httpConnects = new PlainConnectionSocketFactory();
    private static SSLContext sslContext = SSLContexts.createSystemDefault();
    private static SSLConnectionSocketFactory sslConnects = new SSLConnectionSocketFactory(
            sslContext,
            NoopHostnameVerifier.INSTANCE);
    // 支持http与https
    private static Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
            .register("http", httpConnects)
            .register("https", sslConnects)
            .build();
    private static HttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);

    private HttpUtils() {}

    /**
     * 发起get请求并返回Json对象
     *
     * @param url 请求地址。
     * @return JsonObject
     * @throws Exception
     */
    public static JsonObject getToJson(String url) throws Exception {
        return  new Gson().fromJson(get(url,new HashMap<>()), JsonObject.class);
    }

    /**
     * 发起post请求并返回Json对象
     *
     * @param url 请求地址。
     * @return JsonObject
     * @throws Exception
     */
    public static JsonObject postToJson(String url) throws Exception {
        return  new Gson().fromJson(post(url,new HashMap<>()), JsonObject.class);
    }

    /**
     * 发起http get请求。
     *
     * @param url 请求的http地址
     * @return 请求结果
     * @throws IOException
     */
    public static String get(String url) throws Exception {
        return get(url,new HashMap<>());
    }

    /**
     * 发起http get请求。
     *
     * @param url 请求的http地址
     * @param params 参数  map结构
     * @return 请求结果
     * @throws IOException
     */
    public static String get(String url,Map<String,String> params) throws Exception {
        HttpGet httpGet = null;
        try {
            URI uri = getURI(url,params == null ? new HashMap<>() : params);
            HttpClient httpClient = getHttpClient();
            //发送get请求
            httpGet = new HttpGet(uri);
            HttpResponse response = httpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity());
        } finally {
            if(httpGet != null) {
                httpGet.releaseConnection();
            }
        }

    }

    /**
     * 发起http post请求。
     *
     * @param url 请求的http地址
     * @return 请求结果
     * @throws IOException
     */
    public static String post(String url) throws Exception {
        return post(url,new HashMap<>());

    }

    /**
     * 发起http post请求。
     *
     * @param url 请求的http地址
     * @param params 参数  map结构
     * @return 请求结果
     * @throws IOException
     */
    public static String post(String url,Map<String,String> params) throws Exception {
        HttpPost httpPost = null;
        try {
            URI uri = getURI(url,params == null ? new HashMap<>() : params);
            HttpClient httpClient = getHttpClient();
            httpPost = new HttpPost(uri);
            HttpResponse response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        } finally {
            if(httpPost != null) {
                httpPost.releaseConnection();
            }
        }

    }


    /**
     * 根据请求地址，请求参数构建uri对象。
     *
     * @param url 请求地址
     * @param params 请求参数
     * @return uri对象
     * @throws URISyntaxException
     */
    public static URI getURI(String url,Map<String,String> params) throws URISyntaxException {
        URI uri = new URI(url);
        URIBuilder uriBuilder = new URIBuilder()
                .setScheme(uri.getScheme())
                .setHost(uri.getHost())
                .setPort(uri.getPort())
                .setPath(uri.getPath());
        params.entrySet().forEach(e-> {
            uriBuilder.setParameter(e.getKey(),e.getValue());
        });
        return uriBuilder.build();
    }

    /**
     * 获取HttpClient对象
     *
     * @return httpClient
     */
    private static CloseableHttpClient getHttpClient() {
        return HttpClients.custom()
                .setConnectionManager(cm)
                .build();
    }

}
