package db;

import beans.Entry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {
    static final String DB_URL = "jdbc:mysql://localhost:3306/entries?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    

    private Connection conn = null;
    private Statement st;
    private boolean connected = false;

    public DbConnection(){

    }

    public boolean connect() throws ClassNotFoundException{
        if (!isConnected()){
            Class.forName("com.mysql.jdbc.Driver"); 
            try{
                conn = DriverManager.getConnection(DB_URL, "root", "root");
                st = conn.createStatement();
                connected = true;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
       return connected;
    }

    private boolean isConnected(){
        return connected;
    }

    public List<Entry> selectDataByWord(String word){
        List<Entry> entries  = new ArrayList<Entry>();
        if (isConnected()){
            try {
                ResultSet resultSet = st.executeQuery("SELECT * FROM entries WHERE word = '"+word+"'");
                while (resultSet.next()){
                    entries.add(new Entry(resultSet.getString("word")
                            , resultSet.getString("wordType")
                            ,resultSet.getString("definition")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return entries;
    }
}
