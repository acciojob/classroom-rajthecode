package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
    public class StudentRepository {

        private HashMap<String, Student> studentMap;
        private HashMap<String, Teacher> teacherMap;
        private HashMap<String, List<String>> teacherStudentMapping;

        public StudentRepository(){
            this.studentMap = new HashMap<String, Student>();
            this.teacherMap = new HashMap<String, Teacher>();
            this.teacherStudentMapping = new HashMap<String, List<String>>();
        }

        public void saveStudent(Student student){
            studentMap.put(student.getName(), student);
        }

        public void saveTeacher(Teacher teacher){
            teacherMap.put(teacher.getName(), teacher);
        }

        public void createStudentTeacherPair(String student, String teacher){
            if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
                studentMap.put(student, studentMap.get(student));
                teacherMap.put(teacher, teacherMap.get(teacher));
                List<String> currentStudents = new ArrayList<String>();
                if(teacherStudentMapping.containsKey(teacher)) currentStudents = teacherStudentMapping.get(teacher);
                currentStudents.add(student);
                teacherStudentMapping.put(teacher, currentStudents);
            }
        }

        public Student getStudent(String student){
            return studentMap.get(student);
        }

        public Teacher getTeacher(String teacher){
            return teacherMap.get(teacher);
        }

        public List<String> getStudentsFromTeacher(String teacher){
            List<String> studentsList = new ArrayList<String>();
            if(teacherStudentMapping.containsKey(teacher)) studentsList = teacherStudentMapping.get(teacher);
            return studentsList;
        }

        public List<String> getAllStudents(){
            return new ArrayList<>(studentMap.keySet());
        }

        public void deleteTeacher(String teacher){
            List<String> students = new ArrayList<String>();
            if(teacherStudentMapping.containsKey(teacher)){
                students = teacherStudentMapping.get(teacher);
                for(String student: students){
                    if(studentMap.containsKey(student)){
                        studentMap.remove(student);
                    }
                }

                teacherStudentMapping.remove(teacher);
            }

            if(teacherMap.containsKey(teacher)){
                teacherMap.remove(teacher);
            }
        }

        public void deleteAllTeacher(){
            HashSet<String> studentsSet = new HashSet<String>();



            for(String teacher: teacherStudentMapping.keySet()){
                for(String student: teacherStudentMapping.get(teacher)){
                    studentsSet.add(student);
                }
                if(teacherMap.containsKey(teacher)){
                    teacherMap.remove(teacher);
                }
                teacherStudentMapping.remove(teacher);
            }

            for(String student: studentsSet){
                if(studentMap.containsKey(student)){
                    studentMap.remove(student);
                }
            }

        }
    }

