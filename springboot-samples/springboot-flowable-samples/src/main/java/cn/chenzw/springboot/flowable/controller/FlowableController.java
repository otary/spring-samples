package cn.chenzw.springboot.flowable.controller;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://tkjohn.github.io/flowable-userguide/#_introduction
 */
@Slf4j
@RestController
@RequestMapping("/flowable")
public class FlowableController {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    ProcessEngine processEngine;

    @PostMapping("/process")
    public void startProcessInstance() {
        runtimeService.startProcessInstanceByKey("testProcess");
    }

    @GetMapping
    public String index(String name) {
        log.info("hello world!");
        return "hello world!";
    }
}
