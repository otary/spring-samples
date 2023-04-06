package cn.chenzw.springboot.web.domain.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author chenzw
 */
@Data
public class UploadDTO {

    private MultipartFile file;

    private String name;

    private Long size;
}
