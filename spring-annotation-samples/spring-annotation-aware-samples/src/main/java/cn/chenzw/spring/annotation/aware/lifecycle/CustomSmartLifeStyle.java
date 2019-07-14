package cn.chenzw.spring.annotation.aware.lifecycle;

import org.springframework.context.SmartLifecycle;

/**
 * 生命周期示例
 * @author chenzw
 */
public class CustomSmartLifeStyle implements SmartLifecycle {

    @Override
    public boolean isAutoStartup() {
        return false;
    }

    @Override
    public void stop(Runnable callback) {

    }

    @Override
    public void start() {
        System.out.println("----------SmartLifeStyle start--------------");
    }

    @Override
    public void stop() {
        System.out.println("----------SmartLifeStyle stop--------------");
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
