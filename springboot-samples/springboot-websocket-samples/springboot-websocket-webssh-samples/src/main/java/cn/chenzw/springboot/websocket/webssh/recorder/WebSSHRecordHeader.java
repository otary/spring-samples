package cn.chenzw.springboot.websocket.webssh.recorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenzw
 */
@Data
public class WebSSHRecordHeader {

    private Integer version;

    private Integer width;

    private Integer height;

    private Long timestamp;

    private Env env;


    public static WebSSHRecordHeader createDefault() {
        WebSSHRecordHeader recordHeader = new WebSSHRecordHeader();
        recordHeader.setVersion(2);
        recordHeader.setWidth(120);
        recordHeader.setHeight(30);
        recordHeader.setTimestamp(System.currentTimeMillis());
        recordHeader.setEnv(new Env(
                "/bin/bash",
                "xterm-256color"
        ));
        return recordHeader;
    }

    public WebSSHRecordHeader version(Integer version) {
        this.version = version;
        return this;
    }

    public WebSSHRecordHeader width(Integer width) {
        this.width = width;
        return this;
    }

    public WebSSHRecordHeader height(Integer height) {
        this.height = height;
        return this;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Env {

        private String shell;

        private String term;
    }
}
