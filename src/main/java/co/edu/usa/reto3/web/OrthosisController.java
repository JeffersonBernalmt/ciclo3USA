/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.web;

import co.edu.usa.reto3.model.Category;
import co.edu.usa.reto3.model.Orthosis;
import co.edu.usa.reto3.services.OrthosisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ivan
 */
@RestController
@RequestMapping("/api/Ortopedic")
@CrossOrigin(origins="*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class OrthosisController {
    @Autowired
    private OrthosisService ortesisService;
    
    @GetMapping("/all")
    public List<Orthosis> getAll(){
        return ortesisService.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Orthosis save(@RequestBody Orthosis ortesis){
        return ortesisService.save(ortesis);
    }
    
     @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        return new ResponseEntity<>(ortesisService.delete(id), HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Orthosis update(@RequestBody Orthosis ortesis) {
        return ortesisService.update(ortesis);
    }
}
