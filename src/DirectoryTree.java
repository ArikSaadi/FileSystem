import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DirectoryTree {
    protected Directory directory = null;
    protected List<DirectoryTree> children = new ArrayList<>();
    protected DirectoryTree parent = null;
    protected DirectoryTree biggerChild = null;
    protected DirectoryTree smallerChild = null;

    public DirectoryTree(Directory directory){
        this.directory = directory;
    }

    public String showFiles(){
        StringBuilder fileStructure = new StringBuilder();
        fileStructure.append("Directory name: " + this.directory.getName() + ", " + "Creation date: " + this.directory.getCreatedAt() + "." + '\n');
        fileStructure.append(this.childrenToStr(1));
        return fileStructure.toString();
    }


    protected String childrenToStr(int treeLevel){
        StringBuilder fileStructure = new StringBuilder();
        String adder = new String(new char[treeLevel]).replace("\0", "--");
        for(DirectoryTree element : children){
            fileStructure.append(adder + "Directory name: " + element.directory.getName() + ", " + "Creation date: " + element.directory.getCreatedAt() + "." + '\n');
            fileStructure.append(element.childrenToStr(treeLevel + 1));
        }
        return fileStructure.toString();
    }

    public void addDirectory(String parentDirName, String dirName){
        DirectoryTree child = new DirectoryTree(new Directory(dirName, LocalDateTime.now()));
        DirectoryTree parent = getNode(parentDirName);
        parent.addChild(child);
        child.setParent(parent);
        this.updateTreePosition(parent, child);
    }

    public void changeDirectory(String parentDirName, String dirName, String desiredDirectoryName){
        DirectoryTree currentNode = this.getNode(dirName);
        DirectoryTree desiredParent = getNode(desiredDirectoryName);
        desiredParent.addChild(currentNode);
        currentNode.setParent(desiredParent);
        this.updateTreePosition(desiredParent, currentNode);
    }

    public DirectoryTree getNode(String name){
        if(name == null) return null;
        if(this.directory.getName().compareTo(name) == 0) return this;
        else if(this.directory.getName().compareTo(name) > 0){
            if(biggerChild == null) return null;
            return biggerChild.getNode(name);
        }
        else{
            if(smallerChild == null) return null;
            return smallerChild.getNode(name);
        }
    }

    public void updateTreePosition(DirectoryTree parent, DirectoryTree current){
        if(parent.directory.getName().compareTo(current.directory.getName()) > 0){
            if (biggerChild != null) biggerChild.updateTreePosition(parent, current);
            else biggerChild = current;
        }
        else{
            if (smallerChild != null) smallerChild.updateTreePosition(parent, current);
            else smallerChild = current;
        }
    }

    private void addChild(DirectoryTree child){
        child.setParent(this);
        this.children.add(child);
    }

    public boolean deleteDir(String name){
        DirectoryTree directoryTree = this.getNode(name);
        if(directoryTree == null) return false;
        directoryTree.getParent().getChildren().remove(directoryTree);
        directoryTree.setParent(null);
        directoryTree.getData().delete();
        return true;
    }

    public List<DirectoryTree> getChildren(){return this.children;}
    public Directory getData(){return this.directory;}
    public DirectoryTree getParent(){return parent;}
    public void setParent(DirectoryTree parent){this.parent = parent;}

}
