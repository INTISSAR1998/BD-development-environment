/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Red
 */
public class DBUtilities {
    private static Connection con = null;
    public static Connection Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniProjet","root","");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public void addBook(Book book){
        try {
            Connection con = DBUtilities.Connect();
            System.out.println(book.getCode());
            String query = "insert into books values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, book.getCode());
            ps.setString(2, book.getNomAuteur());
            ps.setString(3, book.getPrenomAuteur());
            ps.setString(4, book.getTitre());
            ps.setString(5, book.getCategorie());
            ps.setString(6, book.getIsbn());
            int nb = ps.executeUpdate();
            if (nb ==1 ) {
                System.out.println("insertion succeeded !!!");
            }else
                System.out.println("insertion failed !!!");
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifyBook(String code, Book book){
        try {
            Connection con = DBUtilities.Connect();
            System.out.println(book.getCode());
            String query = "update books set titre = ?, nomAuteur=?,prenomAuteur=?,categorie=?,isbn=? where code = ? ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, book.getTitre());
            System.out.println(book.getTitre());
            ps.setString(2, book.getNomAuteur());
            System.out.println(book.getNomAuteur());
            ps.setString(3, book.getPrenomAuteur());
            ps.setString(4, book.getCategorie());
            ps.setString(5, book.getIsbn());
            ps.setString(6, code);
            int nb = ps.executeUpdate();
            if (nb ==1 ) {
                System.out.println("insertion succeeded !!!");
            }else
                System.out.println("insertion failed !!!");
            query = "update books set code = ? where code = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, book.getCode());
            ps.setString(2, code);
            nb = ps.executeUpdate();
            if (nb ==1 ) {
                System.out.println("nice !!!");
            }else
                System.out.println("not nice !!!");
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteBook(String code){
        try {
            Connection con = DBUtilities.Connect();
            
            String query = "delete from books where code = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, code);
            int nb = ps.executeUpdate();
            if (nb ==1 ) {
                System.out.println("delete succeeded !!!");
            }else
                System.out.println("delete failed !!!");
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fillTable(JTable table){
     
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String[] row = new String[6];
        Connection connection = DBUtilities.Connect();
        String query = "select * from books";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                row[0] = rs.getString(6);
                row[1] = rs.getString(4);
                row[5] = rs.getString(1);
                row[2] = rs.getString(2);
                row[3] = rs.getString(3);
                row[4] = rs.getString(5);
                model.addRow(row);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
