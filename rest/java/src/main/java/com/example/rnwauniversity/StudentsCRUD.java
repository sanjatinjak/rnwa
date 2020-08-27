package com.example.rnwauniversity;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/api")
public class StudentsCRUD {

    @Autowired
    StudentRepository sr;
    
    
    //GET
    
    @RequestMapping(value = "/rest/students", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Student> studentsRest(){
        return sr.findAll();
    }
    
 
    @RequestMapping(value = "/rest/student/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Student studentRest(@PathVariable int id){
        return sr.findById(id);
    }
    
    @RequestMapping(value = "/html/students", method = RequestMethod.GET)
    public String studentsHtml(Model md) {
 
        List<Student> students = sr.findAll();
        md.addAttribute("students", students);
        
        return "showStudents";
    }
    
    
    @RequestMapping(value = "/html/student/{id}", method = RequestMethod.GET)
    public String studentHtml(@PathVariable int id, Model md){
        md.addAttribute("student", sr.findById(id));
        return "student";
    }
    
    //POST
    
    @RequestMapping(value = "/rest/studentAdd", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> studentsAddRest(@RequestParam("ime") String ime, @RequestParam("fakultetId") int fid ){
        
        Student st = new Student();
        st.setIme(ime);
        st.setFakultetId(fid);

            try{
                Student savedSt = sr.save(st);
                //return "Novi zapis dodan id - " + savedSt.getId();
                return Collections.singletonMap("status", " " + savedSt.getId());
            } catch(Exception e) {
                return Collections.singletonMap("status", e.getLocalizedMessage());
            }
            
    }
    
    @RequestMapping(value = "/html/studentAdd", method = RequestMethod.GET)
    public String studentsAddNew(Model model){
        model.addAttribute("student", new Student());
        return "addNew";
        
    }
    
    @RequestMapping(value = "/html/studentAdd", method = RequestMethod.POST)
    public String studentsAddNewHtml(@ModelAttribute Student student, BindingResult result, RedirectAttributes redirectAttributes){
        
        Student st = new Student();
        st.setIme(student.getIme());
        st.setFakultetId(student.getFakultetId());

            try{
            Student savedSt = sr.save(st);
            
            //return "Novi zapis dodan id - " + savedSt.getId();
            redirectAttributes.addFlashAttribute("message", "Student sa id - " + savedSt.getId() + " uspješno dodan !");
            
            return "redirect:/api/html/studentAdd";
            
            } catch(Exception e) {
                return e.getLocalizedMessage();
            }
            
    }
    
    //PUT
    
    @RequestMapping(value = "/rest/studentUpdate/{id}", method = {RequestMethod.PUT,RequestMethod.GET})
    @ResponseBody
    public void studentsUpdateRest(@PathVariable int id,@RequestParam("ime") String ime, @RequestParam("fakultetId") int fid){
        Student s = sr.findById(id);
        s.setIme(ime);
        s.setFakultetId(fid);
        sr.save(s);
    }
    
    @RequestMapping(value = "/html/studentUpdate/{id}", method = RequestMethod.GET)
    public String studentsUpdateHtml(@PathVariable int id, Model md){
       md.addAttribute("student", sr.findById(id));
       return "studentUpdate";
    }
    
    @RequestMapping(value = "/html/studentUpdate", method = RequestMethod.POST)
    public String studentUpdateHtmlForm(@ModelAttribute Student student, BindingResult result, RedirectAttributes redirectAttributes){
        
        int id = student.getId();
        Student st = sr.findById(id);
        
        st.setIme(student.getIme());
        st.setFakultetId(student.getFakultetId());
        
            try{
            Student savedSt = sr.save(st);
            
            //return "Novi zapis dodan id - " + savedSt.getId();
            redirectAttributes.addFlashAttribute("message", "Student sa id - " + savedSt.getId() + " uspješno ažuriran !");
            
            return "redirect:/api/html/students";
            
            } catch(Exception e) {
                return e.getLocalizedMessage();
            }
            
    }
    
    //DELETE
    
    @RequestMapping(value = "/rest/studentDelete/{id}", method = {RequestMethod.DELETE,RequestMethod.GET})
    @ResponseBody
    public void studentDeleteRest(@PathVariable int id){
        Student s = sr.findById(id);
        sr.delete(s);
    }
    
    @RequestMapping(value = "/html/studentDelete/{id}", method = {RequestMethod.DELETE,RequestMethod.GET})
    public String studentDeleteHtml(@PathVariable int id, RedirectAttributes redirectAttributes){
       
        Student s = sr.findById(id);
        sr.delete(s);
        
        redirectAttributes.addFlashAttribute("message", "Student sa id - " + s.getId() + " uspješno obrisan !");
        
        return "redirect:/api/html/students";
    }
    

}
