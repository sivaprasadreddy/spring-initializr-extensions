package com.sivalabs.springstarter.extensions.docker;

import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.io.text.MustacheSection;

import java.util.Map;

public class Dockerfile extends MustacheSection {

	private final MustacheTemplateRenderer templateRenderer;

	public Dockerfile(MustacheTemplateRenderer templateRenderer, String templateName,
			Map<String, Object> model) {
		super(templateRenderer, templateName, model);
		this.templateRenderer = templateRenderer;
	}

}
