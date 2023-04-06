package cn.chenzw.springboot.mybatis.modules.plugin.repository;

import cn.chenzw.springboot.mybatis.modules.plugin.entity.JavaTypesEntity;
import cn.chenzw.springboot.mybatis.modules.plugin.support.Pageable;
import cn.chenzw.toolkit.mybatis.core.support.MyBatisRepository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chenzw
 */
@MyBatisRepository
public interface JavaTypesMapper extends BaseMapper<JavaTypesEntity> {

    List<JavaTypesEntity> listAll();

    int insertBatch(@Param("javaTypesEntities") List<JavaTypesEntity> javaTypesEntities);

    int insertBatch2(@Param("javaTypesEntities") JavaTypesEntity[] javaTypesEntities);

    List<JavaTypesEntity> listById(@Param("id") Integer id, Pageable pageable);

}
