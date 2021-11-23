import java.time.LocalDateTime;
import java.util.*;

public class Directory extends Node {
    private HashMap<String, Node> content;

    public Directory(String name, LocalDateTime createdAt){
        super(name, createdAt);
        this.content = new HashMap<String, Node>();
    }

    public String getName(){return this.name;}

    public void addFile(String name, int size){
        content.put(name, new File(name, size, LocalDateTime.now()));
    }

    public void deleteFile(String name){
        if(this.content.containsKey(name)) this.content.remove(name);
    }

    public boolean delete(){
        content.clear();
        return true;
    }



    @Override
    public String getContent(int treeLevel) {
        StringBuilder fileStructure = new StringBuilder();
        if(!this.content.isEmpty()){
            String adder = "";
            for(Node node : content.values()){
                if(treeLevel >= 0){
                    adder = new String(new char[treeLevel]).replace("\0", "--");
                }
                fileStructure.append(adder + node.getContent(0));
            }
        }
        return fileStructure.toString();
    }

}
