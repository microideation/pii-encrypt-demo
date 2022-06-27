package com.microideation.samples.piiencryptdemo.domain;

import com.microideation.samples.piiencryptdemo.support.PIIAttributeConverter;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CUSTOMERS")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = PIIAttributeConverter.class)
    private String mobile;

    @Convert(converter = PIIAttributeConverter.class)
    private String name;
}
