package com.sivalabs.springstarter.extensions.heroku;

import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.io.text.MustacheSection;

import java.util.Map;

public class Procfile extends MustacheSection {

    public Procfile(MustacheTemplateRenderer templateRenderer, String templateName,
                      Map<String, Object> model) {
        super(templateRenderer, templateName, model);
    }

}
