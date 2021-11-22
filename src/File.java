import java.time.LocalDateTime;
import java.util.Arrays;

public class File extends Node {
    private long size;
    private byte[] content;
    LocalStorage localStorage = new LocalStorage();

    public File(String name, String parentDirectoryPath, byte[] content) {
        super(name, parentDirectoryPath);
        this.content = content;
        this.size = content.length;
    }

    public byte[] getContent() {
        return this.content;
    }

    @Override
    public long getSize() {
        if (content != null) {
            return Arrays.toString(content).getBytes().length;
        }
        return 0;
    }

    @Override
    public int compareTo(Node o) {

        return this.getName().compareTo(o.getName());
    }
}
