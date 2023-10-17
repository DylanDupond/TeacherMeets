package com.ISTIC.TeacherMeet.Repository;

import com.ISTIC.TeacherMeet.Model.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherMeetRepository extends JpaRepository<Timeslot,Long> {
}
