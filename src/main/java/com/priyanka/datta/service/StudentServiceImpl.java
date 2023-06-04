package com.priyanka.datta.service;

import com.priyanka.datta.entity.Student;
import com.priyanka.datta.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;

    }

    @Override
    public List<Student> findStudentsByTotalMarksSorted() {
        List<Student> studentList = studentRepository.findAll()
                                                    .stream()
                                                    .sorted(Comparator.comparing(Student::getTotalMarks).reversed())
                                                    .collect(Collectors.toList());
        return studentList;
    }

    @Override
    public List<Student> findHighestMarksStudentsOfAllBranches() {
        Map<String,Student> map = studentRepository.findAll()
                                                    .stream()
                                                    .sorted(Comparator.comparing(Student::getTotalMarks).reversed())
                                                    .collect(Collectors.toMap(Student::getBranch,
                                                                                Function.identity(),
                                                                                (max,min) -> max));
        List<Student> studentList = map.values().stream().collect(Collectors.toList());
        return studentList;
    }

    @Override
    public Student findHighestMarksStudent() {
        //Optional<Student> optionalStudent = studentRepository.findAll().stream().max(Comparator.comparing(Student::getTotalMarks));

        Student map2 = studentRepository.findAll().stream()
                        .sorted(Comparator.comparing(Student::getTotalMarks).reversed())
                        .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getTotalMarks)
                        ),(Optional<Student> optStudent)->optStudent.isPresent()?optStudent.get():null));

        return map2;
    }

    @Override
    public Map<String, Long> countStudentsForEachBranch() {
        Map<String,Long> count = studentRepository.findAll()
                                    .stream()
                                    .collect(Collectors.groupingBy(Student::getBranch,Collectors.counting()));
        return count;
    }

    @Override
    public Map<String, List<Student>> findAllStudentsGroupByBranch() {
        Map<String, List<Student>> students = studentRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getTotalMarks).reversed())
                .collect(Collectors.groupingBy(Student::getBranch,Collectors.mapping(Function.identity(),Collectors.toList())));
        return students;
    }

    @Override
    public Student findStudentById(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student student;
        if(!optionalStudent.isPresent())
            student = null;
        else
            student = optionalStudent.get();
        return student;
    }
}
