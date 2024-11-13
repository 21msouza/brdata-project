package com.mycompany.brdataconnect;

import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFac { // Com finalidade de organização, foi feito um package só pra conectar pro banco de dados
    public static java.sql.Connection connectionDB() throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/players", "root", "");
            return conexao;        
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        
        java.sql.Connection con = connectionDB();
        
        if(con!=null){
            con.close();
        }
        
    }
}
