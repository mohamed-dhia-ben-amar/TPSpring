package com.example.testfinal.Services;

import com.example.testfinal.Entity.Project;
import com.example.testfinal.Entity.Sprint;
import com.example.testfinal.Repos.ProjectRepo;
import com.example.testfinal.Repos.SprintRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ISprintServiceIMPL implements ISprintService{

    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    SprintRepo sprintRepo;

    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = projectRepo.findById(idProject).orElse(null);
        project.getSprints().add(sprint);
        projectRepo.save(project);
    }

    @Override
    @Scheduled(fixedRate = 30000)
    public List<Project> getNbrSprintByCurrentProject() {
        log.info("");
        return null;
    }
}
