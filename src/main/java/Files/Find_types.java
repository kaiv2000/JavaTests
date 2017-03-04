package Files;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class Find_types extends SimpleFileVisitor<Path> {

    public static void main(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final Find_types find_types = new Find_types();
        Files.walkFileTree(Paths.get("D:/"), options, 20, find_types);

        java.util.List<String> result = find_types.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        java.util.List<String> failed = find_types.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".zip") || file.toString().endsWith(".rar"))
            archived.add(file.toString());
        return super.visitFile(file, attrs);
    }

    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        failed.add(file.toString());
        return FileVisitResult.SKIP_SUBTREE;
    }

    private java.util.List<String> archived = new ArrayList<>();
    private java.util.List<String> failed = new ArrayList<>();

    public java.util.List<String> getArchived() {
        return archived;
    }

    public java.util.List<String> getFailed() {
        return failed;
    }
}
