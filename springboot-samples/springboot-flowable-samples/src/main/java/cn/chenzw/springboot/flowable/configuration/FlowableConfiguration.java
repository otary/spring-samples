package cn.chenzw.springboot.flowable.configuration;

import cn.chenzw.springboot.flowable.listener.ProcessEventListener;
import com.zaxxer.hikari.HikariDataSource;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngines;
import org.flowable.spring.ProcessEngineFactoryBean;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenzw
 */
@Configuration
public class FlowableConfiguration {

    @Autowired
    private ProcessEventListener processEventListener;

    /**
     * 自定义flowable配置
     *
     * @return
     */
    @Bean
    public EngineConfigurationConfigurer<SpringProcessEngineConfiguration> customConfigurer() {
        return engineConfiguration -> {
            // 将自定义监听器纳入flowable监听
            engineConfiguration.setTypedEventListeners(this.customFlowableListeners());
            // 流程deploy时不自动生成流程图片
            engineConfiguration.setCreateDiagramOnDeploy(false);
        };
    }

    private Map<String, List<FlowableEventListener>> customFlowableListeners() {
        Map<String, List<FlowableEventListener>> listeners = new HashMap<>();
        listeners.put("PROCESS_CREATED,PROCESS_STARTED,PROCESS_COMPLETED,PROCESS_CANCELLED,PROCESS_COMPLETED_WITH_TERMINATE_END_EVENT,ACTIVITY_STARTED,ACTIVITY_COMPLETED,TASK_CREATED,TASK_COMPLETED",
                Stream.of(this.processEventListener).collect(Collectors.toList())
        );
        return listeners;
    }


   /*
    @Bean
    public SpringProcessEngineConfiguration processEngineConfiguration(DataSource dataSource) {
        SpringProcessEngineConfiguration spec = new SpringProcessEngineConfiguration();
        spec.setDataSource(dataSource);
        // spec.setMailServerHost("");
        // spec.setMailServerPort(8080);
        return spec;
    }
    */

    /*
    @Bean
    public ProcessEngineFactoryBean processEngine(SpringProcessEngineConfiguration processEngineConfiguration) {
        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration(processEngineConfiguration);
        return processEngineFactoryBean;
    }
    */

}

