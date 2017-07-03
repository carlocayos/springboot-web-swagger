package com.carlocayos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(value = "Dog", description = "A dog")
public class DogDTO
{
    @ApiModelProperty(value = "The unique dog identifier", readOnly = true)
    private Long id;

    @ApiModelProperty(value = "Name of the dog", required = true)
    @NotNull
    private String name;

    @NotNull
    @ApiModelProperty(value = "Breed of the dog", required = true)
    private String breed;

    @NotNull
    @ApiModelProperty(value = "Age of the dog", required = true)
    private int age;

    /**
     */
    public DogDTO()
    {
    }

    /**
     * @param id
     * @param name
     * @param breed
     * @param age
     */
    public DogDTO(Long id, String name, String breed, int age)
    {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getBreed()
    {
        return breed;
    }

    public int getAge()
    {
        return age;
    }
}
