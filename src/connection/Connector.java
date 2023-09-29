package connection;

import java.sql.Statement;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public void connect (){
        try {
            tryConnect();
        } catch (SQLException e) {
            System.err.println("Nem sikerült létesíteni a kapcsolatot");
            System.err.println(e.getMessage());
        }catch(ClassNotFoundException f){
            System.err.println("Nem található a JDBC csomag.");
            System.err.println(f.getMessage());
        }catch(FileNotFoundException g){
            System.err.println("Nem található a file.");
            System.err.println(g.getMessage());
        }
    }
    public void tryConnect() throws SQLException, ClassNotFoundException,FileNotFoundException{
        Class.forName("org.sqlite.JDBC");
        if(!(new File("sikidomok.db")).exists()){
            Connection conn = DriverManager.getConnection("jdbc:sqlite:sikidomok.db");
            Statement create = conn.createStatement();
            FileInputStream fis = new FileInputStream("letrehozasok.sql");
            Scanner sc = new Scanner(fis);
            String sz="";
            while(sc.hasNextLine()){
                sz+=sc.nextLine();
                if(sz.endsWith(";")){
                    create.execute(sz);
                    sz="";
                }
            }
            sc.close();
        }
        
        System.out.println("Sikeres kapcsolódás az sq-lite szerverre.");  
    }
}
