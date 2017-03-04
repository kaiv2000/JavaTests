package DataBases;

import java.io.IOException;

public class DAOtest {

    public static void main(String[] args) {
        new DAOtest().connectToDB();
    }

    void connectToDB(){

        try {

            Process process = new ProcessBuilder("C:\\Program Files\\Internet Explorer\\iexplore.exe", "-k","\\\\svua1004\\infos\\Instructions SR01\\Instructions_GM.htm").start();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("Done!");

    }

}
