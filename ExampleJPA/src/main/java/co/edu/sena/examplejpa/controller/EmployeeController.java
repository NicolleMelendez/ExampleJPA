/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;



import co.edu.sena.examplejpa.model.Employee;
import java.util.List;

/**
 *
 * @author Nicolle
 */
public class EmployeeController implements IEmployeeController {

    DBEmployee dbe = new DBEmployee();
    
    @Override
    public void insert(Employee employee) throws Exception {
        if(employee == null){
           throw new Exception("El empleado es nulo") ;
        }
        
        if(employee.getDocument() == 0){
            throw new Exception("El documento es obligatorio");
        }
        
        if("".equals(employee.getFullname())){
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(employee.getAddress())){
            throw new Exception("La direccion es obligatoria");
        }
        if("".equals(employee.getPhone())){
            throw new Exception("El telefono es obligatoria");

        }
        //FK
        if(employee.getEmployeeType() == null){
            throw new Exception("El tipo de empleado es obligatorio");
        }
        
        //la FK no es autocremental, se debe validar el empleado
        Employee employeeExists = dbe.findById(employee.getDocument());
        if(employeeExists != null){
            throw new Exception("Ya existe u empleado cone se documento");
        }
        
        //insertar
        dbe.insert(employee);
    }

    @Override
    public void update(Employee employee) throws Exception {
        if(employee == null){
           throw new Exception("El empleado es nulo") ;
        }
        
        if(employee.getDocument() == 0){
            throw new Exception("El documento es obligatorio");
        }
        
        if("".equals(employee.getFullname())){
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(employee.getAddress())){
            throw new Exception("La direccion es obligatoria");
        }
        if("".equals(employee.getPhone())){
            throw new Exception("El telefono es obligatoria");

        }
        //FK
        if(employee.getEmployeeType() == null){
            throw new Exception("El tipo de empleado es obligatorio");
        }
        
        Employee employeeExists = dbe.findById(employee.getDocument());
        if(employeeExists != null){
            throw new Exception("No existe el empleado");
        }
        
        //insertar
        dbe.update(employee);
    }

    @Override
    public void delete(long document) throws Exception {
        if(document == 0){
            throw new Exception("El documento es obligatorio");
        }
        
        Employee employeeExists = dbe.findById(document);
        if(employeeExists != null){
            throw new Exception("No existe el empleado");
        }
        
        dbe.delete(document);
    }

    @Override
    public List<Employee> findAll() {
        return dbe.findAll();
    }

    @Override
    public Employee findById(long document) throws Exception {
        if(document == 0){
            throw new Exception("El documento es obligatorio");
        }
        return dbe.findById(document);
    }
    
}
