package com.redwrenchdigital.eclipse.osintegration.action;

import java.io.IOException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.redwrenchdigital.eclipse.osintegration.Activator;

/**
 *
 * @author Sanjay Ginde
 *
 */
public class OpenInFileBrowser extends AbstractAction {

    @Override
    protected void doAction(String path) {
        try {
            Runtime.getRuntime().exec(new String[] { getOperatingSystem().getFileBrowserExecutable(), path });
        } catch (IOException ex) {
            IStatus message = new Status(Status.ERROR, Activator.PLUGIN_ID, "Unable to open file browser to path '" + path + "' - ex: " + ex);
            Activator.getDefault().getLog().log(message);
        }
    }
}
