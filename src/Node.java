import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Node implements Comparable<Node> {
    private String name;
    private LocalDateTime createdAt;
    private String path;
    private Node parent;
    private ArrayList<Node> children;
    private byte[] content;
    private int storageIndex;


    public Node(String name, String path) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.path = path;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public Node(String name, String path, byte[] content) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.path = path;
        this.parent = null;
        this.children = new ArrayList<>();
        this.content = content;
        this.storageIndex = -1;
    }

    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }

    public String getName(){
        return this.name;
    }

    public Node getParent(){
        return this.parent;
    }

    public void setParent(Node node){
        parent = node;
    }

    public ArrayList<Node> getChildren() {
        return this.children;
    }

    public void setChildren(Node node){
        this.children.add(node);
    }

    public String getPath(){
        return this.path;
    }

    public void setPath(String path){
        this.path = path;
    }

    public byte[] getContent(){
        return this.content;
    }


    public void setStorageIndex(int index){
        this.storageIndex = index;
    }

    public abstract long getSize();

    public boolean isDirectory(){
        return this instanceof Directory;
    }


    @Override
    public String toString() {
        String fileStruct =
                        "name= " + name +
                        "\nsize= " + getSize() +
                        "\ncreatedAt= " + createdAt;
        return fileStruct;
    }

}
