package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.ebtity.Course;
import spring.service.CourseService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;


//    @GetMapping
//    public String getAllCompany (Model model){
//        model.addAttribute("allCourses",courseService.findAll());
//        return "/companies";
//    }

    @GetMapping("/find/{companyId}")
    public String addCourse(@PathVariable Long companyId, Model model) {
        model.addAttribute("companyId", companyId);
        model.addAttribute("newCourse", new Course());
        return "newCourse";
    }
    @PostMapping("/save/{companyId}")
    public String saveCourse(@ModelAttribute("newCourse") Course course,
                             @PathVariable("companyId") Long companyId) {
        courseService.saveCourseByCompanyId(companyId,course);
        return "redirect:/companies";
    }
    @GetMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable("courseId") Long courseId) {
        Long companyId = courseService.findCourseById(courseId).getCompany().getId();
        courseService.deleteByOD(courseId);
//        return "redirect:/companies/find/" + courseService.findCourseById(courseId).getId();
        return "redirect:/companies/find/" + companyId;
    }


}
