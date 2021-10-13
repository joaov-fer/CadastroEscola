/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.app.springcontroller;


//import com.main.app.bean.Escola;
import com.main.app.bean.Escola;
import com.main.app.dao.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/escola")
public class EscolaControl {
    
    @Autowired
    EscolaRepository dao;
        

    @GetMapping
    public String greetingForm(Model model) {
      model.addAttribute("escola", new Escola());
      model.addAttribute("escolas", dao.findAll());
      return "escola";
    }
    
    
    @PostMapping
    public String save(@ModelAttribute Escola escola, BindingResult bindingResult, Model model) {
        
        System.out.println("Teste " + escola);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
        }
        
        dao.save(escola);
        
        return "redirect:/escola";
    }
    
    @PostMapping("/save")
    public String update(@ModelAttribute Escola escola, BindingResult bindingResult, Model model) {
        
        System.out.println("Teste " + escola);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
        }
        
        dao.save(escola);
        
        return "redirect:/escola";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        
        dao.deleteById(id);        
        return "redirect:/escola";
    }
    
    
    @ResponseBody
    @GetMapping("/r/{id}")
    public Escola escolaedit(@PathVariable("id") Long id) {
      
      return dao.findById(id).get();

    }
      

    
}
