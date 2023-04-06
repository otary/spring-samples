package cn.chenzw.springboot.mybatis.xml.controllers;

import cn.chenzw.springboot.mybatis.xml.domain.dto.JavaTypesEntityQueryDTO;
import cn.chenzw.springboot.mybatis.xml.domain.dto.PageResult;
import cn.chenzw.springboot.mybatis.xml.domain.entity.JavaTypesEntity;
import cn.chenzw.springboot.mybatis.xml.service.JavaTypesService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/types")
public class JavaTypesController {

    @Autowired
    JavaTypesService javaTypesService;

    @GetMapping("/list")
    public PageResult listAll(JavaTypesEntityQueryDTO javaTypesEntityQueryDTO) {
        PageHelper.startPage(0, 2);
        List<JavaTypesEntity> javaTypesEntities = javaTypesService.listAll(javaTypesEntityQueryDTO);
        log.info("=> {}" , javaTypesEntities);

        Page page = (Page) javaTypesEntities;
        log.info("page.getTotal => {}", page.getTotal());
        log.info("page => {}", page);

        PageInfo pageInfo = new PageInfo(javaTypesEntities);

        PageResult<List<JavaTypesEntity>> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setData(pageInfo.getList());
        pageResult.setCode(HttpStatus.OK.value());

        return pageResult;
    }

}
