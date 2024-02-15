package spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.ebtity.Company;
import spring.service.CompanyService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;
    @GetMapping
    public String getAllCompany (Model model){
        model.addAttribute("allCompanies",companyService.findAll());
        return "/companies";
    }

    @GetMapping("/new")
    public String createCompany(Model model){
        model.addAttribute("newCompany",new Company());
        return ("createNewCompany");
    }
    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("newCompany") Company company){
        companyService.saveCompany(company);
        return"redirect:/companies";
    }

    @GetMapping("/update/{companyId}")
    public String updateForm(@PathVariable("companyId")Long companyId,Model model){
        Company company = companyService.findCompanyById(companyId);
        model.addAttribute("company",company);
        return "companyForm";
    }

    @GetMapping("/find/{companyId}")
    public String getById(Model model,@PathVariable("companyId") Long id){
        Company company = companyService.findCompanyById(id);
        model.addAttribute("companyId",id);
        model.addAttribute("companyInfo",company.getCourses());
        return "companyInnerPage";
    }

    @PostMapping("/edit/{companyId}")
    public String update(@ModelAttribute("company")Company newCompany,@PathVariable ("companyId")Long companyId){
        companyService.updateCompanyById(companyId,newCompany);
        return "redirect:/companies";
    }

    @GetMapping("/delete/{companyId}")
    public String deleteCompanyById(@PathVariable("companyId")Long companyId){
        companyService.deleteByOD(companyId);
        return  "redirect:/companies";
    }







}
