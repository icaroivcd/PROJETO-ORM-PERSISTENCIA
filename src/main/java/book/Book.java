/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;

import entity.Entity;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author Ícaro Viníciua &lt;Ícaro Vinícius at ifnmg.edu.br&gt;
 */
public class Book extends Entity{
    
    private String title;
    private String authors;
    private LocalDate acquisition;
    private Short pages;
    private Short year;
    private Byte edition;
    private BigDecimal price;

    public Book() {
    }

    public Book(Long id,String title, String authors, LocalDate acquisition, Short pages, Short year, Byte edition, BigDecimal price) throws Exception {
        
        setId(id);
        setTitle(title);
        setAuthors(authors);
        setAcquisition(acquisition);
        setPages(pages);
        setYear(year);
        setEdition(edition);
        setPrice(price);
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {
        if(title.length()>150){
            throw new Exception("Tamanho inválido");
        }
                this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) throws Exception {
        if(authors.length()>250){
            throw new Exception("Tamanho inválido");
        }
        this.authors = authors;
    }

    public LocalDate getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(LocalDate acquisition) throws Exception {
        if(acquisition.isBefore(LocalDate.now())) this.acquisition = acquisition;
        else throw new DateTimeException("Data invalida!");
    }

    public Short getPages() {
        return pages;
    }

    public void setPages(Short pages) throws Exception {
        if(pages<1){
            throw new Exception ("Quantidade inválida");
        }
        this.pages = pages;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) throws Exception{
        if(year==null){
          throw new Exception("Ano inválido");
        }
        this.year = year;
    }

    public Byte getEdition() {
        return edition;
    }

    public void setEdition(Byte edition) throws Exception {
        if(edition<1){
            throw new Exception("Tamanho inválido");
        }
        this.edition = edition;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws Exception {
        if(price.compareTo(BigDecimal.ZERO)<0){
            throw new Exception ("Preço inválido");
    }
        this.price = price;
    }
    
    
    //</editor-fold>

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", authors=" + authors + ", acquisition=" + acquisition + ", pages=" + pages + ", year=" + year + ", edition=" + edition + ", price=" + price + '}';
    }
    
 
    
    
    
}
