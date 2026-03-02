package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.StudentRequest;
import org.example.entity.Course;
import org.example.entity.Student;
import org.example.entity.StudentProfile;
import org.example.repository.CourseRepository;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public Student createStudent(StudentRequest request) {
        Student student = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        if (request.getProfile() != null) {
            StudentProfile profile = StudentProfile.builder()
                    .address(request.getProfile().getAddress())
                    .phone(request.getProfile().getPhone())
                    .birthDate(request.getProfile().getBirthDate())
                    .build();
            student.setProfile(profile);
        }

        return studentRepository.save(student);
    }

    @Transactional
    public Student assignStudentToCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        student.addCourse(course);
        return studentRepository.save(student);
    }

    @Transactional(readOnly = true)
    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
