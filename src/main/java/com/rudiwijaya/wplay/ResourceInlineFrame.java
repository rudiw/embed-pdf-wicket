package com.rudiwijaya.wplay;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.util.string.Strings;

public class ResourceInlineFrame extends WebMarkupContainer {
	private static final long serialVersionUID = 1L;

	private ResourceReference reference;

	private HashMap<String, String> params;

	public ResourceInlineFrame(final String id,
			ResourceReference reference) {
		this(id, reference, null);
	}

	public ResourceInlineFrame(final String id,
			ResourceReference reference, HashMap<String, String> params) {
        super(id);
        if(reference == null) {
            throw new IllegalArgumentException("Invalid Resource Reference");
        }
        this.reference = reference;
        this.params = params;
    }

	protected CharSequence getURL() {
		final StringBuffer url = new StringBuffer();
		url.append(urlFor(reference));
		if (params != null && !params.isEmpty()) {
			url.append("?");
			final Iterator<String> it = params.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				url.append(key);
				url.append("=");
				url.append(params.get(key));
				if (it.hasNext())
					url.append("&");
			}
		}
		return url;
	}

	@Override
	protected final void onComponentTag(final ComponentTag tag) {
		checkComponentTag(tag, "iframe");

		// Set href to link to this frame's frameRequested method
		CharSequence url = getURL();

		// generate the src attribute
		tag.put("src", Strings.replaceAll(url, "&", "&amp;"));

		super.onComponentTag(tag);
	}

	public HashMap<String, String> getParams() {
		return params;
	}

	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}
}
