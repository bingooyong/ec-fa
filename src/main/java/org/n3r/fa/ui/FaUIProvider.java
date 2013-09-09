package org.n3r.fa.ui;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;

public class FaUIProvider extends UIProvider {

	private static final long serialVersionUID = -5900447014543694450L;

	@Override
	public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
		if (event.getRequest().getParameter("mobile") != null
				&& event.getRequest().getParameter("mobile").equals("false")) {
			return FaUI.class;
		}

		if (event.getRequest().getHeader("user-agent").toLowerCase()
				.contains("mobile")
				&& !event.getRequest().getHeader("user-agent").toLowerCase()
						.contains("ipad")) {
			return MobileCheckUI.class;
		}

		return FaUI.class;
	}

}
