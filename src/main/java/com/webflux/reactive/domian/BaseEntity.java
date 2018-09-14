package com.webflux.reactive.domian;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by HeWei on 2018/3/28.
 * .
 */
@Data
public class BaseEntity implements Serializable, Persistable<String> {

    @Id
    private String id;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @Override
    public boolean isNew() {
        return Objects.isNull(this.createdAt);
    }
}