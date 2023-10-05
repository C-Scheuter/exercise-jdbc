package nl.han.aim.oose.dea;

import nl.han.aim.oose.dea.datasource.ItemDao;
import nl.han.aim.oose.dea.datasource.util.DatabaseProperties;
import nl.han.aim.oose.dea.domain.Item;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class JdbcApp {
    public static void main(String[] args) throws IOException {
        ItemDao itemDao = new ItemDao(new DatabaseProperties());
        DatabaseProperties DP = new DatabaseProperties();

        System.out.println(DP.connectionString());
        System.out.println(DP.driver());

//        getAllTheItems();
        printAllItems(itemDao);
    }


    private static void printAllItems(ItemDao itemDao) {
        List<Item> items = itemDao.findAll();
        for (Item item : items)
            System.out.println(item);
    }
//    public List<Item> getAllTheItems() throws SQLException {
//        DatabaseProperties databaseProperties = new DatabaseProperties();
//
//        Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
//        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM items");
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()){
//            String string = resultSet.getString(1);
//            System.out.println(string);;
//        }
//    }
}
