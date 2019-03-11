package com.sivalabs.springstarter.extensions.heroku;

import com.sivalabs.springstarter.extensions.common.ProjectDescriptionUtils;
import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.project.ResolvedProjectDescription;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@ProjectGenerationConfiguration
public class HerokuProjectGenerationConfiguration {

    @Bean
    public Procfile procfile(MustacheTemplateRenderer templateRenderer,
                             ResolvedProjectDescription projectDescription) {
        Map<String, Object> model = ProjectDescriptionUtils.getProjectCommonProperties(projectDescription);
        return new Procfile(templateRenderer, "heroku/Procfile", model);
    }

    @Bean
    public ProcfileProjectContributor procfileProjectContributor(
            Procfile procfile) {
        return new ProcfileProjectContributor(procfile);
    }
}
