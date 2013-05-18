package org.wickedsource;

import org.apache.wicket.request.resource.PackageResourceReference;

/**
 * Reference to the Wicket guide PDF.
 * 
 * @author tom
 * 
 */
public class WicketGuideResourceReference extends PackageResourceReference {

	public WicketGuideResourceReference() {
		super(WicketGuideResourceReference.class, "WicketFreeGuide.pdf");
	}

}
