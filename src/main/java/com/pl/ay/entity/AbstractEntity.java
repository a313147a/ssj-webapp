package com.pl.ay.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lemon_bar on 15/7/13.
 */
@Data
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    private Date createDate;

    @Column(name = "UPDATE_DATE", nullable = false)
    private Date updateDate;

    protected void touchCreateTime() {
        this.createDate = new Date();
    }

    protected void touchUpdateTime() {
        this.updateDate = new Date();
    }

    @PrePersist
    public void fireCreated() {
        touchCreateTime();
        touchUpdateTime();
    }

    @PreUpdate
    public void fireUpdated() {
        touchUpdateTime();
    }
}
