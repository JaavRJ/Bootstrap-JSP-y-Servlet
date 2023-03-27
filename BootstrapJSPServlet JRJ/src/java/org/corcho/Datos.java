package org.corcho;


import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alumno
 */
public class Datos implements Serializable
{
    private String nombre;
    private float calf;
    private String apelliP;
    private String apelliM;
    private String genero;
    private String carrera;
    private String semes;

    public String getApelliP() {
        return apelliP;
    }

    public void setApelliP(String apelliP) {
        this.apelliP = apelliP;
    }

    public String getApelliM() {
        return apelliM;
    }

    public void setApelliM(String apelliM) {
        this.apelliM = apelliM;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemes() {
        return semes;
    }

    public void setSemes(String semes) {
        this.semes = semes;
    }
    

    public Datos() 
    {
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public float getCalf()
    {
        return calf;
    }

    public void setCalf(float calf)
    {
        this.calf = calf;
    }
    
    
    
    
    
}
