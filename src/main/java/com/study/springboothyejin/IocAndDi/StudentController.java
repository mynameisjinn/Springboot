package com.study.springboothyejin.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private Test1 t1;

    @Autowired
    private Test2 t2;

    @ResponseBody
    @GetMapping("/student")
    public String printStudent(){
        Student student = Student.builder()
                .studentId(201)
                .studentName("김혜진")
                .build();

        studentService.printStudentInfo(student);

        t1.print();
        t2.print();

        return null;
    }

}

