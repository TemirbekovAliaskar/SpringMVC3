package spring.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.ebtity.Company;
import spring.ebtity.Course;
import spring.repo.CourseRepository;

import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class CourseRepo  implements CourseRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public String saveCourseByCompanyId(Long companyId, Course course) {
        Company company = entityManager.find(Company.class, companyId);
        course.setCompany(company);
        company.getCourses().add(course);
        entityManager.persist(course);
        return null;
    }

    @Override
    public Course findCourseById(Long id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    public String updateCourseById(Long id, Course newCourse) {
        Course course = entityManager.find(Course.class, id);
        course.setCourseName(newCourse.getCourseName());
        course.setDescription(newCourse.getDescription());
        course.setPrice(newCourse.getPrice());
        course.setImageLink(newCourse.getImageLink());
        return null;
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("select c from Course c", Course.class).getResultList();
    }


    @Override
    public void deleteByOD(Long id) {
        entityManager.remove(entityManager.find(Course.class, id));
    }
}
