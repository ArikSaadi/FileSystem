import java.time.LocalDateTime;

public class main {

    public static void main(String[] args) {
        FilesManager filesManager = new FilesManager();
        filesManager.addDirectory("root", "desktop");
        filesManager.addDirectory("desktop", "music");

        filesManager.addFile("root", "myFile.txt", 5);
        filesManager.addFile("music", "Pearl Jam- Black.mp4", 5);
        filesManager.addFile("root", "Alice In Chains- Nutshell.mp4", 10);
        filesManager.addFile("desktop", "Led Zeppelin- Since I've Been Loving You.mp4", 5);
        filesManager.addFile("root", "Sting - Englishman In New york.mp4", 0);




        System.out.println(filesManager.showFiles());
        System.out.println(filesManager.fileMapper.getFiles());
        System.out.println(filesManager.fileMapper.getDirectoryByFile("myFile.txt"));
    }
}
