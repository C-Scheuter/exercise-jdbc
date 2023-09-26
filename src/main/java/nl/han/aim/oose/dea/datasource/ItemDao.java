package nl.han.aim.oose.dea.datasource;

import nl.han.aim.oose.dea.datasource.util.DatabaseProperties;
import nl.han.aim.oose.dea.domain.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    private DatabaseProperties databaseProperties;

    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            Statement statement = connection.prepareStatement("SELECT * from items");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Item item = new Item(resultSet.getString("", resultSet.getString(""), resultSet.getString("")));
                items.add(item);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {

        }
        return items;
    }
}
