package org.example;

public class Empleado {
    private int id;
    private String name;
    private int edad;
    private int salario;
    private String departamento;

    public Empleado(int id, String name, int edad, int salario, String departamento) {
        this.id = id;
        this.name = name;
        this.edad = edad;
        this.salario = salario;
        this.departamento = departamento;
    }

    public Empleado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
