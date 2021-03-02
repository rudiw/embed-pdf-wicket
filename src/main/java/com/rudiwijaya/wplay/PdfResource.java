package com.rudiwijaya.wplay;

import org.apache.wicket.Resource;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.util.resource.IResourceStream;

public class PdfResource extends ResourceReference {
	
	private static final long serialVersionUID = 1L;
	
	private final IResourceStream irs;

	public PdfResource(String name, final IResourceStream irs) {
		super(name);
		this.irs =  irs;
	}

	@Override
	protected Resource newResource() {
		final Resource res = new Resource() {
			
			@Override
			public IResourceStream getResourceStream() {
				return irs;
			}
		};
	    return res;
	}

}
