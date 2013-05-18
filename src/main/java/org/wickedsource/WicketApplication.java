package org.wickedsource;

import org.apache.wicket.markup.html.IPackageResourceGuard;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see org.wickedsource.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		
		// allow access to package resources
		getResourceSettings().setPackageResourceGuard(new IPackageResourceGuard() {
			@Override
			public boolean accept(Class<?> scope, String absolutePath) {
				return true;
			}
		});
		
		mountResource("/guide.pdf", new WicketGuideResourceReference());
	}

}
