package com.redwrenchdigital.eclipse.osintegration.pathresolver;


/**
 *
 * @author Sanjay Ginde
 *
 */
public class ModelElementPathResolver extends ClassNamePathResolver {

	public ModelElementPathResolver() {
		super("org.eclipse.dltk.core.IModelElement");
	}

	public String resolvePath(Object element) {
		/*
		IModelElement modelElement = (IModelElement) element;
		IResource resource = modelElement.getResource();
		if (resource != null) {
			return handleResource(resource);
		} else {
			return modelElement.getPath().toOSString();
		}
		*/
		return null;
	}

}
