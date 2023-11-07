/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.Dao;

/**
 *
 * @author Ícaro Viníciua &lt;Ícaro Vinícius at ifnmg.edu.br&gt;
 */
public class BookDao extends Dao<Book>{
    
    public static final String TABLE = "book";

    @Override
    public String getSaveStatment() {
        return "insert into " + TABLE + "(titulo, autor, aquisição, páginas, ano, edição, preço) values(?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateStatment() {
        return " update "+ TABLE + " set titulo = ?, autor = ?, aquisição = ?, páginas = ?, ano = ?, edição = ?, preço = ? where id = ?";
    }

    @Override
    public String getFindByIdStatment() {
        return "select id, titulo, autor, aquisição, páginas, ano, edição, preço" + " from book where id = ?"; 
    }

    @Override
    public String getFindAllStatment() {
        return "select id, titulo, autor, aquisição, páginas, ano, edição, preço" + " from book";
    }

    @Override
    public String getDeleteStatment() {
         return "Delete from " + TABLE + " where id = ?";
    }

    @Override
    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, Book e) {
    try {
        pstmt.setString(1, e.getTitle());
        pstmt.setString(2, e.getAuthors());
        pstmt.setObject(3, e.getAcquisition());
        pstmt.setShort(4, e.getPages());
        pstmt.setShort(5, e.getYear());
        pstmt.setByte(6, e.getEdition());
        pstmt.setBigDecimal(7, e.getPrice());

        // Se for uma atualização (update), você também precisa definir o ID.
        if (e.getId() != null) {
            pstmt.setLong(8, e.getId());
        }
    } catch (SQLException ex) {
        Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public Book extractObject(ResultSet resultSet) {

        Book book = null;

        try {
            book = new Book();
            book.setId(resultSet.getLong("id"));
            book.setTitle(resultSet.getString("titulo"));
            book.setAuthors(resultSet.getString("autor"));
            book.setAcquisition( resultSet.getObject("aquisição", LocalDate.class));
            book.setPages(resultSet.getShort("páginas"));
            book.setYear(resultSet.getShort("ano"));
            book.setEdition(resultSet.getByte("edição"));
            book.setPrice(resultSet.getBigDecimal("preço"));
        }catch (Exception ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return book;
    }


    @Override
public List<Book> extractObjects(ResultSet resultSet) {
    List<Book> bookList = new ArrayList<>();

    try {
        while (resultSet.next()) {
            Book book = new Book();
            book.setId(resultSet.getLong("id"));
            book.setTitle(resultSet.getString("titulo"));
            book.setAuthors(resultSet.getString("autor"));
            book.setAcquisition(resultSet.getObject("aquisição", LocalDate.class));
            book.setPages(resultSet.getShort("páginas"));
            book.setYear(resultSet.getShort("ano"));
            book.setEdition(resultSet.getByte("edição"));
            book.setPrice(resultSet.getBigDecimal("preço"));
            bookList.add(book);
        }
    } catch (Exception ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    return bookList;
}
  
}


