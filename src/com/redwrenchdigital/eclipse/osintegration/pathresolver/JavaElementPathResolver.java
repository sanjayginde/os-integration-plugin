package com.redwrenchdigital.eclipse.osintegration.pathresolver;

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.IJavaElement;

/**
 *
 * @author Sanjay Ginde
 *
 */
public class JavaElementPathResolver extends ClassNamePathResolver {

    public JavaElementPathResolver() {
        super("org.eclipse.jdt.core.IJavaElement");
    }

    public String resolvePath(Object element) {
        IJavaElement javaElement = (IJavaElement) element;
        IResource resource = javaElement.getResource();
        if (resource != null) {
            return handleResource(resource);
        } else {
            return javaElement.getPath().toOSString();
        }
    }

}
