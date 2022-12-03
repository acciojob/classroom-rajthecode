package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){

        studentRepository.saveStudent(student);
    }

    public void addTeacher(Teacher teacher){

        studentRepository.saveTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        studentRepository.createStudentTeacherPair(student, teacher);
    }

    public Student getStudentByName(String studentName){

        return studentRepository.getStudent(studentName);
    }

    public Teacher getTeacherByName(String teacherName){

        return studentRepository.getTeacher(teacherName);
    }

    public List<String> getStudentsByTeacherName(String teacher){
        return studentRepository.getStudentsFromTeacher(teacher);
    }

    public List<String> getAllStudents(){

        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeacher();
    }
}
