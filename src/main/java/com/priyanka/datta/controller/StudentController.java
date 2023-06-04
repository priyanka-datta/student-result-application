package com.priyanka.datta.controller;

import com.priyanka.datta.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<Object> getAllStudents(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/students/sorted")
    public ResponseEntity<Object> getAllStudentsInSortedOrder(){
        return new ResponseEntity<>(studentService.findStudentsByTotalMarksSorted(), HttpStatus.OK);
    }

    @GetMapping("/students/highestMarksAllBranch")
    public ResponseEntity<Object> getAllBranchHighestMarksStudents(){
        return new ResponseEntity<>(studentService.findHighestMarksStudentsOfAllBranches(), HttpStatus.OK);
    }

    @GetMapping("/students/count")
    public ResponseEntity<Object> getCountForAllBranchStudents(){
        return new ResponseEntity<>(studentService.countStudentsForEachBranch(), HttpStatus.OK);
    }

    @GetMapping("/students/highestMarksStudent")
    public ResponseEntity<Object> getHighestMarksStudent(){
        return new ResponseEntity<>(studentService.findHighestMarksStudent(), HttpStatus.OK);
    }

    @GetMapping("/students/studentsByBranch")
    public ResponseEntity<Object> findStudentsGroupByBranch(){
        return new ResponseEntity<>(studentService.findAllStudentsGroupByBranch(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable Integer id){
        return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.OK);
    }
}
