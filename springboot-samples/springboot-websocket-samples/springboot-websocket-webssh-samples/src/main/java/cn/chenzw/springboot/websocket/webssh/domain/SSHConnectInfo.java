package cn.chenzw.springboot.websocket.webssh.domain;

import cn.chenzw.springboot.websocket.webssh.recorder.WebSSHRecorder;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

/**
 * ssh连接信息
 */
@Data
public class SSHConnectInfo {

    private WebSocketSession webSocketSession;

    private JSch jSch;

    private Channel channel;

    private WebSSHRecorder recorder;
}
