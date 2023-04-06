package cn.chenzw.springcloud.nacos.serivce;

import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.config.NacosConfigService;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author chenzw
 */
@Slf4j
public class NacosConfigServiceTests {


    public static void main(String[] args) throws NacosException {
        System.setProperty("nacos.client.contextPath", "nacos");

        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, "127.0.0.1");
        properties.put(PropertyKeyConst.NAMESPACE, "71fba189-0ef1-4a49-a1ab-d66f3ebbce8c");
        properties.put(PropertyKeyConst.CONTEXT_PATH, "nacos");

        NacosConfigService nacosConfigService = new NacosConfigService(properties);
        String dataId = "otary-common.yml";
        String group = "DEFAULT_GROUP";

        String config = nacosConfigService.getConfigAndSignListener(dataId, group, 3000L, new Listener() {
            @Override
            public Executor getExecutor() {
                return Executors.newScheduledThreadPool(10);
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                log.info("接收到配置信息 => {}", configInfo);
            }
        });

        log.info("主动获取配置 => {}", config);

        // Thread.sleep(10000);
    }
}
