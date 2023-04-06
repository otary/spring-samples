package cn.chenzw.springboot.logback.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

import java.util.Arrays;
import java.util.Objects;

/**
 * 自定义过滤器
 *
 * @author chenzw
 */
public class MyFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
        log("getMessage", event.getMessage());
        log("getFormattedMessage", event.getFormattedMessage());
        log("getLoggerName", event.getLoggerName());
        log("getThreadName", event.getThreadName());
        log("getArgumentArray", Arrays.toString(event.getArgumentArray()));
        log("getLevel", event.getLevel());
        log("getMarker", event.getMarker());
        log("getMDCPropertyMap", event.getMDCPropertyMap());
        log("getTimeStamp", event.getTimeStamp());

        return FilterReply.ACCEPT;
    }

    private void log(String key, Object msg) {
        System.out.println("   " + key + " => " + msg);
    }
}
