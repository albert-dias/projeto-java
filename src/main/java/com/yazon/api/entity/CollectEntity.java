package com.yazon.api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name= "collects")
public class CollectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int companyId;
    private int clientId;
    private int userId;
    private int driverId;
    private boolean isConfirm;
    private boolean isComplete;

    private LocalDateTime dtConfirm;
    private LocalDateTime dtComplete;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public boolean isConfirm() {
        return isConfirm;
    }

    public void setConfirm(boolean confirm) {
        isConfirm = confirm;
        this.setDtConfirm(LocalDateTime.now());
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
        this.setDtComplete(LocalDateTime.now());
    }

    public LocalDateTime getDtConfirm() {
        return dtConfirm;
    }

    public void setDtConfirm(LocalDateTime dtConfirm) {
        this.dtConfirm = dtConfirm;
    }

    public LocalDateTime getDtComplete() {
        return dtComplete;
    }

    public void setDtComplete(LocalDateTime dtComplete) {
        this.dtComplete = dtComplete;
    }
}
