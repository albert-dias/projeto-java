package com.yazon.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name="driver")
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int companyId;


    public DriverEntity(String name) {
        this.name = name;
    } public DriverEntity(String name, int companyId) {
        this.name = name;
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
