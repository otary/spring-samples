package cn.chenzw.springboot.mybatis.annotation.service;

import cn.chenzw.springboot.mybatis.annotation.domain.entity.JavaTypesEntity;
import cn.chenzw.springboot.mybatis.annotation.repository.JavaTypesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

@Service
public class JavaTypesService {

    @Autowired
    JavaTypesMapper javaTypesMapper;

    public List<JavaTypesEntity> listAll() {
        return javaTypesMapper.listAll();
    }

    public JavaTypesEntity findBy(byte byteType) {
        return javaTypesMapper.findBy(byteType);
    }

    public void insert(JavaTypesEntity javaTypesEntity) {
        Connection conn;
        DatabaseMetaData metaData = conn.getMetaData();

        ResultSet tables = metaData.getTables("", "");
        ResultSetMetaData metaData1 = tables.getMetaData();
        metaData1.getColumnType()
        javaTypesMapper.insert(javaTypesEntity);
    }

    public void update(JavaTypesEntity javaTypesEntity) {
        javaTypesMapper.update(javaTypesEntity);
    }
}
