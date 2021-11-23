import java.time.LocalDateTime;
import java.util.Observable;

public class FilesManager extends Observable {
    private DirectoryTree directoryTree;
    private FileMapper fileMapper;

    public FilesManager(){
        directoryTree = new DirectoryTree(new Directory("root", LocalDateTime.now()));
        fileMapper = new FileMapper();
    }

    public void addDirectory(String parentDirectoryName, String currentDirectoryName){
        try{
            DirectoryTree parent = directoryTree.getNode(parentDirectoryName);
            if(parent == null) throw new Exception("No directory found");
            directoryTree.addDirectory(parentDirectoryName, currentDirectoryName);
        } catch(Exception exception) {System.out.println(exception.getMessage());}
        this.setChanged();
    }

    public void changeFileLocation(String fileName, String parentDirectoryName, String desiredDirectoryName){
        try{
            DirectoryTree desiredParent = directoryTree.getNode(desiredDirectoryName);
            if(desiredParent == null) throw new Exception("No directory found");
            directoryTree.changeDirectory(parentDirectoryName, fileName, desiredDirectoryName);
        } catch(Exception exception) {System.out.println(exception.getMessage());}
        this.setChanged();
    }

    public void addFile(String parentDirectoryName, String currentFileName, int currentFileSize){
        try{
            DirectoryTree parent = directoryTree.getNode(parentDirectoryName);
            if(parent == null) {throw new Exception("No directory found");}
            parent.getData().addFile(currentFileName, currentFileSize);
            fileMapper.mapFileToFolder(parentDirectoryName, currentFileName);
        } catch(Exception exception){System.out.println(exception.getMessage());}
        this.setChanged();
    }

    public String showFiles(){
        String files = directoryTree.showFiles();
        this.setChanged();
        this.notifyObservers();
        return files;
    }

    public void deleteFile(String name){
        try{
            if(name == null) throw new Exception("No file");
            if(fileMapper.getDirectoryByFile(name) != null)
                directoryTree.getNode(fileMapper.getDirectoryByFile(name)).getData().deleteFile(name);
        } catch(Exception exception){System.out.println(exception.getMessage());}
        this.setChanged();
    }

    public void deleteDirectory(String name){
        try{
            if(name == "root") throw new Exception("Can't delete root directory");
            if(directoryTree.directory.delete() && directoryTree.deleteDir(name)) return;
        } catch(Exception exception){System.out.println(exception.getMessage());}
        this.setChanged();
    }


}
