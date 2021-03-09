package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping("selectOne")
    public Student selectOne(Integer id) {
        LOGGER.info("===============logging=====================");
        return studentService.queryById(id);
    }

    @GetMapping("selectAllByLimit")
    public List<Student> selectAllByLimit(Integer offset, Integer limit) {
        return studentService.queryAllByLimit(offset, limit);
    }

    @GetMapping("insert")
    public Student insert(Student student) {
        return studentService.insert(student);
    }

    @PostMapping("update")
    public Student update(Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("delete")
    public boolean delete(Integer id) {
        return studentService.deleteById(id);
    }

}
