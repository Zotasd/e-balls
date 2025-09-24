package br.edu.utfpr.e_station.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.utfpr.e_station.dto.PropertyDTO;
import br.edu.utfpr.e_station.model.Person;
import br.edu.utfpr.e_station.model.Property;
import br.edu.utfpr.e_station.repository.PropertyRepository;
import jakarta.persistence.EntityNotFoundException;


@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepo;

    @Autowired
    private PersonService personService;

    public List<Property> getAll() 
    {
        return propertyRepo.findAll();
    }

    public Property getById(UUID id)
    {
        var existingProperty = propertyRepo.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Propriedade não encontrada"));
        
        Property property = new Property();
        BeanUtils.copyProperties(existingProperty, property);
        
        return property;
    }
    
    public Page<Property> getByOwnerId(UUID id, int page, int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return propertyRepo.findAllByOwnerId(id, pageable);
    }

    public Property create(PropertyDTO dto)
    {
        Property property = new Property();
        Person person = personService.getById(dto.ownerId());
        
        BeanUtils.copyProperties(dto, property);
        property.setOwner(person);
        return propertyRepo.save(property);
    }

    public Property update(UUID id, PropertyDTO dto)
    {
        var existingProperty = propertyRepo.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Propriedade não encontrada"));

        Person person = personService.getById(dto.ownerId());

        BeanUtils.copyProperties(dto, existingProperty);
        existingProperty.setOwner(person);
        existingProperty.setUpdateDate(LocalDateTime.now());
        propertyRepo.save(existingProperty);

        return existingProperty;
    }

    public void delete(UUID id)
    {
        if(propertyRepo.existsById(id))
        {
            propertyRepo.deleteById(id);
        }
        else
        {
            throw new RuntimeException("Propriedade com ID: " + id + " não encontrada");
        }
    }
        
        
}
