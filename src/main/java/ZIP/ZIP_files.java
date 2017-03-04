package ZIP;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZIP_files {

    public static void main(String[] args) throws IOException {

        String filename = args[0];
        String zipName = args[1];

        Path tmpFolder = Files.createTempDirectory("forZIP");

        extractZipToTempFolder(zipName, tmpFolder);
        addFileToZip(zipName,filename,tmpFolder);
    }


    static void extractZipToTempFolder(String zipName, Path tempFolder) throws IOException {

        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipName));
        ZipEntry entry = zipIn.getNextEntry();
        while (entry != null) {
            String tempFilePath = tempFolder + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tempFilePath));
                byte[] bytesIn = new byte[4096];
                int read = 0;
                while ((read = zipIn.read(bytesIn)) != -1) {
                    bos.write(bytesIn, 0, read);
                }
                bos.close();
            } else {
                File dir = new File(tempFilePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
    }

    static void addFileToZip(String zipName, String fileForAdding, Path tempFolder) throws IOException {

        File tempZipFile = File.createTempFile("new",".zip");
        File addFile = new File(fileForAdding);
        ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(tempZipFile)));
        File sourceFolder = new File(tempFolder.toString());

        for (File oneFile : sourceFolder.listFiles())
        {
            zipOut.putNextEntry(new ZipEntry(oneFile.getName()));
            Files.copy(oneFile.toPath(), zipOut);
            oneFile.delete();
        }
        zipOut.putNextEntry(new ZipEntry("new/" + addFile.getName()));

        Files.copy(addFile.toPath(), zipOut);
        sourceFolder.delete();
        tempZipFile.delete();
        zipOut.close();
    }

}
