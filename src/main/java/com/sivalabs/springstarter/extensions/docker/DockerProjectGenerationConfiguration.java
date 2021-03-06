package com.sivalabs.springstarter.extensions.docker;

import com.sivalabs.springstarter.extensions.common.ProjectDescriptionUtils;
import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.project.ResolvedProjectDescription;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@ProjectGenerationConfiguration
public class DockerProjectGenerationConfiguration {

    @Bean
    public Dockerfile dockerfile(MustacheTemplateRenderer templateRenderer,
                                 ResolvedProjectDescription projectDescription) {
        Map<String, Object> model = ProjectDescriptionUtils.getProjectCommonProperties(projectDescription);
        return new Dockerfile(templateRenderer, "docker/Dockerfile", model);
    }

    @Bean
    public DockerfileProjectContributor dockerfileProjectContributor(Dockerfile dockerfile) {
        return new DockerfileProjectContributor(dockerfile);
    }
}
