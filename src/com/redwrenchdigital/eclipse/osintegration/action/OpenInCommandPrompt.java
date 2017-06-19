package com.redwrenchdigital.eclipse.osintegration.action;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.redwrenchdigital.eclipse.osintegration.Activator;

public class OpenInCommandPrompt extends AbstractAction {

    @Override
    protected void doAction(String path) {
        try {
            Runtime.getRuntime().exec("cmd /c start cmd", null, new File(path));
        } catch (IOException ex) {
            IStatus message = new Status(Status.ERROR, Activator.PLUGIN_ID, "Unable to open command prompt to path '" + path + "' - ex: " + ex);
            Activator.getDefault().getLog().log(message);
        }
    }
}
