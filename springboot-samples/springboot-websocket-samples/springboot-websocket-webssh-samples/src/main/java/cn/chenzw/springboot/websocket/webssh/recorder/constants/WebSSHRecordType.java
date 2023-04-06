package cn.chenzw.springboot.websocket.webssh.recorder.constants;

/**
 * @author chenzw
 */
public enum WebSSHRecordType {

    IN("i"), OUT("o");

    private String tag;

    WebSSHRecordType(String tag) {
        this.tag = tag;
    }

    public String tag() {
        return tag;
    }


}
