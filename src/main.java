




public class main {

    public static void main(String[] args) {
        LocalStorage localStorage = new LocalStorage();
        Directory root = new Directory("root", "/root");
        Directory desktop = new Directory("desktop", "/root/desktop");
        Directory music = new Directory("music", "/root/desktop/music");
        File anyFile = new File("myFile", "/root/desktop", new byte[]{(byte) 0xa, (byte) 0xb});
        File song = new File("Pearl Jam- Black.mp4", "/root/music/", new byte[]{(byte) 0xbb, (byte) 0xaa});
        File song2 = new File("Alice In Chains- Nutshell.mp4", "/root/music/", new byte[]{(byte) 0xba, (byte) 0xab});
        File song3 = new File("Led Zeppelin- Since I've Been Loving You.mp4", "/root/music/", new byte[]{(byte) 0xba, (byte) 0xab});
        root.add(desktop);
        root.add(anyFile);
        desktop.add(music);
        music.add(song);
        music.add(song2);
        music.add(song3);

        System.out.println(root.getChildren());

        root.getNodes().forEach(node -> {
            System.out.println(node.isDirectory());
        });
    }
}
