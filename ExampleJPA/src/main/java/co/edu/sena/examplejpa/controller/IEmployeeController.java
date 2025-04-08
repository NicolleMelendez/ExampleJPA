/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.controller;


import co.edu.sena.examplejpa.model.Employee;
import java.util.List;

/**
 *
 * @author Nicolle
 * Objetivo: interface para el modelo employee
 */
public interface IEmployeeController {
    public void insert(Employee employee) throws Exception;
    public void update(Employee employee) throws Exception;
    public void delete (Employee employee) throws Exception;
    public List<Employee> findAll() throws Exception;
    public Employee findById(Long document) throws Exception;
}
