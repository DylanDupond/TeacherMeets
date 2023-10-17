package com.ISTIC.TeacherMeet.Repository;

import com.ISTIC.TeacherMeet.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
