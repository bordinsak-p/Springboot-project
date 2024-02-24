package com.basic.resful.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="table_food")
public class TableFoodBean {
    @Id
    @SequenceGenerator(name = "TableCodeSesqence", sequenceName = "TableCode_id_seq", allocationSize = 1, initialValue = 15)
    @GeneratedValue(generator = "TableCodeSesqence")
    private Integer id;

    @Column(name = "table_code")
    private String tableCode;
}
