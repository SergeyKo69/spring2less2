package ru.kogut.enterprise.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "address")
    private String address;

    @Column(name = "isDelete")
    private boolean isDelete;

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
