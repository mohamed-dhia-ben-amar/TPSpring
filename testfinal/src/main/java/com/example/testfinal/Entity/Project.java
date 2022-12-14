package com.example.testfinal.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "project",cascade = CascadeType.PERSIST)
    private List<Sprint> sprints;

    @ManyToMany(mappedBy = "projects",cascade = CascadeType.PERSIST)
    private List<User> users;
}
