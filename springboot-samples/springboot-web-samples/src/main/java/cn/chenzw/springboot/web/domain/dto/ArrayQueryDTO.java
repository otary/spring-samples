package cn.chenzw.springboot.web.domain.dto;

import lombok.Data;

@Data
public class ArrayQueryDTO {

    // @ArrayParameter
    private String[] ids;

    private String name;


}
