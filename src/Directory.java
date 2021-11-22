import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Directory extends Node {
    private Set<Node> nodes;
    private LocalStorage localStorage;

    public Directory(String name, String path){
        super(name, path);
        nodes = new TreeSet<Node>();
        localStorage = new LocalStorage();
        this.setPath(path);
        int elementInPath = this.getPath().length() - 1;
        String lastDir = this.getPath().split("/")[this.getPath().split("/").length - 1];
//        this.setParent(this.getPath().split("/")[elementInPath]);
    }

    public Set<Node> getNodes(){
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

    public ArrayList<Node> getAll(){

        for(Node node : this.nodes){
            if (!node.isDirectory()){

            }
        }
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
