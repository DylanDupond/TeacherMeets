package com.ISTIC.TeacherMeet.Model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(updatable = false,nullable = false)
        private long id;

        @Column(updatable = false,nullable = false)
        @Setter
        private String name;

        @Setter
        private String email;

        @Setter
       @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
        private List<Timeslot> MeetsTaken;

        @Setter
        private String phoneNumber;

        @Setter
        @Column(nullable = false)
        private String sector;

        @Setter
        @Column(nullable = false)
        private int year;

    }
