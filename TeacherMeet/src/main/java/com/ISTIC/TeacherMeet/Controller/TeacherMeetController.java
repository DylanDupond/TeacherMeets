package com.ISTIC.TeacherMeet.Controller;

import com.ISTIC.TeacherMeet.Model.Student;
import com.ISTIC.TeacherMeet.Model.Teacher;
import com.ISTIC.TeacherMeet.Model.Timeslot;
import com.ISTIC.TeacherMeet.Model.WrapperJsonDTO;
import com.ISTIC.TeacherMeet.Services.TeacherMeetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/teacherMeet")
public class TeacherMeetController {

    private final TeacherMeetService teacherMeetService;

    public TeacherMeetController(TeacherMeetService teacherMeetService) {
        this.teacherMeetService = teacherMeetService;
    }

    @GetMapping("/meet/all")
    public ResponseEntity<List<Timeslot>> getAllMeets(){
        List<Timeslot> meets = this.teacherMeetService.findAllMeet();
        return new ResponseEntity<>(meets, HttpStatus.OK);
    }

    @GetMapping("/teacher/all")
    public ResponseEntity<List<Teacher>> getAllTeachers(){
        List<Teacher> teachers = this.teacherMeetService.findAllTeacher();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/student/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = this.teacherMeetService.findAllStudent();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/meet/add")
    public ResponseEntity<Timeslot> bookAMeet(@RequestBody WrapperJsonDTO json){
        Long teacher = json.getTeacher();
        Long student = json.getStudent();
        Timeslot timeslot = json.getTimeslot();

        Timeslot booked = this.teacherMeetService.bookAMeet(teacher,student,timeslot);
        return new ResponseEntity<>(booked, HttpStatus.CREATED);
    }

    @PostMapping("/teacher/add")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
        if(this.teacherMeetService.addTeacher(teacher)){
            return new ResponseEntity<>(teacher, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/student/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        if(this.teacherMeetService.addStudent(student)){
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/meet/delete/{id}")
    public ResponseEntity<?> cancelAMeet(@PathVariable("id") Long id){
        this.teacherMeetService.cancelAMeet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/teacher/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("id") Long id){
        this.teacherMeetService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id){
        this.teacherMeetService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
