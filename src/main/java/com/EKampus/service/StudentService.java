package com.EKampus.service;

import com.EKampus.DTO.StudentDto;
import com.EKampus.model.Department;
import com.EKampus.model.Faculty;
import com.EKampus.model.Lesson;
import com.EKampus.model.Student;
import com.EKampus.repository.DepartmentRepo;
import com.EKampus.repository.FacultyRepo;
import com.EKampus.repository.LessonRepo;
import com.EKampus.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private final StudentRepo studentRepo;

    @Autowired
    private final FacultyRepo facultyRepo;

    @Autowired
    private final DepartmentRepo departmentRepo;

    @Autowired
    private final LessonRepo lessonRepo;

    public StudentService(StudentRepo studentRepo, FacultyRepo facultyRepo, DepartmentRepo departmentRepo, LessonRepo lessonRepo) {
        this.studentRepo = studentRepo;
        this.facultyRepo = facultyRepo;
        this.departmentRepo = departmentRepo;
        this.lessonRepo = lessonRepo;
    }



    public StudentDto addStudent(Student user) {
        Student savedStudent = studentRepo.save(user);
        return new StudentDto(
                savedStudent.getSemester(),
                savedStudent.getStudentNo(),
                savedStudent.getName(),
                savedStudent.getSurname(),
                savedStudent.isGender(),
                savedStudent.getEmail(),
                savedStudent.getPhoneNo()
        );
    }

    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }
    public Student facultyAddToStudentService(Long studentsId, Long facultyId) {
        Set<Faculty> setFaculty=null;
        Student student= studentRepo.findById(studentsId).get();
        Faculty faculty= facultyRepo.findById(facultyId).get();
        setFaculty=student.getFaculty();
        setFaculty.add(faculty);
        student.setFaculty(setFaculty);
        return studentRepo.save(student);
    }

    public Student facultyRemoveFromStudentService(Long studentsId, Long facultyId) {
        Set<Faculty> setFaculty=null;
        Student student= studentRepo.findById(studentsId).get();
        Faculty faculty= facultyRepo.findById(facultyId).get();
        setFaculty=student.getFaculty();
        setFaculty.remove(faculty);
        student.setFaculty(setFaculty);
        return studentRepo.save(student);
    }

    public Student departmentAddToStudentService(Long studentsId, Long departmentId) {
        Set<Department> setDepartment=null;
        Student student= studentRepo.findById(studentsId).get();
        Department department= departmentRepo.findById(departmentId).get();
        setDepartment=student.getDepartments();
        setDepartment.add(department);
        student.setDepartments(setDepartment);
        return studentRepo.save(student);
    }

    public Student departmentRemoveFromStudentService(Long studentsId, Long departmentId) {
        Set<Department> setDepartment=null;
        Student student= studentRepo.findById(studentsId).get();
        Department department= departmentRepo.findById(departmentId).get();
        setDepartment=student.getDepartments();
        setDepartment.remove(department);
        student.setDepartments(setDepartment);
        return studentRepo.save(student);
    }


    public Student lessonAddToStudentService(Long studentsId, Long lessonId) {
        Set<Lesson> setLesson=null;
        Student student= studentRepo.findById(studentsId).get();
        Lesson lesson= lessonRepo.findById(lessonId).get();
        setLesson=student.getLessons();
        setLesson.add(lesson);
        student.setLessons(setLesson);
        return studentRepo.save(student);
    }

    public Student lessonRemoveFromStudentService(Long studentsId, Long lessonId) {
        Set<Lesson> setLesson=null;
        Student student= studentRepo.findById(studentsId).get();
        Lesson lesson= lessonRepo.findById(lessonId).get();
        setLesson=student.getLessons();
        setLesson.remove(lesson);
        student.setLessons(setLesson);
        return studentRepo.save(student);
    }


}
