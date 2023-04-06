package cn.chenzw.springboot.mybatis.modules.plugin.support.dialect.factory;

import cn.chenzw.springboot.mybatis.modules.plugin.support.dialect.Dialect;
import cn.chenzw.springboot.mybatis.modules.plugin.support.dialect.db.*;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenzw
 */
public class DialectFactory {

    private static Map<String, Class<? extends Dialect>> dialectAliasMap = new HashMap<>();

    private static Map<String, Dialect> urlDialectMap = new ConcurrentHashMap<>();

    public static void registerDialectAlias(String alias, Class<? extends Dialect> dialectClass) {
        dialectAliasMap.put(alias, dialectClass);
    }

    static {
        registerDialectAlias("hsqldb", HsqlDialect.class);
        registerDialectAlias("h2", HsqlDialect.class);
        registerDialectAlias("postgresql", HsqlDialect.class);
        registerDialectAlias("phoenix", HsqlDialect.class);

        registerDialectAlias("mysql", MySqlDialect.class);
        registerDialectAlias("mariadb", MySqlDialect.class);
        registerDialectAlias("sqlite", MySqlDialect.class);

        registerDialectAlias("oracle", OracleDialect.class);
        //达梦数据库,https://github.com/mybatis-book/book/issues/43
        registerDialectAlias("dm", OracleDialect.class);
        //阿里云PPAS数据库,https://github.com/pagehelper/Mybatis-PageHelper/issues/281
        registerDialectAlias("edb", OracleDialect.class);

        registerDialectAlias("db2", Db2Dialect.class);

        registerDialectAlias("sqlserver2012", SqlServer2012Dialect.class);
        registerDialectAlias("derby", SqlServer2012Dialect.class);
    }


    public static Dialect getDialect(String jdbcUrl) {

        if (urlDialectMap.containsKey(jdbcUrl)) {
            return urlDialectMap.get(jdbcUrl);
        }

        String dbType = getDbTypeFormUrl(jdbcUrl);
        if (StringUtils.isEmpty(dbType)) {
            throw new IllegalArgumentException("找不到[" + jdbcUrl + "]对应的数据库类型!");
        }

        if (!dialectAliasMap.containsKey(dbType.toLowerCase())) {
            throw new RuntimeException("找不到[" + dbType + "]对应的Dialect处理类!");
        }

        Class<? extends Dialect> dialectClazz = dialectAliasMap.get(dbType.toLowerCase());
        Dialect dialect = null;
        try {
            dialect = dialectClazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("初始化 [" + dialectClazz.getName() + "] 时出错!");
        }
        urlDialectMap.put(jdbcUrl, dialect);
        return dialect;
    }


    private static String getDbTypeFormUrl(String jdbcUrl) {
        for (String dialect : dialectAliasMap.keySet()) {
            if (jdbcUrl.indexOf(":" + dialect + ":") != -1) {
                return dialect;
            }
        }
        return null;
    }

}
