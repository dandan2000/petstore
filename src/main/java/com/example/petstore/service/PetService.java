package com.example.petstore.service;

import com.example.petstore.model.Pet;
import com.example.petstore.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> findAllPets(List<String> tags, Integer limit) {
        // Implementar lógica de filtro y limit
        return petRepository.findAll();
    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Optional<Pet> findPetById(Long id) {
        return petRepository.findById(id);
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
