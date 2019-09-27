package com.example.springboot.demo.datebase;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "model_kind")
public class Model_kind {

    @Id
    @Column(name = "model_kind_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int model_kind_id;

    @Column(name = "model_kind_name_cn")
    private String model_kind_name_cn;

    @Column(name = "model_kind_name_en")
    private String model_kind_name_en;

    public int getModel_kind_id() {
        return model_kind_id;
    }

    public void setModel_kind_id(int model_kind_id) {
        this.model_kind_id = model_kind_id;
    }

    public String getModel_kind_name_cn() {
        return model_kind_name_cn;
    }

    public void setModel_kind_name_cn(String model_kind_name_cn) {
        this.model_kind_name_cn = model_kind_name_cn;
    }

    public String getModel_kind_name_en() {
        return model_kind_name_en;
    }

    public void setModel_kind_name_en(String model_kind_name_en) {
        this.model_kind_name_en = model_kind_name_en;
    }
}
