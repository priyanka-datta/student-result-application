package com.priyanka.datta.service;

import com.priyanka.datta.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    public List<Student> findAll();

    public List<Student> findStudentsByTotalMarksSorted();

    public List<Student> findHighestMarksStudentsOfAllBranches();

    public Student findHighestMarksStudent();

    public Map<String,Long> countStudentsForEachBranch();

    public Map<String,List<Student>> findAllStudentsGroupByBranch();

    public Student findStudentById(Integer id);

}
