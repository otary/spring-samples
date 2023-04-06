package cn.chenzw.springboot.mybatis.modules.plugin.support.dialect.db;

import cn.chenzw.springboot.mybatis.modules.plugin.support.dialect.AbstractDialect;
import cn.chenzw.springboot.mybatis.modules.plugin.support.Pageable;

public class Db2Dialect extends AbstractDialect {


    @Override
    public String getPageSql(String sql, Pageable pageable) {
        int startRow = pageable.getLimit() * pageable.getOffset();
        int endRow = pageable.getLimit() * (pageable.getOffset() + 1);

        StringBuilder sqlBuilder = new StringBuilder(sql.length() + 200);
        sqlBuilder.append("SELECT * FROM (SELECT TMP_PAGE.*,ROWNUMBER() OVER() AS ROW_ID FROM ( ");
        sqlBuilder.append(sql);
        sqlBuilder.append(" ) AS TMP_PAGE) TMP_PAGE WHERE ROW_ID BETWEEN ").append(startRow).append(" AND ").append(endRow);
        return sqlBuilder.toString();
    }
}
