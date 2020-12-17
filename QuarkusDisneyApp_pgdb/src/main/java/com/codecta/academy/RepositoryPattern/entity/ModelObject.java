package com.codecta.academy.RepositoryPattern.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Objects;

@MappedSuperclass
public abstract class ModelObject<K> {
    public abstract K getID();

    @Column(name = "CREATED_ON")
    private LocalDateTime createdOn;
    @Column(name = "MODIFIED_ON")
    private LocalDateTime modifiedOn;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ModelObject)) {
            return false;
        }
        ModelObject that = (ModelObject) o;
        if (getID() == null && that.getID() == null) {
            return false;
        }
        return Objects.equals(getID(), that.getID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
