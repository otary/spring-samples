package cn.chenzw.springboot.mybatis.annotation.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class JavaTypesProvider {


    public String findBy() {
        return new SQL() {
            {
                SELECT("*");
                FROM("java_types_entity");
                WHERE("byte_type = #{byteType}");
            }
        }.toString();
    }
}
