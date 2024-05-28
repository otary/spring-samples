package cn.chenzw.springboot.liteflow.component;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenzw
 */
@Slf4j
@LiteflowComponent("b")
public class BComponent extends NodeComponent {

    @Override
    public void process() throws Exception {
        log.info("执行B组件...");
    }
}
