/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.edu.ifnmg.atividade_iii;

import book.BookDao;
import book.Book;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Ícaro Viníciua &lt;Ícaro Vinícius at ifnmg.edu.br&gt;
 */
public class Main {

    public static void main(String[] args) throws Exception {
      
            try {

           //<editor-fold defaultstate="collapsed" desc="Cria livros">
                // Criar e salvar o primeiro livro com data posterior a data de hoje
                Book livro0 = new Book(null, "Livro de Teste 1", "Autor de Teste 1", LocalDate.of(2023, Month.DECEMBER, 12), (short) 125, (short) 1093, (byte) 20, new BigDecimal("10.20"));;
                Long livro0ID = new BookDao().saveOrUpdate(livro0);
                livro0.setId(livro0ID);
            } catch (Exception e) {
                System.out.println(">> " + e.getMessage());
            }

            // Criar e salvar o primeiro livro
            Book livro1 = new Book(null, "Livro de Teste 1", "Autor de Teste 1", LocalDate.of(2023, Month.APRIL, 10), (short) 150, (short) 2010, (byte) 7, new BigDecimal("30.99"));;
            Long livro1ID = new BookDao().saveOrUpdate(livro1);
            livro1.setId(livro1ID);

            // Criar e salvar o segundo livro
            Book livro2 = new Book(null, "Livro de Teste 2", "Autor de Teste 2", LocalDate.of(2023, Month.JUNE, 5), (short) 300, (short) 2020, (byte) 2, new BigDecimal("25.50"));
            Long livro2ID = new BookDao().saveOrUpdate(livro2);
            livro2.setId(livro2ID);

            // Criar e salvar o terceiro livro
            Book livro3 = new Book(null, "Livro de Teste 3", "Autor de Teste 2", LocalDate.of(2023, Month.AUGUST, 3), (short) 320, (short) 1093, (byte) 20, new BigDecimal("10.20"));
            Long livro3ID = new BookDao().saveOrUpdate(livro3);
            livro3.setId(livro3ID);

            //</editor-fold>
            
           //<editor-fold defaultstate="collapsed" desc="Atualiza livro 1">
           
            Book livro1Aux = new BookDao().findById(livro1ID);
            System.out.println("\nBusca Antigo: " + livro1Aux);

            livro1Aux.setTitle("Atualização do livro 1");
            new BookDao().saveOrUpdate(livro1Aux);
            System.out.println(">> Livro 1 foi atulizado\n");
            
            //</editor-fold>
            
           //<editor-fold defaultstate="collapsed" desc="Busca 2 livros por ID">
            
           System.out.println("2 LIVROS BUSCADOS: \n");
           
            BookDao BuscaId = new BookDao();
            System.out.println(">> "+BuscaId.findById(livro3ID) );
            
            BookDao BuscaId2 = new BookDao();
            System.out.println(">> "+BuscaId2.findById(livro2ID) );
            
            //</editor-fold>
           
           //<editor-fold defaultstate="collapsed" desc="Carga de todos os livros">
 
           System.out.println("\n>> TODOS OS LIVROS DO BD");
             try {
            BookDao BuscaTodos = new BookDao();
            for(Book e: BuscaTodos.findAll()){
                System.out.println(">> "+e);
                
             //</editor-fold>
            
           //<editor-fold defaultstate="collapsed" desc="Remoção do livro 2">
            
             BookDao deleteLivro = new BookDao();
             deleteLivro.delete(livro2ID);
             
           //</editor-fold>
 
             
             
            }       
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}



            

            
            

