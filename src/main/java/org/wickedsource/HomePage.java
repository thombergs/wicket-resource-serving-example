package org.wickedsource;

import java.awt.Color;
import java.awt.Graphics2D;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.ByteArrayResource;
import org.apache.wicket.request.resource.DynamicImageResource;
import org.apache.wicket.request.resource.IResource.Attributes;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.image.resource.RenderedDynamicImageResource;
import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new ResourceLink<Void>("staticResourceLink",
				new WicketGuideResourceReference()));

		byte[] helloWorldBytes = "Hello World!".getBytes();
		add(new ResourceLink<Void>("byteArrayResourceLink",
				new ByteArrayResource("text/plain", helloWorldBytes)));

		add(new Image("dynamicImage",
				new RenderedDynamicImageResource(100, 100) {
					@Override
					protected boolean render(Graphics2D graphics,
							Attributes attributes) {
						graphics.setColor(Color.BLACK);
						graphics.fillRect(0, 0, 100, 100);
						graphics.setColor(Color.YELLOW);
						graphics.fillOval(0, 0, 100, 100);
						graphics.setColor(Color.BLACK);
						graphics.fillOval(25, 25, 10, 10);
						graphics.fillOval(50, 25, 10, 10);
						graphics.drawArc(35, 50, 25, 25, 45, 45);
						return true;
					}
				}));
	}
}
