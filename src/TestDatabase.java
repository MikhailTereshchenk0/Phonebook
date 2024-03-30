import subject.Abonent;
import database.DatabaseHelper;

import java.sql.PreparedStatement;

public class TestDatabase {
    public static void main(String[] args) {
        Abonent a1 = new Abonent(1, "Mike", "+375447909904");
        DatabaseHelper databaseHelper = new DatabaseHelper();
        PreparedStatement preparedStatement = databaseHelper.getPreparedStatement();
        boolean is_added = databaseHelper.insertAbonent(preparedStatement, a1);
        System.out.println(is_added);
        databaseHelper.closePrepareStatement(preparedStatement);
    }
}