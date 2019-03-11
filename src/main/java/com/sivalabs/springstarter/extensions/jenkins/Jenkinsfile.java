package com.sivalabs.springstarter.extensions.jenkins;


import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.io.text.MustacheSection;

import java.util.Map;

public class Jenkinsfile extends MustacheSection {

    public Jenkinsfile(MustacheTemplateRenderer templateRenderer, String templateName,
                       Map<String, Object> model) {
        super(templateRenderer, templateName, model);
    }

}
