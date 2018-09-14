package com.webflux.reactive.domian;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;


@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class HelloWord extends BaseEntity {

    private String name;

    private String value;
}
