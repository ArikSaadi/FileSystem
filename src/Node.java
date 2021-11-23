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
        return this.children!= null ? this.children : null;
    }

    public boolean hasChildren(Node node){
        return node.getChildren() != null;
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

    public abstract long getSize();

    public boolean isDirectory(){
        return this instanceof Directory;
    }


    @Override
    public String toString() {
        StringBuilder fileStruct = new StringBuilder();
        fileStruct.append("name= " + name + "\nisDirectory= " + isDirectory() + "\ncreatedAt= " + createdAt);
        return fileStruct.toString();
    }

}
