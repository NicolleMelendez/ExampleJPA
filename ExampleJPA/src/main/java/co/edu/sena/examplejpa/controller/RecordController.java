/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.bd.DBRecord;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejpa.model.Record;
import java.util.List;

/**
 *
 * @author Nicolle
 */
public class RecordController implements IRecordController{

    private DBRecord dbr = new DBRecord();
    private DBEmployee dbe = new DBEmployee();
    private DBKey dbk = new DBKey();
    
    @Override
    public void insert(Record record) throws Exception {
        if(record == null){
           throw new Exception("El registro es nulo") ;
        }
        if("".equals(record.getDateRecord())){
            throw new Exception("La fecha es obligatoria");
        }
        if("".equals(record.getStartTime())){
            throw new Exception("El comienzo del tiempo es obligatorio");
        }

        
        //FK
        if(record.getEmployeeId() == null){
            throw new Exception("El tipo de empleado es obligatorio");
        }
        if(record.getKeyId() == null){
            throw new Exception("El tipo de llave es obligatorio");
        }
        

        
        //insertar
        dbr.insert(record);
        
        
    }

    @Override
    public void update(Record record) throws Exception {
        if (record == null) {
            throw new Exception("El registro es nulo");
        }
        
        if (record.getId() == 0){
            throw new Exception("El id es obligatorio");
        }
        
        if ("".equals(record.getDateRecord())) {
            throw new Exception("La fecha es obligatoria");
        }
        
        if ("".equals(record.getStartTime())) {
            throw new Exception("El inicio es obligatio");
        }
        
        // FK
        if (record.getEmployeeId() == null) {
            throw new Exception("El ID del empleado es obligatorio.");
        }
        // FK
        if (record.getKeyId()== null) {
            throw new Exception("El ID de la llave es obligatorio.");
        }
        if ("".equals(record.getStatus())) {
            throw new Exception("El estado es obligatorio.");
        }
        
        //actualizar
        dbr.update(record);    
    }

    @Override
    public void delete(int id) throws Exception {
        if(id == 0){
            throw new Exception("El id es obligatorio");
        }    

        Key keyExists = dbk.findById(id);
        if(keyExists == null){
            throw new Exception("No una llave con ese documento");
        }
        
        //eliminar
        dbr.delete(id);
        
    }

    @Override
    public List<Record> findAll() throws Exception {
        return dbr.findAll();

    }

    @Override
    public Record findById(int id) throws Exception {
        if(id == 0){
            throw new Exception("El documento es obligatorio");
        } 
        return dbr.findById(id);
    }
    
}
