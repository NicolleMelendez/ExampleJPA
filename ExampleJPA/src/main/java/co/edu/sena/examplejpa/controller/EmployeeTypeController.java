/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;


import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;



/**
 *
 * @author Nicolle
 */
public class EmployeeTypeController implements IEmployeeTypeController{

    

    
    
    @Override
    public void insert(EmployeeType employeeType) throws Exception {
      if(employeeType == null){
          throw new Exception("El tipo de empleado es malo");
      }  
      if("".equals(employeeType.getDescript())){
          throw new Exception("La descripción es obligatoria");
      }
      
      //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().insert(employeeType);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
      
    }

    @Override
    public void update(EmployeeType employeeType) throws Exception {
        if(employeeType == null){
          throw new Exception("El tipo de empleado es malo");
      }  
        if(employeeType.getId() == 0){
            throw new Exception("El Id es obligatorio");
        }
        if("".equals(employeeType.getDescript())){
          throw new Exception("La descripción es obligatoria");
      }
        
        //consultar si el employeetype exista en la bd
        EmployeeType employeeTypeExists = dbe.findById(employeeType.getId());
        if(employeeTypeExists == null){
            throw new Exception("El tipo de empleado no existe");
        }
        
        
        //actualizar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().update(employeeType);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(int id) throws Exception {
        if(id == 0){
            throw new Exception("El Id es obligatorio");
        }
        //consultar si el employeetype exista en la bd
        EmployeeType employeeTypeExists = dbe.findById(id);
        if(employeeTypeExists == null){
            throw new Exception("El tipo de empleado no existe");
        }
        
        //eliminar
        DAOFactory.getEmployeeTypeDAO().delete(employeeTypeExists);
        
    }

    @Override
    public List<EmployeeType> findAll() throws Exception {
        return dbe.findAll();
    }

    @Override
    public EmployeeType findById(int id) throws Exception {
        if(id == 0){
            throw new Exception("El Id es obligatorio");
        }
        return dbe.findById(id);
    }

}
