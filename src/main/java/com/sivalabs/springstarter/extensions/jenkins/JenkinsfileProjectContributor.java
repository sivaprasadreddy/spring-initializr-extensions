package com.sivalabs.springstarter.extensions.jenkins;

import io.spring.initializr.generator.project.contributor.ProjectContributor;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * A {@link ProjectContributor} that creates "Jenkinsfile".
 *
 * @author Siva
 */
public class JenkinsfileProjectContributor implements ProjectContributor {

	private final Jenkinsfile jenkinsfile;

	public JenkinsfileProjectContributor(Jenkinsfile jenkinsfile) {
		this.jenkinsfile = jenkinsfile;
	}

	@Override
	public void contribute(Path projectRoot) throws IOException {
		Path output = projectRoot.resolve("Jenkinsfile");
		if (!output.toFile().exists()) {
			Files.createDirectories(output.getParent());
			Files.createFile(output);
		}

		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(output))) {
			this.jenkinsfile.write(writer);
		}
	}

}
