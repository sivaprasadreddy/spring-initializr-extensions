package com.sivalabs.springstarter.extensions.common;

import io.spring.initializr.generator.buildsystem.gradle.GradleBuildSystem;
import io.spring.initializr.generator.project.ResolvedProjectDescription;

import java.util.HashMap;
import java.util.Map;

public class ProjectDescriptionUtils {

    public static String getBuildSystemArtifactPath(ResolvedProjectDescription projectDescription) {
        if(projectDescription.getBuildSystem().id().equals(GradleBuildSystem.ID)) {
            return "build/libs";
        } else {
            return "target";
        }
    }

    public static Map<String, Object> getProjectCommonProperties(ResolvedProjectDescription projectDescription) {
        Map<String, Object> model = new HashMap<>();
        model.put("artifactId", projectDescription.getArtifactId());
        model.put("version", projectDescription.getVersion());
        model.put("artifactPath", ProjectDescriptionUtils.getBuildSystemArtifactPath(projectDescription));
        return model;
    }
}
