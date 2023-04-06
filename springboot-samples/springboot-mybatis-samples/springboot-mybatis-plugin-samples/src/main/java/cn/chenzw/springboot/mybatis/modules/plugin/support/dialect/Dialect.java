package cn.chenzw.springboot.mybatis.modules.plugin.support.dialect;

import cn.chenzw.springboot.mybatis.modules.plugin.support.Pageable;

/**
 * @author chenzw
 */
public interface Dialect {


    /**
     * 生成分页SQL
     *
     * @param sql
     * @param pageable
     * @return
     */
    String getPageSql(String sql, Pageable pageable);


    String getCountSql(String sql);

}
