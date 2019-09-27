package com.example.springboot.demo.datebase;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "model_info")
public class Model_info {
    @Id
    @Column(name = "model_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int model_id;

    @Column(name = "model_date")
    private String model_date;

    @Column(name = "serial_number")
    private String serial_number;

    @Column(name = "model_kind")
    private int model_kind;

    @Column(name = "model_kind_name")
    private String model_kind_name;

    @Column(name = "firmware_version")
    private String firmware_version;

    @Column(name = "pcb_version")
    private String pcb_version;

    public int getModel_kind() {
        return model_kind;
    }

    public void setModel_kind(int model_kind) {
        this.model_kind = model_kind;
    }

    public String getModel_kind_name() {
        return model_kind_name;
    }

    public void setModel_kind_name(String model_kind_name) {
        this.model_kind_name = model_kind_name;
    }

    public String getFirmware_version() {
        return firmware_version;
    }

    public void setFirmware_version(String firmware_version) {
        this.firmware_version = firmware_version;
    }

    public String getPcb_version() {
        return pcb_version;
    }

    public void setPcb_version(String pcb_version) {
        this.pcb_version = pcb_version;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getModel_date() {
        return model_date;
    }

    public void setModel_date(String model_date) {
        this.model_date = model_date;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }
}
