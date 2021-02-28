package com.college.coursedetails.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.coursedetails.entity.Course;
import com.college.coursedetails.exception.CourseNotFoundException;
import com.college.coursedetails.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@GetMapping(path="/courses")
	public List<Course> getCourse(){		
		return (List<Course>) courseService.getAllCourses();
	}
	
	@GetMapping(path="/courses/{id}")
	public Course getCourseById(@PathVariable int id) {
		Course course = courseService.getCourseById(id);
		if(course.getId()==0)
			throw new CourseNotFoundException("id-"+id);
			
		return course;
	}
	
	@PostMapping(path="/courses")
	public Course addCourse(@Valid @RequestBody Course course) {
		return courseService.createCourse(course);
	}
	
	@DeleteMapping(path="/courses/{id}")
	public void deleteCourse(@PathVariable int id) {
		courseService.deleteCourseById(id);
	}
	
	@PutMapping(path="/courses/{id}")
	public Course updateOrSaveCourse(@RequestBody Course course) {
		//Course c = courseService.findById(id).orElse(course);
		courseService.updateCourse(course);
		return course;
	}
	
}
