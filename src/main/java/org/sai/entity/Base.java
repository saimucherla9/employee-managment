package org.sai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public abstract class Base {

    @Column(name = "CREATED_BY", updatable = false)
    private String createdBy;

    @CreationTimestamp
    @Column(name = "CREATED_TIME", updatable = false)
    private Timestamp createdTime;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @UpdateTimestamp
    @Column(name = "UPDATED_TIME")
    private Timestamp updatedTime;

}
