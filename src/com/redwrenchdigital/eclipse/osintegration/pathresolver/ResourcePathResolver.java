package com.redwrenchdigital.eclipse.osintegration.pathresolver;

import org.eclipse.core.resources.IResource;

/**
 *
 * @author Sanjay Ginde
 *
 */
public class ResourcePathResolver extends ClassNamePathResolver {

    public ResourcePathResolver() {
        super("org.eclipse.core.resources.IResource");
    }

    public String resolvePath(Object element) {
        return handleResource((IResource) element);
    }
}
