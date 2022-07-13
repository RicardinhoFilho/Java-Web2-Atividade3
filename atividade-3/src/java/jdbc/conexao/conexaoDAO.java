/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class conexaoDAO {
     public  Connection conectaDB(){
        Connection conn = null;
        
        try{
            //String url = "jdbc:mysql://localhost:3306/trabalho_lpoo2?user=root&password=root&useSSL=true";
            Class.forName("com.mysql.jdbc.Driver"); /* Aqui registra */
            String url = "jdbc:mysql://localhost:3306/java_atividade_3?user=root&password=teste&useSSL=false";
            conn = DriverManager.getConnection(url);
        }catch(SQLException error){
          System.out.println(error);
        }
        return conn;   
    }
}
