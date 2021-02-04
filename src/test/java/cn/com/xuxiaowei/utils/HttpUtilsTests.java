package cn.com.xuxiaowei.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
    void getDefault() throws IOException {
        String getDefault = HttpUtils.getDefault("http://www.baidu.com");
        log.info(getDefault);
    }

}
