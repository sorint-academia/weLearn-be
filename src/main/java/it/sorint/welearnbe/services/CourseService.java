package it.sorint.welearnbe.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sorint.welearnbe.repository.CourseRepository;
import it.sorint.welearnbe.repository.entity.CourseBE;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private SessionService sessionService;
	
	public List<CourseBE> getCourses(String name) {
		//Get the viewable sessions and then map to course
		return sessionService.getSessionsByStudentOrTeacherName(name).stream()
				.map(s -> courseRepository.findOne(s.getCourseID()))
				.collect(Collectors.toList());
	}
}
