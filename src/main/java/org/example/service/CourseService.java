package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CourseRequest;
import org.example.entity.Course;
import org.example.entity.Lesson;
import org.example.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional
    public Course createCourse(CourseRequest request) {
        Course course = Course.builder()
                .title(request.getTitle())
                .credits(request.getCredits())
                .build();

        if (request.getLessons() != null) {
            request.getLessons().forEach(lessonData -> {
                Lesson lesson = Lesson.builder()
                        .topic(lessonData.getTopic())
                        .duration(lessonData.getDuration())
                        .build();
                course.addLesson(lesson);
            });
        }

        return courseRepository.save(course);
    }

    @Transactional
    public Course addLessons(Long courseId, List<CourseRequest.LessonData> lessonsData) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        lessonsData.forEach(lessonData -> {
            Lesson lesson = Lesson.builder()
                    .topic(lessonData.getTopic())
                    .duration(lessonData.getDuration())
                    .build();
            course.addLesson(lesson);
        });

        return courseRepository.save(course);
    }

    @Transactional(readOnly = true)
    public Course getCourse(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }
}
