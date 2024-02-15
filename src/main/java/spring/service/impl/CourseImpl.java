package spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.ebtity.Company;
import spring.ebtity.Course;
import spring.repo.CourseRepository;
import spring.service.CourseService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Override
    public String saveCourseByCompanyId(Long companyId, Course course) {
        return courseRepository.saveCourseByCompanyId(companyId, course);
    }

    @Override
    public Course findCourseById(Long id) {
        return courseRepository.findCourseById(id);
    }

    @Override
    public String updateCourseById(Long id, Course newCourse) {
        return courseRepository.updateCourseById(id, newCourse);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteByOD(Long id) {
        courseRepository.deleteByOD(id);
    }
}
