/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._segunda_java;

import java.sql.Connection;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.DriverManager;

public class ConnectionFactory {
    // Preencher com informações do Aiven
    private static Dotenv dotenv = Dotenv.configure().load();
    private static final String host = dotenv.get("HOST");
    private static final String port = dotenv.get("PORT");
    private static final String user = dotenv.get("USER");
    private static final String password = dotenv.get("PASSWORD");
    private static final String db = dotenv.get("DB");
    private static final String engine = dotenv.get("ENGINE");
    private static final String ssl = dotenv.get("SSL");
    private static String s;

    public static Connection conectar() throws Exception {
        // http://dontpad.com:80/bossini
        // String de conexão
        // String s = "jdbc:mysql://" + host + ":" + port + "/" + db;
        s = String.format(
            "jdbc:%s://%s:%s/%s?ssl=%s",
            engine, host, port, db, ssl
        );

        Connection c = DriverManager.getConnection(
            s,
            user,
            password
        );

        return c;
    }

    public static void main(String[] args) throws Exception {
        var fabrica = new ConnectionFactory();
        System.out.println(conectar());
    }

}