package com.redwrenchdigital.eclipse.osintegration.action;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.redwrenchdigital.eclipse.osintegration.OperatingSystem;
import com.redwrenchdigital.eclipse.osintegration.pathresolver.IPathResolver;
import com.redwrenchdigital.eclipse.osintegration.pathresolver.JavaElementPathResolver;
import com.redwrenchdigital.eclipse.osintegration.pathresolver.ModelElementPathResolver;
import com.redwrenchdigital.eclipse.osintegration.pathresolver.ResourcePathResolver;

/**
 * Base class for actions, handling tree items.
 *
 * @author Sanjay Ginde
 *
 */
abstract public class AbstractAction implements IObjectActionDelegate {

    public void run(IAction arg0) {
        if (selection instanceof IStructuredSelection) {
            IStructuredSelection treeSelection = (IStructuredSelection) selection;
            Object firstElement = treeSelection.getFirstElement();

            for (IPathResolver pathResolver : PATH_RESOLVERS) {
                if (pathResolver.supports(firstElement)) {
                    doAction(pathResolver.resolvePath(firstElement));
                }
            }
        }
    }

    protected abstract void doAction(String path);

    protected OperatingSystem getOperatingSystem() {
        return OPERATING_SYSTEM;
    }

    public void setActivePart(IAction action, IWorkbenchPart workbenchPart) {
    }

    public void selectionChanged(IAction action, ISelection selection) {
        this.selection = selection;
    }

    private ISelection selection;

    protected static final List<IPathResolver> PATH_RESOLVERS = new ArrayList<IPathResolver>();
    private static OperatingSystem OPERATING_SYSTEM;

    static {
        PATH_RESOLVERS.add(new ResourcePathResolver());
        PATH_RESOLVERS.add(new JavaElementPathResolver());
        PATH_RESOLVERS.add(new ModelElementPathResolver());

        String os = System.getProperty("os.name").toLowerCase();

        if (os.indexOf("win") >= 0)
            OPERATING_SYSTEM = OperatingSystem.WINDOWS;
        else if (os.indexOf("lin") >= 0)
            OPERATING_SYSTEM = OperatingSystem.LINUX_GNOME;
        else if (os.indexOf("mac") >= 0)
            OPERATING_SYSTEM = OperatingSystem.MACOSX;
    }

}
