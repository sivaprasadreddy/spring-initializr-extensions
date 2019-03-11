package com.sivalabs.springstarter.extensions.jenkins;

import com.sivalabs.springstarter.extensions.common.ProjectDescriptionUtils;
import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.project.ResolvedProjectDescription;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@ProjectGenerationConfiguration
public class JenkinsProjectGenerationConfiguration {

    @Bean
    public Jenkinsfile jenkinsfile(MustacheTemplateRenderer templateRenderer,
                                   ResolvedProjectDescription projectDescription) {
        Map<String, Object> model = ProjectDescriptionUtils.getProjectCommonProperties(projectDescription);
        return new Jenkinsfile(templateRenderer, "jenkins/Jenkinsfile", model);
    }

    @Bean
    public JenkinsfileProjectContributor jenkinsfileProjectContributor(Jenkinsfile jenkinsfile) {
        return new JenkinsfileProjectContributor(jenkinsfile);
    }
}
