/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.controller;


import co.edu.sena.examplejpa.model.EmployeeType;
import java.util.List;

/**
 *
 * @author Nicolle
 */
public interface IEmployeeTypeController {
    public void insert(EmployeeType employeeType) throws Exception;
    public void update(EmployeeType employeeType)throws Exception;
    public void delete(EmployeeType employeeType)throws Exception;
    public List<EmployeeType> findAll()throws Exception;
    public EmployeeType findById(Integer id)throws Exception;
}
