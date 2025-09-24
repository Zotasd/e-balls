package br.edu.utfpr.e_station.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.e_station.dto.PersonDTO;
import br.edu.utfpr.e_station.model.Person;
import br.edu.utfpr.e_station.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepo;

    public List<Person> getAll() 
    {
        return personRepo.findAll();
    }

    public Person getById(UUID id)
    {
        var existingPerson = personRepo.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
        
        Person person = new Person();
        BeanUtils.copyProperties(existingPerson, person);

        return person;
    }

    public Person create(PersonDTO dto) 
    {
        var person = new Person();

        person.setCreateDate(LocalDateTime.now());
        BeanUtils.copyProperties(dto, person);
        return personRepo.save(person);
    }

    public Person update(UUID id, PersonDTO dto) 
    {
        var existingPerson = personRepo.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));;

        BeanUtils.copyProperties(dto, existingPerson);
        existingPerson.setUpdateDate(LocalDateTime.now());

        return personRepo.save(existingPerson);
    }

    public void delete(UUID id)
    {
        if(personRepo.existsById(id))
        {
            personRepo.deleteById(id);
        }
        else
        {
            throw new RuntimeException("Pessoa com ID: " + id + " não encontrada");
        }
    }

    public Person getByCpf(String cpf)
    {
        var existingPerson = personRepo.findByCpf(cpf);
        
        if(existingPerson == null)
        {
            throw new RuntimeException("Pessoa com cpf " +cpf + " não encontrada");
        }
        
        Person person = new Person();
        BeanUtils.copyProperties(existingPerson, person);

        return person;
    }

}
