/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._segunda_java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 823212382
 */
public class DAO {
    public boolean exists(String user, String password) throws Exception {
        String sql = "SELECT * FROM users WHERE user = ? AND password = ?";
            try (Connection conn = ConnectionFactory.conectar();
               PreparedStatement ps = conn.prepareStatement(sql)){
                   ps.setString(1, user);
                   ps.setString(2, password);
                   try (ResultSet rs = ps.executeQuery()){
                   return rs.next();
           }
        }
    }
}
