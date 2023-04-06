package cn.chenzw.springboot.mybatis.modules.plugin.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

/**
 * Java数据类型实体
 */
@Data
public class JavaTypesEntity {

    private Byte byteType;
    private Byte[] bytesType;
    private Boolean booleanType;
    private Short shortType;
    private Character characterType;
    private Integer integerType;
    private Float floatType;
    private Long longType;
    private Double doubleType;
    private BigDecimal bigDecimalType;
    private Date dateType;

    private LocalDate localDate;

    private LocalDateTime localDateTime;


    @Override
    public String toString() {
        return "JavaTypesEntity{" + "byteType=" + byteType + ", bytesType=" + Arrays.toString(bytesType)
                + ", booleanType=" + booleanType + ", shortType=" + shortType + ", characterType=" + characterType
                + ", integerType=" + integerType + ", floatType=" + floatType + ", longType=" + longType
                + ", doubleType=" + doubleType + ", bigDecimalType=" + bigDecimalType + '}';
    }

}
