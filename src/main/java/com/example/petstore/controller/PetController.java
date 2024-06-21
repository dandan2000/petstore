package com.example.petstore.controller;

import com.example.petstore.model.Pet;
import com.example.petstore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> findPets(
            @RequestParam(value = "tags", required = false) List<String> tags,
            @RequestParam(value = "limit", required = false) Integer limit) {
        List<Pet> pets = petService.findAllPets(tags, limit);
        return ResponseEntity.ok(pets);
    }

    @PostMapping
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        Pet createdPet = petService.addPet(pet);
        return ResponseEntity.ok(createdPet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> findPetById(@PathVariable Long id) {
        Optional<Pet> pet = petService.findPetById(id);
        return pet.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}
