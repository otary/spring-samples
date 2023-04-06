package cn.chenzw.springboot.mybatis.modules.plugin.support.dialect.db;

import cn.chenzw.springboot.mybatis.modules.plugin.support.dialect.AbstractDialect;
import cn.chenzw.springboot.mybatis.modules.plugin.support.Pageable;

public class HsqlDialect extends AbstractDialect {

    @Override
    public String getPageSql(String sql, Pageable pageable) {
        StringBuilder sqlBuilder = new StringBuilder(sql.length() + 50);
        sqlBuilder.append(sql);
        if (pageable.getLimit() > 0) {
            sqlBuilder.append(" LIMIT ").append(pageable.getLimit());
        }
        if (pageable.getOffset() > 0) {
            int startRow = pageable.getOffset() * pageable.getLimit();
            sqlBuilder.append(" OFFSET ").append(startRow);
        }
        return sqlBuilder.toString();
    }
}
