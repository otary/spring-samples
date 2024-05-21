package cn.chenzw.springboot.flowable.listener;

import lombok.extern.slf4j.Slf4j;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEntityEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.engine.delegate.event.FlowableActivityEvent;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 *
 * @author chenzw
 */
@Slf4j
@Component
public class ProcessEventListener implements FlowableEventListener {

    @Override
    public void onEvent(FlowableEvent event) {
        log.info("flowableEvent => {} - {}", event, event.getClass());
        if (event instanceof FlowableActivityEvent) {
            FlowableActivityEvent activityEvent = (FlowableActivityEvent) event;

            log.info("activityId => {}, activityType => {}, processDefinitionId => {}, processInstanceId => {}", activityEvent.getActivityId(), activityEvent.getActivityType(), activityEvent.getProcessDefinitionId(), activityEvent.getProcessInstanceId());

            if (activityEvent.getType() == FlowableEngineEventType.ACTIVITY_STARTED) {
                log.info("流程实例[{}]上线任务:开始 => {}", activityEvent.getProcessInstanceId());
            } else if (activityEvent.getType() == FlowableEngineEventType.ACTIVITY_COMPLETED) {
                log.info("流程实例[{}]上线任务:结束 => {}", activityEvent.getProcessInstanceId());
            }
        } else if (event instanceof FlowableEngineEntityEvent) {
            FlowableEngineEntityEvent entityEvent = (FlowableEngineEntityEvent) event;
            TaskEntity taskEntity = (TaskEntity) entityEvent.getEntity();
            Long xxx = taskEntity.getVariable("xxx", Long.class);

            //
            String processTaskId = taskEntity.getId();

            // 流程事件
            if (event.getType() == FlowableEngineEventType.PROCESS_STARTED) {

            } else if (event.getType() == FlowableEngineEventType.PROCESS_COMPLETED) {

            }

            // 用户任务事件
            if (event.getType() == FlowableEngineEventType.TASK_CREATED) {

            } else if (event.getType() == FlowableEngineEventType.TASK_COMPLETED) {

            }
        }
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }

    @Override
    public boolean isFireOnTransactionLifecycleEvent() {
        return false;
    }

    @Override
    public String getOnTransaction() {
        return null;
    }
}
