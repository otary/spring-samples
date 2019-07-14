package cn.chenzw.spring.annotation.aware.lifecycle;

import org.springframework.context.SmartLifecycle;

/**
 * 生命周期示例
 *
 * @author chenzw
 */
public class CustomSmartLifeStyle implements SmartLifecycle {


    private boolean isRunning = false;

    /**
     * 是否执行start()方法
     *
     * @return
     */
    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        System.out.println("----------SmartLifeStyle stop with callback--------------");

        isRunning = false;
    }

    @Override
    public void stop() {
        System.out.println("----------SmartLifeStyle stop--------------");

        isRunning = false;
    }


    @Override
    public void start() {
        System.out.println("----------SmartLifeStyle start--------------");

        isRunning = true;
    }


    @Override
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * 优先级（值越小优先级越高）
     *
     * @return
     */
    @Override
    public int getPhase() {
        return 0;
    }
}
