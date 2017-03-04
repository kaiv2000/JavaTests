package WMI;

import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellNotAvailableException;
import com.profesorfalken.jpowershell.PowerShellResponse;

public class getWMI {

    public static void main(String[] args) throws PowerShellNotAvailableException {

        PowerShell powerShell = null;
        try {
            powerShell = PowerShell.openSession();

            PowerShellResponse response = powerShell.executeCommand("Get-WmiObject Win32_BIOS");

            System.out.println(response.getCommandOutput());
        }
        catch(PowerShellNotAvailableException ex) {
            System.out.println("Powershall not installed on this PC");
        }
        finally {
            //Always close PowerShell session to free resources.
            if (powerShell != null)
                powerShell.close();
        }
    }
}
