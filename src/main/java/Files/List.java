package Files;

import java.io.File;

public class List
{
    private static final String path = "d:/soft";

    public static void main(String[] args)
    {
        File file = new File(path);
        print(file);
    }

    public static void print(File rootFolder)
    {
        if (rootFolder.isFile())
        {
            System.out.println(rootFolder);
        }
        else
        {
            System.out.println("    " + rootFolder);
            File[] fileArray = rootFolder.listFiles();
            for (File oneFile : fileArray)
            {
                print(oneFile);
            }
        }
    }


}
