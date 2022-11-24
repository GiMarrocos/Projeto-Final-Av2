package com.tomorrow.tomorrow.services;

import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

import com.tomorrow.tomorrow.entities.exceptions.EntityObjectNotFoundException;
import com.tomorrow.tomorrow.entities.exceptions.CourseCreateFailureException;
import com.tomorrow.tomorrow.entities.util.FormatDataInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tomorrow.tomorrow.entities.Course;
import com.tomorrow.tomorrow.repositories.CourseRepository;

@Service
public class CourseService extends FormatDataInput {
	
	@Autowired
    private CourseRepository courseRepository;

	 //create
	public Course save(Course course) {

		try {

            course.setCourseName(NAME_FORMAT(course.getCourseName()));
			course.setClassWorkload(course.getClassWorkload());
			course.setTotalWorkload(course.getTotalWorkload());
			course.setShift(NAME_FORMAT(course.getShift())); 
			course.setValue(course.getValue()); 
			course.setMonday(course.getMonday()); 
			course.setTuesday(course.getTuesday()); 
			course.setWednesday(course.getWednesday()); 
			course.setThursday(course.getThursday()); 
			course.setFriday(course.getFriday());
			course.setSaturday(course.getSaturday()); 
			

        } catch (RuntimeException violationException) {
			
            throw new CourseCreateFailureException("Course registration failure");
        }
        return courseRepository.save(course);
	} 
	
	//read (by id)
    public Course findById(Long id){
        Optional<Course> student = courseRepository.findById(id);
        return student.orElseThrow(() -> new EntityObjectNotFoundException("Course not found! Id:" + id +
                "Cause type: " + Course.class.getName()));
    }

    //red (student list)
    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    //update
    public void updateCourse(Course course) throws DataFormatException {
        Course new_course_data = courseRepository.getReferenceById(course.getCourse_id());
        new_course_data = update_DATA(new_course_data, course);
        if(course.getCourseName() == null){
            throw new DataFormatException("No change data has been entered");
        }else{
            courseRepository.save(new_course_data);
        }
    }

	//delete
	public void  deleteCourse(Long id){
		try {
			courseRepository.deleteById(id);
		} catch (EmptyResultDataAccessException dataAccessException){
			throw new EntityObjectNotFoundException("Course not found! Id: " + id + "Cause type: "
					+ Course.class.getName());
		} catch (DataIntegrityViolationException dataIntegrityViolationException){
			dataIntegrityViolationException.getMessage();
		}
	}

	//data change method
	protected Course update_DATA(Course course, Course new_data){
		//permission to change phone and address only
		if(new_data.getCourseName() != null) {

			course.setCourseName(new_data.getCourseName());

		}else if (new_data.getCourseName() != null){

			course.setCourseName(new_data.getCourseName());

		}else if (new_data.getCourseName() != null){

			course.setCourseName(new_data.getCourseName());
		}

		return course;
	}
}
