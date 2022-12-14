package com.example.testfinal.Services;

import com.example.testfinal.Entity.Project;

import java.util.List;

public interface IProjectService {
    public Project addProject(Project project);
    public void AssignProjectToUser(int proectID, int userID);
    public void AssignProjectToClient(int ProjectID, String firstName, String lastName);
    public List<Project> getAllCurrentProjects();
    public List<Project> getProjectsByScrumMaster(String fName, String lName);
}
