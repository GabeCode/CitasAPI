package com.gabrego.citasapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "identifications")
public class Identification {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public Identification() {
    }

    public Identification(int id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" + '\'' +
                "id=" + id + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status + '\'' +
                '}';
    }
}
