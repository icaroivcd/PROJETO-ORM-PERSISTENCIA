/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Ícaro Viníciua &lt;Ícaro Vinícius at ifnmg.edu.br&gt;
 */
public interface IDao<E> {
    
    
    public String getSaveStatment();

    public String getUpdateStatment();
    
    public String getFindByIdStatment();
    
    public String getFindAllStatment();
    
    public String getDeleteStatment();

    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, E e);
    
    public E extractObject(ResultSet resultSet);

    public List<E> extractObjects(ResultSet resultSet);

    public Long saveOrUpdate(E e);

    public E findById(Long id);

    public List<E> findAll();

    public void delete(Long id);
    

    
    
    
}
