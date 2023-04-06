package cn.chenzw.springboot.mybatis.modules.plugin.support.dialect.db;

import cn.chenzw.springboot.mybatis.modules.plugin.support.dialect.AbstractDialect;
import cn.chenzw.springboot.mybatis.modules.plugin.support.Pageable;

/**
 * @author chenzw
 */
public class H2Dialect extends AbstractDialect {

    @Override
    public String getPageSql(String sql, Pageable pageable) {
        return sql + " limit " + pageable.getLimit() + "  offset " + pageable.getOffset();
    }
}
