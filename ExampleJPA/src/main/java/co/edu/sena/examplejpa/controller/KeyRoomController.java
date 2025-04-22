
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;


import co.edu.sena.examplejpa.model.KeyRoom;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Nicolle
 */
public class KeyRoomController implements IKeyRoomController{
    


    @Override
    public void insert(KeyRoom keyRoom) throws Exception {
       if(keyRoom == null){
          throw new Exception("El tipo de llave es mala");
      }  
      if("".equals(keyRoom.getName())){
          throw new Exception("El nombre es obligatoria");
      }
      if("".equals(keyRoom.getCount())){
          throw new Exception("El conteo es obligatoria");
      }
      if(keyRoom.getCount() < 1){
          throw new Exception("El número de llaves es obligatoria");
      }



      //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().insert(keyRoom);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
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
        
        KeyRoom keyExists = DAOFactory.getKeyRoomDAO().findById(keyRoom.getId());
        if(keyExists == null){
            throw new Exception("La llave no existe");
        }
        
        
        //merge
        keyExists.setCount(keyRoom.getCount());
        keyExists.setName(keyRoom.getName());
        keyExists.setObservation(keyRoom.getObservation());
        keyExists.setRoom(keyRoom.getRoom());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().update(keyExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

    @Override
    public void delete(Integer id) throws Exception {
        if(id == 0){
            throw new Exception("El Id es obligatorio");
        }
        
        KeyRoom keyExists = DAOFactory.getKeyRoomDAO().findById(id);
        if(keyExists == null){
            throw new Exception("La llave no existe");
        }
        
        
        //eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().delete(keyExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

    @Override
    public List<KeyRoom> findAll() throws Exception {
        return DAOFactory.getKeyRoomDAO().findAll();
    }

    @Override
    public KeyRoom findById(Integer id) throws Exception {
        if(id == 0){
            throw new Exception("El Id es obligatorio");
        }
        return DAOFactory.getKeyRoomDAO().findById(id);
    }
}
