/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.sises.modelo;

import java.util.Date;

/**
 *
 * @author galagarza
 */
public class Student {

    private String carnet;
    private String nombre;
    private Date fechaNacimiento;
    private String telefono;
    private String direccion;

    public Student() {
    }

    public Student(String carnet, String nombre, Date fechaNacimiento, String telefono, String direccion) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getDataStudent(int i) {
        switch (i) {
            case 0:
                return this.getCarnet();
            case 1:
                return this.getNombre();
            case 3:
                return this.getTelefono();
            case 4:
                return this.getDireccion();
            default:
                return "";
        }
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Student{" + "carnet=" + carnet + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

}
