package com.sivalabs.springstarter.extensions.heroku;

import io.spring.initializr.generator.project.contributor.ProjectContributor;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * A {@link ProjectContributor} that creates "Procfile".
 *
 * @author Siva
 */
public class ProcfileProjectContributor implements ProjectContributor {

	private final Procfile procfile;

	public ProcfileProjectContributor(Procfile procfile) {
		this.procfile = procfile;
	}

	@Override
	public void contribute(Path projectRoot) throws IOException {
		Path output = projectRoot.resolve("Procfile");
		if (!output.toFile().exists()) {
			Files.createDirectories(output.getParent());
			Files.createFile(output);
		}

		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(output))) {
			this.procfile.write(writer);
		}
	}

}
