package com.redwrenchdigital.eclipse.osintegration.pathresolver;

import java.io.File;
import java.net.URI;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.redwrenchdigital.eclipse.osintegration.Activator;

/**
 *
 * @author Sanjay Ginde
 *
 */
public abstract class ClassNamePathResolver implements IPathResolver {

    private Class<?> supportedClass;

    protected ClassNamePathResolver(String supportedClassName) {
        try {
            supportedClass = Class.forName(supportedClassName);
        } catch (ClassNotFoundException e) {
            IStatus message = new Status(Status.INFO, Activator.PLUGIN_ID, "Cannot resolve path for class '" + supportedClassName + "' because it cannot be found. Ignoring..");
            Activator.getDefault().getLog().log(message);
        }
    }

    public boolean supports(Object element) {
        if (supportedClass != null) {
            return supportedClass.isAssignableFrom(element.getClass());
        }

        return false;
    }

    protected String handleResource(IResource resource) {
        URI locationURI = resource.getLocationURI();
        File file = new File(locationURI);

        return file.getAbsolutePath();
    }
}
