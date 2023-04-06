package cn.chenzw.springboot.websocket.webssh.recorder.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface WebSSHRecordStorage {

    void write(byte[] bytes) throws IOException;

    void close() throws IOException;

    InputStream read() throws FileNotFoundException;
}
