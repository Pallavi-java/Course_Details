package com.college.coursedetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.college.coursedetails.entity.Course;

//@RepositoryRestResource(collectionResourceRel="courses",path="courses")
public interface CourseRepo extends JpaRepository<Course, Integer>{

}
