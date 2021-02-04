package cn.com.xuxiaowei.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Http 工具类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
public class HttpUtils {

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
