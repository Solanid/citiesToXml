import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Solanid on 22.5.2017.
 */
public class DBSConnectionProvider {
    private static final String USERNAME ="root";
    private static final String PASSWORD ="";
    private static final String DBNAME ="world_x";
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private Connection getConnection() {
        Connection conn=null;
        try{
            conn = DriverManager.getConnection(URL+DBNAME, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.toString());
        }
        return conn;
    }

    public List<City> getCity() {
        String query = "SELECT * FROM city LIMIT 500";
        List<City> cities = new ArrayList<>();
        Connection conn = getConnection();
        if (conn != null) {
            try(Statement statement = conn.createStatement()) {
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    City city = new City(rs.getInt("id"), rs.getString("name"), rs.getString("countryCode"), rs.getString("district"));
                    cities.add(city);
                }
                conn.close();
            } catch(SQLException ex) {
                System.err.println("getCity ERROR: "+ex.toString());
            }
        }
        return cities;
    }
}
