package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CourseRequest;
import org.example.entity.Course;
import org.example.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseRequest request) {
        return ResponseEntity.ok(courseService.createCourse(request));
    }

    @PostMapping("/{courseId}/lessons")
    public ResponseEntity<Course> addLessons(
            @PathVariable Long courseId,
            @RequestBody List<CourseRequest.LessonData> lessons) {
        return ResponseEntity.ok(courseService.addLessons(courseId, lessons));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourse(id));
    }
}
