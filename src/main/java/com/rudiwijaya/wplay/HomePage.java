package com.rudiwijaya.wplay;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.WebResource;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.resource.ByteArrayResource;
import org.apache.wicket.resource.DynamicByteArrayResource;
import org.apache.wicket.resource.DynamicByteArrayResource.ResourceState;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.UrlResourceStream;

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
        
        // v1
//        final ResourceReference pdfRes = new ResourceReference(HomePage.class, "Keyboard shortcuts  - Android Developers.pdf");
        
        // v2
        final byte[] array = "tmp".getBytes();
        final ByteArrayResource bar = new ByteArrayResource("application/pdf", array);
        final PdfResource pdfRes = new PdfResource("Keyboard shortcuts  - Android Developers.pdf", bar.getResourceStream());
        
        final WebMarkupContainer myPdf = new ResourceInlineFrame("myPdf", pdfRes);
        add(myPdf);

        // TODO Add your page's components here
    }
}
