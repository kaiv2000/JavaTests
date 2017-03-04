package InetAddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {

    public static void main(String[] args) throws IOException {

        /*InetAddress address = InetAddress.getByName("wsua1905");
        InetAddress address2 = InetAddress.getLocalHost();

        System.out.println(address.getCanonicalHostName());
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
        System.out.println(address.getLocalHost());
        System.out.println(address2.getHostName());*/


//        String command = "cmd /c start cmd.exe";
        String command = "cmd /c start cmd.exe echo ][yzVjklfd1z RUNAS /profile /user: administrator";

        Process child = Runtime.getRuntime().exec(command);


      /*  String[]  stopAdmin= new String [] {
                "CMD.EXE",
                "/C",
                "echo password123 | RUNAS /profile /user:"
                        + "administrator"
                        + " ", "net", "stop", Service_Name};

        Process runtimeProcess = Runtime.getRuntime().exec(stopAdmin);*/

    }
}


