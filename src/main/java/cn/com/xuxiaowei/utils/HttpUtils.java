package cn.com.xuxiaowei.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Http 工具类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
public class HttpUtils {

    /**
     * Map 转 参数
     *
     * @param params Map 参数
     * @return 返回 URI参数
     * @throws URISyntaxException 构建 URI 异常
     */
    public static String mapToQuery(Map<String, String> params) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder(uriBuilder, params);
        URI build = uriBuilder.build();
        return build.getQuery();
    }

    /**
     * Map 参数转换
     *
     * @param uriBuilder URI生成器
     * @param params     参数
     * @return 返回 Map 参数转换后的 URI生成器
     */
    private static URIBuilder uriBuilder(URIBuilder uriBuilder, Map<String, String> params) {
        if (params != null) {
            for (String param : params.keySet()) {
                String value = params.get(param);
                uriBuilder.setParameter(param, value);
            }
        }
        return uriBuilder;
    }

    /**
     * HttpGet
     *
     * @param uri URI
     * @return 返回 HttpGet 响应
     * @throws IOException 发送 HTTP 时异常
     */
    public static String getDefault(String uri) throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(uri);

        try (CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet)) {

            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            return EntityUtils.toString(httpEntity);

        } catch (ClientProtocolException e) {
            log.error("发送 HTTP 请求时，HTTP协议中有错误", e);
            throw new ClientProtocolException(e.getMessage());
        } catch (IOException e) {
            log.error("发送 HTTP 请求时，IO异常", e);
            throw new IOException(e.getMessage());
        }
    }

}
