package cn.chenzw.springboot.mybatis.modules.ext.log;

import org.apache.ibatis.logging.Log;

/**
 * 自定义SQL日志输出
 */
public class MybatisSqlPrintStatementOutImpl implements Log {


    public MybatisSqlPrintStatementOutImpl(String clazz) {

    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void error(String sql, Throwable e) {
        System.out.println("打印error SQL: " + sql);
        e.printStackTrace(System.err);
    }

    @Override
    public void error(String sql) {
        System.out.println("打印 error SQL: " + sql);
    }

    @Override
    public void debug(String sql) {
        System.out.println("打印 debug SQL: " + sql);
    }

    @Override
    public void trace(String sql) {
        System.out.println("打印 trace SQL: " + sql);
    }

    @Override
    public void warn(String sql) {
        System.out.println("打印 warn SQL: " + sql);
    }
}
