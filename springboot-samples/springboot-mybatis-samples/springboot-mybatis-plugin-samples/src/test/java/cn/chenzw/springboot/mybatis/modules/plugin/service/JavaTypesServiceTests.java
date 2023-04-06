package cn.chenzw.springboot.mybatis.modules.plugin.service;

import cn.chenzw.springboot.mybatis.MybatisPluginSamplesApp;
import cn.chenzw.springboot.mybatis.modules.plugin.entity.JavaTypesEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = MybatisPluginSamplesApp.class)
public class JavaTypesServiceTests {

    @Autowired
    JavaTypesService javaTypesService;

    @Test
    public void testListAll() {
        List<JavaTypesEntity> entity = javaTypesService.listAll();

        log.info(" => {}", entity);
    }

    @Test
    public void testListAllByPage() {
        PageHelper.startPage(0, 1);
        List<JavaTypesEntity> entities = javaTypesService.listAll();
        Assert.assertTrue(entities.size() == 1);

        Page page2 = (Page) entities;
        Assert.assertEquals(page2.getTotal(), 4);
        Assert.assertEquals(page2.getPages(), 4);

        List<JavaTypesEntity> entities2 = page2.getResult();
        Assert.assertTrue(entities2.size() == 1);
    }


    @Test
    public void testInsertBatch() {
        List<JavaTypesEntity> entities = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            JavaTypesEntity entity = new JavaTypesEntity();
            entity.setByteType((byte) i);
            entity.setShortType((short) 1);
            entity.setBytesType(new Byte[]{1});
            entity.setFloatType((float) 1);
            entity.setBooleanType(false);
            entity.setLongType(1L);
            entity.setCharacterType((char) i);
            entity.setBigDecimalType(new BigDecimal(i));
            entity.setDoubleType(1.2);
            entity.setDateType(new Date());
            entity.setLocalDate(LocalDate.now());
            entity.setLocalDateTime(LocalDateTime.now());

            entities.add(entity);
        }

        javaTypesService.insertBatch(entities);
    }

    @Test
    public void testListById() {
        List<JavaTypesEntity> entities = javaTypesService.listById(1);

        log.info(" => {}", entities);
    }


}
