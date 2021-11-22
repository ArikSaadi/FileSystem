import java.util.ArrayList;
import java.util.LinkedList;

public class LocalStorage implements Storage{

    private ArrayList<byte[]> storageList;

    public LocalStorage(){
        storageList = new ArrayList<byte[]>();
    }

    @Override
    public void write(byte[] content) {
        this.storageList.add(content);
    }

    @Override
    public byte[] read(int path) {
        return storageList.get(path);
    }

    @Override
    public void delete(int path) {
        storageList.remove(storageList.get(path));
    }

    public ArrayList<byte[]> getStorageList(){
        return storageList;
    }
}
