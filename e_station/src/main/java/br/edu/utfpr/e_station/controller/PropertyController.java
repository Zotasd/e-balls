
package br.edu.utfpr.e_station.controller;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.e_station.dto.PropertyDTO;
import br.edu.utfpr.e_station.model.Property;
import br.edu.utfpr.e_station.service.PropertyService;



@RestController
@RequestMapping("/property")
public class PropertyController {

    private PropertyService propertyService;

    public PropertyController(PropertyService ps) 
    {
        this.propertyService = ps;
    }

    @GetMapping("getAll")
    public List<Property> getAll()
    {
        return propertyService.getAll();
    }

    @GetMapping("getById/{id}")
    public Property getById(@PathVariable UUID id)
    {
        return propertyService.getById(id);
    }

    @GetMapping("getByOwnerId/{id}")
    public Page<Property> getByOwnerId(@PathVariable UUID id)
    {
        return propertyService.getByOwnerId(id, 0, 10);
    }
    
    @PostMapping("create")
    public Property create(@RequestBody PropertyDTO dto) 
    {
        return propertyService.create(dto);
    }
    
    @PutMapping("update/{id}")
    public Property update(@PathVariable UUID id, @RequestBody PropertyDTO dto) 
    {
        return propertyService.update(id, dto);
    }
    
    @PostMapping("delete/{id}")
    public void delete(@PathVariable UUID id) 
    {
       propertyService.delete(id);
    }
    
    

    

}
