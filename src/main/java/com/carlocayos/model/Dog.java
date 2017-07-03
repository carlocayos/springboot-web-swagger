package com.carlocayos.model;

import javax.persistence.*;

@Entity
@Table(name = "dog")
public class Dog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @Column
    private String breed;

    @Column
    private int age;

    /**
     * @return
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return
     */
    public String getBreed()
    {
        return breed;
    }

    /**
     * @param breed
     */
    public void setBreed(String breed)
    {
        this.breed = breed;
    }

    /**
     * @return
     */
    public int getAge()
    {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(int age)
    {
        this.age = age;
    }
}
