package com.college.coursedetails.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.coursedetails.entity.Course;
import com.college.coursedetails.exception.CourseNotFoundException;
import com.college.coursedetails.repository.CourseRepository;

@Service
public class CourseService {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseService.class);
	
	@Autowired
	CourseRepository repository;
	
	public Course createCourse(Course course) {
		
		return repository.save(course);		
	}
	
	public List<Course> getAllCourses(){
		
		return (List<Course>) repository.findAll();		
	}
	
	public Course getCourseById(int id) {
		
		return repository.findById(id).orElse(new Course());
	}
	
	public void deleteCourseById(int id) {
		Course course = getCourseById(id);
		if(course.getId()==0)
			throw new CourseNotFoundException("id-"+id);
		repository.deleteById(id);
		
	}
	
	public Course updateCourse(Course course) {
		return repository.save(course);
		
	}

}
