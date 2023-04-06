package cn.chenzw.springboot.websocket.webssh.recorder;

import cn.chenzw.springboot.websocket.webssh.recorder.constants.WebSSHRecordType;
import cn.chenzw.springboot.websocket.webssh.recorder.storage.WebSSHRecordStorage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author chenzw
 */
public class WebSSHRecorder {
    private Long startTimeStamp;

    private WebSSHRecordHeader recordHeader;

    private WebSSHRecordStorage recordStorage;

    private ObjectMapper mapper;

    public WebSSHRecorder(WebSSHRecordStorage recordStorage) {
        this.recordStorage = recordStorage;
        this.mapper = new ObjectMapper();
    }

    public void start() {
        if (this.recordHeader == null) {
            this.recordHeader = WebSSHRecordHeader.createDefault();
        }
        this.startTimeStamp = System.currentTimeMillis();
        // 先写入头部
        this.writeHead();
    }


    public void writeHead() {
        try {
            recordStorage.write(mapper.writeValueAsBytes(recordHeader));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(WebSSHRecordType recordType, String data) {
        Long currentTimeMillis = System.currentTimeMillis();
        Object[] record = new Object[3];
        record[0] = ((currentTimeMillis.doubleValue() - startTimeStamp.doubleValue()) / 1000);
        record[1] = recordType.tag();
        record[2] = data;

        try {
            recordStorage.write(mapper.writeValueAsBytes(record));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            recordStorage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
