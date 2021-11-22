import java.util.ArrayList;
import java.util.LinkedList;

public interface Storage {

    public void write(byte[] content);
    public byte[] read(int path);
    public void delete(int path);
}
