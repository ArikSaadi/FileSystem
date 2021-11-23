import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Node {
    protected String name;
    protected LocalDateTime createdAt;


    public Node(String name, LocalDateTime createdAt) {
        try{
            if(name.length() > 32) throw new Exception("Name too long");
            else if(name.isEmpty()) throw new Exception("Name is empty");
            else this.name = name;
            this.createdAt = createdAt;
        } catch(Exception exception){
                if(exception.getMessage() == "Name too long") System.out.println("Name too long");
                if(exception.getMessage() == "Name is empty") System.out.println("Name is empty");
            }
        }

    public String getName() {return this.name;}
    public String getCreatedAt() {return this.createdAt.toString();}

    public abstract String getContent(int treeLevel);

}
