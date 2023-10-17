package com.ISTIC.TeacherMeet.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class WrapperJsonDTO {

    @Setter
    @JsonProperty("teacher")
    private Long teacher;

    @Setter
    @JsonProperty("student")
    private Long student;

    @Setter
    @JsonProperty("timeslot")
    private Timeslot timeslot;
}
