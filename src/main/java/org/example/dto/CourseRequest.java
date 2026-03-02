package org.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class CourseRequest {
    private String title;
    private Integer credits;
    private List<LessonData> lessons;

    @Data
    public static class LessonData {
        private String topic;
        private Integer duration;
    }
}
