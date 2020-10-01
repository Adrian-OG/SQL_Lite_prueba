package com.example.sql_lite_prueba;

public class Alumno {
    private int id_alumno;
    private String nombre;
    private String codigo;
    private String celular;
    private String email;

    public Alumno() {
        super() ;
    }

    public Alumno(int id_alumno, String nombre, String codigo, String celular, String email) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.codigo = codigo;
        this.celular = celular;
        this.email = email;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
