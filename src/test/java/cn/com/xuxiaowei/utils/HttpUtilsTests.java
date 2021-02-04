package cn.com.xuxiaowei.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Http 工具类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
class HttpUtilsTests {

    @Test
    void start() {

    }

    @Test
    void getUriScheme() throws URISyntaxException {
        Map<String, String> params = new HashMap<>();
        params.put("username", "xuxiaowei");
        params.put("password", "123");
        URI uri1 = HttpUtils.getUri("http", "www.baidu.com", "/s", params);
        log.info(uri1.toString());
    }

    @Test
    void getUri() throws URISyntaxException {
        Map<String, String> params = new HashMap<>();
        params.put("username", "xuxiaowei");
        params.put("password", "123");
        URI uri1 = HttpUtils.getUri("http://www.baidu.com", params);
        log.info(uri1.toString());
        URI uri2 = HttpUtils.getUri("http://www.baidu.com?a=1", params);
        log.info(uri2.toString());
    }

    @Test
    void mapToQuery() throws URISyntaxException {
        Map<String, String> params = new HashMap<>();
        params.put("username", "xuxiaowei");
        params.put("password", "123");
        String query = HttpUtils.mapToQuery(params);
        log.info(query);
    }

    @Test
    void getDefault() throws IOException {
        String getDefault = HttpUtils.getDefault("http://www.baidu.com");
        log.info(getDefault);
    }

}
