import java.util.Hashtable;

public class FileMapper {
    private Hashtable<String, String> directories;

    public FileMapper(){
        directories = new Hashtable<>();
    }

    public void mapFileToFolder(String parentDirectoryName, String fileName){
        directories.put(fileName, parentDirectoryName);
    }

    public String getDirectoryByFile(String name){
        return directories.getOrDefault(name, null);
    }

}
