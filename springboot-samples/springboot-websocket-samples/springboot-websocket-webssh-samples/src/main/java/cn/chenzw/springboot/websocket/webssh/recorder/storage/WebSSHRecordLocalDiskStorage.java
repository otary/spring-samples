package cn.chenzw.springboot.websocket.webssh.recorder.storage;

import java.io.*;

/**
 * @author chenzw
 */
public class WebSSHRecordLocalDiskStorage implements WebSSHRecordStorage {

    private File file;

    private OutputStream os;


    public WebSSHRecordLocalDiskStorage(File file) {
        this.file = file;
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        if (this.os == null) {
            try {
                this.os = new BufferedOutputStream(new FileOutputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        this.os.write(bytes);
        this.os.write("\r\n".getBytes());
        this.os.flush();
    }

    @Override
    public void close() throws IOException {
        if (this.os != null) {
            this.os.flush();
            this.os.close();
        }
    }

    @Override
    public InputStream read() throws FileNotFoundException {
        return new BufferedInputStream(new FileInputStream(file));
    }
}
