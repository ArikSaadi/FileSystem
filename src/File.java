import java.time.LocalDateTime;
import java.util.Arrays;

public class File extends Node {
    private long size;


    public File(String name, int size, LocalDateTime createdAt) {
        super(name, createdAt);
        try{
            if (size < 1) throw new Exception("Size is not positive");
            else this.size = size;
        } catch (Exception exception){
            switch (exception.getMessage()){
                case "Size is not positive": System.out.println("Size is not positive");
            }
        }
    }

    @Override
    public String getContent(int treeLevel) {
        StringBuilder fileStructure = new StringBuilder();
        fileStructure.append("File name: " + this.name + ", " + "File size: " + this.size + ", " + "Creation date: " + this.createdAt.toString() + "." + '\n');
        return fileStructure.toString();
    }
}
