package com.carlocayos.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long>
{
    List<Dog> findByAge(int age);

    // @Query annotation
    @Query("select d from Dog d where d.breed = ?1")
    Dog findDogByBreed(String breed);
}
