package com.sivalabs.springstarter.extensions.docker;

import io.spring.initializr.generator.condition.ConditionalOnRequestedDependency;
import io.spring.initializr.generator.io.template.MustacheTemplateRenderer;
import io.spring.initializr.generator.project.ProjectGenerationConfiguration;
import io.spring.initializr.generator.project.ResolvedProjectDescription;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@ProjectGenerationConfiguration
public class DockerProjectGenerationConfiguration {

	@Bean
	public Dockerfile dockerfile(MustacheTemplateRenderer templateRenderer,
			ResolvedProjectDescription projectDescription) {
		Map<String, Object> model = new HashMap<>();
		model.put("artifactId", projectDescription.getArtifactId());
		model.put("version", projectDescription.getVersion());
		return new Dockerfile(templateRenderer, "docker/Dockerfile", model);
	}

	@Bean
	@ConditionalOnRequestedDependency("web")
	public DockerfileProjectContributor dockerfileProjectContributor(
			Dockerfile dockerfile) {
		return new DockerfileProjectContributor(dockerfile);
	}

}
