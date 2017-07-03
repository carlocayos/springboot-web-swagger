package com.carlocayos.service;

import com.carlocayos.dto.DogDTO;
import com.carlocayos.model.Dog;
import com.carlocayos.model.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DogServiceImpl
{
    @Autowired
    private DogRepository repository;

    public List<DogDTO> findAll()
    {
        return repository.findAll().stream()
                .map(entity -> new DogDTO(entity.getId(), entity.getName(), entity.getBreed(),
                        entity.getAge()))
                .collect(Collectors.toList());
    }

    @Transactional
    public DogDTO create(DogDTO dogDTO)
    {
        Dog dog = new Dog();
        dog.setName(dogDTO.getName());
        dog.setBreed(dogDTO.getBreed());
        dog.setAge(dogDTO.getAge());
        Dog savedDog = repository.saveAndFlush(dog);
        return new DogDTO(savedDog.getId(), savedDog.getName(), savedDog.getBreed(),
                savedDog.getAge());
    }

    @Transactional
    public DogDTO update(Long id, DogDTO dogDTO)
    {
        Dog entity = findOneSafe(id);
        entity.setName(dogDTO.getName());
        entity.setBreed(dogDTO.getBreed());
        entity.setAge(dogDTO.getAge());
        return new DogDTO(entity.getId(), entity.getName(), entity.getBreed(), entity.getAge());
    }

    @Transactional
    public void delete(Long id)
    {
        Dog dog = findOneSafe(id);
        repository.delete(dog);
    }

    private Dog findOneSafe(Long id)
    {
        Dog dog = repository.findOne(id);
        if (dog == null)
        {
//            throw new TaskNotFoundException(id);
            throw new NullPointerException("Not found");
        }
        else
        {
            return dog;
        }
    }
}
