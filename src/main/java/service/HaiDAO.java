package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

@Data
public class HaiDAO {
    private Driver driver;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;
    private ResultSet resultSet;
    public HaiDAO(){
        driver=new OracleDriver();
        try {
            DriverManager.registerDriver(driver);
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
            System.out.println("Oracle Connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ListHai every(){
        ListHai listHai=new ListHai();
        try {
            query="select * from hai";
            preparedStatement= connection.prepareStatement(query);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                Hai hai=new Hai();
                hai.setId(resultSet.getInt("id"));
                hai.setName(resultSet.getString("name"));
                hai.setPrice(resultSet.getInt("price"));
                listHai.getList().add(hai);
            }
            connection.close();
            return listHai;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String insert(Hai hai){
        try {
            query="insert into hai values(hai_seq.nextval,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,hai.getName());
            preparedStatement.setInt(2,hai.getPrice());
            int ack=preparedStatement.executeUpdate();
            if(ack>0){
                connection.close();
                return hai.getName()+" has inserted";
            }
            else {
                connection.close();
                return hai.getName() + " hasn't inserted";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
