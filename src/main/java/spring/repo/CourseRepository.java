package spring.repo;

import spring.ebtity.Company;
import spring.ebtity.Course;

import java.util.List;

public interface CourseRepository {
    String saveCourseByCompanyId(Long companyId, Course course);
    Course findCourseById(Long id);
    String updateCourseById(Long id,Course newCourse);
    List<Course> findAll();
    void deleteByOD(Long id);

}
