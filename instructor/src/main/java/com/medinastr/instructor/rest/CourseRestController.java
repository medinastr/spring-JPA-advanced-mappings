package com.medinastr.instructor.rest;

import com.medinastr.instructor.dto.CourseDTO;
import com.medinastr.instructor.entity.Course;
import com.medinastr.instructor.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseRestController {

    CourseService courseService;

    @Autowired
    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> save(@RequestBody CourseDTO courseDTO) {
        Course course = courseService.save(courseDTO);
        return ResponseEntity.status(201).body(course);
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getCoursesList() {
        List<CourseDTO> courses = courseService.getCoursesList();
        return ResponseEntity.status(200).body(courses);
    }
}
