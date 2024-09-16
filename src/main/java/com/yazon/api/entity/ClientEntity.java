package com.yazon.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpfOrCnpj;
    private boolean isActive;
    private int companyId;

    public ClientEntity(String name, String cpfOrCnpj){
        this.name = name;
        this.cpfOrCnpj = cpfOrCnpj;
        this.isActive = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
