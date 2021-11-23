import java.time.LocalDateTime;

public class main {

    public static void main(String[] args) {
        FilesManager filesManager = new FilesManager();
        filesManager.addDirectory("root", "desktop");
        filesManager.addDirectory("desktop", "music");
        filesManager.addDirectory("music", "rock");

        filesManager.addFile("desktop", "myFile.txt", 5);
        filesManager.addFile("music", "Pearl Jam- Black.mp4", 5);
        filesManager.addFile("music", "Alice In Chains- Nutshell.mp4", 10);
        filesManager.addFile("music", "Led Zeppelin- Since I've Been Loving You.mp4", 5);
        filesManager.addFile("music", "Sting - Englishman In New york.mp4", 0);
        filesManager.showFiles();

    }
}
