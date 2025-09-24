package br.edu.utfpr.e_station.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.e_station.dto.PersonDTO;
import br.edu.utfpr.e_station.model.Person;
import br.edu.utfpr.e_station.service.PersonService;





@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService ps)
    {
        personService = ps;
    }

    @GetMapping("getAll")
    public List<Person> getAllPerson() 
    {
        return personService.getAll();
    }
    
    @GetMapping("getById/{id}")
    public Person getPersonById(@PathVariable UUID id)
    {
        return personService.getById(id);
    }
    
    @PostMapping("create")
    public Person create(@RequestBody PersonDTO dto) 
    {
        return personService.create(dto);
    }
    
    @PutMapping("update/{id}")
    public Person update(@PathVariable UUID id, @RequestBody PersonDTO dto)
    {
        return personService.update(id, dto);
    }

    @PostMapping("delete/{id}")
    public void delete(@PathVariable UUID id)
    {
        personService.delete(id);
    }
    
    @GetMapping("getByCpf/{cpf}")
    public Person getByCpf(@PathVariable String cpf)
    {
        return personService.getByCpf(cpf);
    }
    
    


}
