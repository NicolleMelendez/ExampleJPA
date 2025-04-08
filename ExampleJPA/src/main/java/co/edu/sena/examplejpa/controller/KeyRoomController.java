/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;


import co.edu.sena.examplejpa.model.KeyRoom;
import java.util.List;

/**
 *
 * @author Nicolle
 */
public class KeyRoomController implements IKeyRoomController{
    
    DBKey dbk = new DBKey();

    @Override
    public void insert(KeyRoom keyRoom) throws Exception {
       if(keyRoom == null){
          throw new Exception("El tipo de llave es mala");
      }  
      if("".equals(keyRoom.getName())){
          throw new Exception("El nombre es obligatoria");
      }
      if(keyRoom.getCount() < 1){
          throw new Exception("El número de llaves es obligatoria");
      }
      if("".equals(keyRoom.getCount())){
          throw new Exception("El conteo es obligatoria");
      }

      
      dbk.insert(keyRoom);
        
    }

    @Override
    public void update(KeyRoom keyRoom) throws Exception {
        if(keyRoom == null){
          throw new Exception("El tipo de llave es nula");
      }
        if(keyRoom.getId() == 0){
            throw new Exception("El Id es obligatorio");
        }
        
        if("".equals(keyRoom.getName())){
          throw new Exception("El nombre es obligatoria");
        }
        if(keyRoom.getCount() < 1){
            throw new Exception("El número de llaves es obligatoria");
        }
        if("".equals(keyRoom.getCount())){
          throw new Exception("El conteo es obligatoria");
        }
        
        KeyRoom keyExists = dbk.findById(keyRoom.getId());
        if(keyExists == null){
            throw new Exception("La llave no existe");
        }
        
        dbk.update(keyRoom);
        
    }

    @Override
    public void delete(int id) throws Exception {
        if(id == 0){
            throw new Exception("El Id es obligatorio");
        }
        
        KeyRoom keyExists = dbk.findById(id);
        if(keyExists == null){
            throw new Exception("La llave no existe");
        }
        dbk.delete(id);
        
    }

    @Override
    public List<KeyRoom> findAll() throws Exception {
        return dbk.findAll();
    }

    @Override
    public KeyRoom findById(int id) throws Exception {
        if(id == 0){
            throw new Exception("El Id es obligatorio");
        }
        return dbk.findById(id);    }
}
