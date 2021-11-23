import java.time.LocalDateTime;
import java.util.*;

public class Directory extends Node {
    private List<Node> nodes;
    private LocalStorage localStorage;

    public Directory(String name, String path){
        super(name, path);
        nodes = new ArrayList<>();
        localStorage = new LocalStorage();
        this.setPath(path);
        int elementInPath = this.getPath().length() - 1;
        String lastDir = this.getPath().split("/")[this.getPath().split("/").length - 1];
//        this.setParent(this.getPath().split("/")[elementInPath]);
    }

    public List<Node> getNodes(){
        return nodes;
    }


    public void add(Node node) {
        this.setChildren(node);
        node.setParent(this);
        nodes.add(node);
        if(!node.isDirectory()){
            localStorage.write(node.getContent());
        }
    }

    public ArrayList<String> getAllNodes(Node node){
        ArrayList<String> retList = new ArrayList<>();
        node.hasChildren(node);
        return retList;
    }


    @Override
    public long getSize() {
        long length = 0;
        for (Node node : nodes) {
            length += node.getSize();
        }
        return length;
    }

    @Override
    public int compareTo(Node o) {
        return this.getName().compareTo(o.getName());
    }
}
