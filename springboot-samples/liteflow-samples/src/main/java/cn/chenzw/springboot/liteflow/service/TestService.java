package cn.chenzw.springboot.liteflow.service;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenzw
 */
@Slf4j
@Service
public class TestService {

    @Autowired
    private FlowExecutor flowExecutor;

    public void test() {
        LiteflowResponse response = flowExecutor.execute2Resp("test-chain", "arg");
        log.info("success => {}", response.isSuccess());
    }

}
