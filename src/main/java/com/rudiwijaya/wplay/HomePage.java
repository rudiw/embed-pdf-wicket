package com.rudiwijaya.wplay;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * Homepage
 */
public class HomePage extends WebPage {

	private static final long serialVersionUID = 1L;

	// TODO Add any page properties or variables here

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {

        // Add the simplest type of label
        add(new Label("message", "If you see this message wicket is properly configured and running"));
        
        final ResourceReference pdfRes = new ResourceReference(HomePage.class, "Keyboard shortcuts  - Android Developers.pdf");
        
        final WebMarkupContainer myPdf = new ResourceInlineFrame("myPdf", pdfRes);
        add(myPdf);

        // TODO Add your page's components here
    }
}
