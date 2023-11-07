/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entity.Entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Ícaro Viníciua &lt;Ícaro Vinícius at ifnmg.edu.br&gt;
 */
public abstract class Dao<E> implements IDao<E> {
    
    public static final String DB = "library";
    

    @Override
    public Long saveOrUpdate(E e) {

        // Primary key
        Long id = 0L;

        if (((Entity) e).getId() == null || ((Entity) e).getId() == 0) {

            
            try ( PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement( getSaveStatment(),Statement.RETURN_GENERATED_KEYS)) {

                composeSaveOrUpdateStatement(preparedStatement, e);

                System.out.println(">> SQL: " + preparedStatement);

                preparedStatement.executeUpdate();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                // Moves to first retrieved data
                if (resultSet.next()) {

                    
                    id = resultSet.getLong(1);
                }

            } catch (Exception ex) {
                System.out.println(">> " + ex);
            }

        } else {
            // Update existing record
            try ( PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(
                            getUpdateStatment())) {

                // Assemble the SQL statement with the data (->?)
                composeSaveOrUpdateStatement(preparedStatement, e);

                // Show the full sentence
                System.out.println(">> SQL: " + preparedStatement);

                // Performs the update on the database
                preparedStatement.executeUpdate();

                // Keep the primary key
                id = ((Entity) e).getId();

            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
        return id;
    } 
    
    
    @Override
    public E findById(Long id) {
        try ( PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement( getFindByIdStatment())) {

            
            preparedStatement.setLong(1, id);

            
            System.out.println(">> SQL: " + preparedStatement);

            
            ResultSet resultSet = preparedStatement.executeQuery();

            
            if (resultSet.next()) {
                return extractObject(resultSet);
            }

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null;
    } 
    

    @Override
    public List<E> findAll() {
        try ( PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(getFindAllStatment())) {

            
            System.out.println(">> SQL: " + preparedStatement);

            
            ResultSet resultSet = preparedStatement.executeQuery();

            
            return extractObjects(resultSet);

        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }

        return null; 
    }
    
    @Override
    public void delete(Long id) {
        
        try (PreparedStatement preparedStatement = ConnectionDB.getConnection().prepareStatement(getDeleteStatment())) {
        // Set the ID of the entity to be deleted in the DELETE statement
        preparedStatement.setLong(1, id);

        System.out.println(">> SQL: " + preparedStatement);

        // Execute the DELETE statement
        preparedStatement.executeUpdate();

    } catch (Exception ex) {
        System.out.println("Exception: " + ex);
    }
         
    }
     
}
