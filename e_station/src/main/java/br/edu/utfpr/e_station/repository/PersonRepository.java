package br.edu.utfpr.e_station.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.utfpr.e_station.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> 
{
    Person findPersonById(UUID id);
    Person findByCpf(String cpf);
}
