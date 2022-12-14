package com.example.testfinal.Services;

import com.example.testfinal.Entity.Project;
import com.example.testfinal.Entity.Role;
import com.example.testfinal.Entity.Sprint;
import com.example.testfinal.Entity.User;
import com.example.testfinal.Repos.ProjectRepo;
import com.example.testfinal.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class IProjectServiceIMPL implements IProjectService{

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    public Project addProject(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public void AssignProjectToUser(int proectID, int userID) {
        User user = userRepo.findById(userID).orElse(null);
        Project project = projectRepo.findById(proectID).orElse(null);
        user.getProjectList().add(project);
        userRepo.save(user);
    }

    @Override
    public void AssignProjectToClient(int ProjectID, String firstName, String lastName) {
        User user = userRepo.findByFNameAndLName(firstName, lastName);
        Project project = projectRepo.findById(ProjectID).orElse(null);
        if (user.getRole() == Role.CLIENT) {
            user.getProjects().add(project);
        }
        userRepo.save(user);
    }

    @Override
    public List<Project> getAllCurrentProjects() {
        List<Project> projects = projectRepo.findAll();
        List<Project> projectsfinal = Collections.<Project>emptyList();
        for (Project project: projects) {
            for (Sprint sprint: project.getSprints()) {
                if (sprint.getStartDate().compareTo(new Date()) > 0) {
                    projectsfinal.add(project);
                }
            }
        }
        return projectsfinal;
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        List<Project> projects = projectRepo.findAll();
        List<Project> projectsfinal = Collections.<Project>emptyList();
        for (Project project: projects) {
            for (User user: project.getUsers()) {
                if (user.getRole() == Role.SCRUM_MASTER) {
                    if (user.getFName() == fName && user.getLName() == lName) {
                        projectsfinal.add(project);
                    }
                }
            }
        }
        return projectsfinal;
    }
}
