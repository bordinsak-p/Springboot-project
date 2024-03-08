package com.basic.resful.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="table_food")
public class TableFood {
    @Id
    @SequenceGenerator(name = "TableFoodSesqence", sequenceName = "TableFood_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "TableFoodSesqence")
    private Integer id;

    @Column(name = "table_code")
    private String tableCode;
}
