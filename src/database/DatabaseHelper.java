package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import subject.Abonent;

public class DatabaseHelper {
    private static final String SQL_INSERT = "INSERT INTO Abonents (Lastname, Phone) VALUES (?, ?)";
    private final Connection connection;

    public DatabaseHelper() {
        connection = DatabaseConnector.getInstance().getConnection();
    }

    public PreparedStatement getPreparedStatement() {
        try {
            return connection.prepareStatement(SQL_INSERT);
        }
        catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public boolean insertAbonent(PreparedStatement preparedStatement, Abonent abonent){
        boolean flag = false;
        try {
            preparedStatement.setString(1, abonent.getName());
            preparedStatement.setString(2, abonent.getPhone());
            preparedStatement.executeUpdate();
            flag = true;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return flag;
    }

    public void closePrepareStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            }
            catch(SQLException exception) {
                exception.printStackTrace();
            }
        }
    }
}
