package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.KeyRoom;
import co.edu.sena.examplejpa.model.Record;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Nicolle
 */
public class RecordController implements IRecordController{
    
    @Override
    public void insert(Record record) throws Exception {
        if(record == null){
           throw new Exception("El registro es nulo") ;
        }
        if(record.getDateRecord() == null){
            throw new Exception("La fecha es obligatoria");
        }
        if(record.getStartTime() == null){
            throw new Exception("El comienzo del tiempo es obligatorio");
        }

        
        //FK
        if(record.getEmployeeId() == null){
            throw new Exception("El tipo de empleado es obligatorio");
        }
        if(record.getKeyId() == null){
            throw new Exception("El tipo de llave es obligatorio");
        }
        
        if("".equals(record.getStatus())){
            throw new Exception("El estado es obligatorio");
        }

        
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().insert(record);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
        
    }

    @Override
    public void update(Record record) throws Exception {
        if (record == null) {
            throw new Exception("El registro es nulo");
        }
        
        if (record.getId() == 0){
            throw new Exception("El id es obligatorio");
        }
        
        if (record.getDateRecord() == null) {
            throw new Exception("La fecha es obligatoria");
        }
        
        if (record.getStartTime() == null) {
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
        
        Record recordExists = DAOFactory.getRecordDAO().findById(record.getId());
        if(recordExists == null){
            throw new Exception("No existe el registro");
        }
        
        
        //merge
        recordExists.setDateRecord(record.getDateRecord());
        recordExists.setEmployeeId(record.getEmployeeId());
        recordExists.setEndTime(record.getEndTime());
        recordExists.setKeyId(record.getKeyId());
        recordExists.setStartTime(record.getStartTime());
        recordExists.setStatus(record.getStatus());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().update(recordExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
         
    }

    @Override
    public void delete(Integer id) throws Exception {
        if(id == 0){
            throw new Exception("El id es obligatorio");
        }    

        Record recordExists = DAOFactory.getRecordDAO().findById(id);
        if(recordExists == null){
            throw new Exception("No hay un registro en este documento");
        }
        
        //eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().delete(recordExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
        
    }

    @Override
    public List<Record> findAll() throws Exception {
        return DAOFactory.getRecordDAO().findAll();

    }

    @Override
    public Record findById(Integer id) throws Exception {
        if(id == 0){
            throw new Exception("El documento es obligatorio");
        } 
        return DAOFactory.getRecordDAO().findById(id);
    }
    
}
