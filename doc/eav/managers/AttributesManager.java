package eav.manager;

import eav.model.Attribute;
import eav.queries.AttributeQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttributesManager {

    public static final String ATTR_ID = "ATTR_ID";
    public static final String OBJECT_ID = "OBJECT_ID";
    public static final String VALUE = "VALUE";
    public static final String DATE_VALUE = "DATE_VALUE";

    private Connection connection;

    public AttributesManager(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public void createAttribute(Attribute attribute) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(AttributeQueries.INSERT_NEW_ATTRIBUTE);
        preparedStatement.setLong(1, attribute.getAttributeTypeId());
        preparedStatement.setLong(2, attribute.getObjectId());
        preparedStatement.setString(3, attribute.getValue());
        preparedStatement.setDate(4, attribute.getDate());
        preparedStatement.execute();
    }

    public List<Attribute> getAttributesByObjectId(Long objectId) throws SQLException {

        List<Attribute> attributes = new ArrayList<Attribute>();
        PreparedStatement preparedStatement = connection.prepareStatement(AttributeQueries.SELECT_ATTRIBUTES_BY_OBJECT_ID);
        preparedStatement.setLong(1, objectId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Attribute attribute = new Attribute();
            attribute.setAttributeTypeId(resultSet.getLong(ATTR_ID));
            attribute.setObjectId(resultSet.getLong(OBJECT_ID));
            attribute.setValue(resultSet.getString(VALUE));
            attribute.setDate(resultSet.getDate(DATE_VALUE));
            attributes.add(attribute);
        }
        return attributes;
    }

    public void updateAttributeByObjectId(Attribute attribute, Long objectId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(AttributeQueries.UPDATE_ATTRIBUTES_BY_OBJECT_ID);
        preparedStatement.setString(1, attribute.getValue());
        preparedStatement.setDate(2, attribute.getDate());
        preparedStatement.setLong(3, objectId);
        preparedStatement.setLong(4, attribute.getAttributeTypeId());
        preparedStatement.execute();
    }

    public void deleteAttributeByObjectId(Long objectId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(AttributeQueries.DELETE_ATTRIBUTES_BY_OBJECT_ID);
        preparedStatement.setLong(1, objectId);

        preparedStatement.execute();
    }

}
