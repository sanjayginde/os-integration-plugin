package com.redwrenchdigital.eclipse.osintegration.action;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.redwrenchdigital.eclipse.osintegration.Activator;
import com.redwrenchdigital.eclipse.util.StringUtils;

public class OpenInCygwin extends AbstractAction {

    public static final String CYGWIN_DIR = "C:\\cygwin";

    @Override
    protected void doAction(String path) {
        try {
            String cmd = "cmd /c start cmd /c bash.exe --login -c 'cd \"`cygpath \"" + path + "\"`\";bash'";
            Runtime.getRuntime().exec(cmd, null, new File(StringUtils.joinFilePath(CYGWIN_DIR, "bin")));
        } catch (IOException ex) {
            IStatus message = new Status(Status.ERROR, Activator.PLUGIN_ID, "Unable to open command prompt to path '" + path + "' - ex: " + ex);
            Activator.getDefault().getLog().log(message);
        }
    }
}
