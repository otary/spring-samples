package cn.chenzw.springboot.logback.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TriggeringPolicy;

/**
 * 根据标签生成文件名
 *
 * @author chenzw
 */
public class MyMarkerRollingFileAppender extends RollingFileAppender<ILoggingEvent> {


    @Override
    protected void subAppend(ILoggingEvent event) {
        String file = getFile();

        if (event.getMarker() != null) {
            file = file.replace("{aaa}", event.getMarker().getName());
        }

        setFile(file);
       // start();

        super.subAppend(event);
    }
}
