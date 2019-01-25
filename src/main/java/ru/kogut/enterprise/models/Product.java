package ru.kogut.enterprise.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "discription")
    private String discription;

    @Column(name = "isDelete")
    private boolean isDelete;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
