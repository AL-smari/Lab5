package com.example.lab5q1.Controller;
import com.example.lab5q1.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    ArrayList<Student>students=new ArrayList<>();

    @PostMapping("addStudent")
    public String addStudent(@RequestBody Student student){
        students.add(student);

        return "student added";

    }

    @PutMapping("/updateStudent/{index}")
    public String updateStudent(@PathVariable int index,@RequestBody Student student){

        students.set(index,student);

        return "student updated";

    }

    @DeleteMapping("/deleteStudent/{index}")
    public String deleteStudent(@PathVariable int index){
        students.remove(index);
        return "student deleted";
    }
    @GetMapping("/students")
    public ArrayList<Student> getStudents(){

        return students;
    }

    @GetMapping("/name/{index}")
    public String getName(@PathVariable int index){

        return students.get(index).getName();

    }

    @GetMapping("/age/{index}")
    public int getAge(@PathVariable int index){

        return students.get(index).getAge();

    }

    @GetMapping("/college/degree/{index}")
    public String getDegree(@PathVariable int index){


        return students.get(index).getDegree();

    }
    @GetMapping("/study/status/{index}")
    public String getStatus(@PathVariable int index){

        if (students.get(index).isStatus()){
            return "graduated";
        }else return "unGraduated";




    }

}
