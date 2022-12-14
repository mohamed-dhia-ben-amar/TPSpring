package com.example.testfinal.Services;

import com.example.testfinal.Entity.Project;
import com.example.testfinal.Entity.Sprint;

import java.util.List;

public interface ISprintService {
    public void addSprintAndAssignToProject(Sprint sprint, int idProject);
    public List<Project> getNbrSprintByCurrentProject();
}
