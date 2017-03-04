package Files;

import java.io.File;

import static sun.misc.Version.print;

public class CopyMirrorFolders
{
    private static final String sourceName = "d:/soft";
    private static final String destinationName = "d:/soft-2";

    public static void main(String[] args)
    {
        File source = new File(sourceName);
        File destination= new File(destinationName);

        copy(source, destination);
    }

    public static void copy(File source, File destionation)
    {
        if (source.isDirectory())
        {
            if (!(destionation.exists()))
            {
                destionation.mkdir();
            }
            for (File sourceSubDir : source.listFiles())
            {
                String subdirName = sourceSubDir.getName();
                copy(sourceSubDir, new File(destionation, subdirName));
            }
        }
    }

}
