package com.example.lab5q2.Controller;

import com.example.lab5q2.ApiResponse.ApiResponse;
import com.example.lab5q2.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    ArrayList<Project>projects=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Project> getProjects(){

        return projects;
    }
    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project project){
        projects.add(project);
        return new ApiResponse("project added",200);
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@PathVariable int index,@RequestBody Project project){

        projects.set(index,project);

        return new ApiResponse("project updated",200);

    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index){
        projects.remove(index);
        return new ApiResponse("project deleted",200);
    }

    @PutMapping("/change-status/{index}")
    public ApiResponse changeStatus(@PathVariable int index){
        if(projects.get(index).getStatus().equals("done")){
            projects.get(index).setStatus("not done");
        }else projects.get(index).setStatus("done");

        return new ApiResponse("status changed",200);
    }
    @GetMapping("search-project/{title}")
    public Project searchProject(@PathVariable String title){

        for(Project p:projects){
            if(p.getTitle().equals(title)){
                return p;
            }
        }

        return null;

    }

    @GetMapping("/getProjects/{companyName}")
    public ArrayList<Project> getProjectByCompany(@PathVariable String companyName){
        ArrayList<Project> p = new ArrayList<>();

        for(Project project : projects){
            if(project.getCompanyName().equals(companyName)){
                p.add(project);
            }
        }

        return p;


    }



}
