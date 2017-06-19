package com.redwrenchdigital.eclipse.osintegration.pathresolver;

/**
 *
 * @author Sanjay Ginde
 *
 */
public interface IPathResolver {
    public boolean supports(Object element);

    public String resolvePath(Object element);
}
