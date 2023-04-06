package cn.chenzw.springboot.mybatis.modules.plugin.support.dialect.db;

import cn.chenzw.springboot.mybatis.modules.plugin.support.dialect.AbstractDialect;
import cn.chenzw.springboot.mybatis.modules.plugin.support.Pageable;

/**
 * Oracle实现
 *
 * @author chenzw
 */
public class OracleDialect extends AbstractDialect {


    @Override
    public String getPageSql(String sql, Pageable pageable) {
        int start = pageable.getOffset() * pageable.getLimit();
        int end = start + pageable.getLimit();

        return "SELECT * " + "  FROM (SELECT t________.*, ROWNUM rownum_ FROM (" + sql + ") t________) "
                + " WHERE rownum_ > " + start + "   AND rownum_ <= " + end;
    }
}
