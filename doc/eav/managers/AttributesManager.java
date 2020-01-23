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

    public AttributesManager(Connection connection) {
        this.connection = connection;
    }

    public void createAttribute(Attribute attribute) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(AttributeQueries.INSERT_NEW_ATTRIBUTE);
        preparedStatement.setLong(1, attribute.getAttributeTypeId());
        preparedStatement.setLong(2, attribute.getObjectId());
        preparedStatement.setString(3, attribute.getValue());
        preparedStatement.setDate(4, attribute.getDate());
        preparedStatement.execute();

        connection.close();
    }

    public Attribute getAttributeById(Long attrId) throws SQLException {

        Attribute attribute = new Attribute();
        PreparedStatement preparedStatement = connection.prepareStatement(AttributeQueries.SELECT_ATTRIBUTES_BY_ATTR_ID);
        preparedStatement.setLong(1, attrId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            attribute.setAttributeTypeId(resultSet.getLong(ATTR_ID));
            attribute.setObjectId(resultSet.getLong(OBJECT_ID));
            attribute.setValue(resultSet.getString(VALUE));
            attribute.setDate(resultSet.getDate(DATE_VALUE));
        }

        connection.close();
        return attribute;
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

        connection.close();
        return attributes;
    }

    public void updateAttributeByObjectIdAndAttrId(Attribute attribute, Long objectId, Long attrId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(AttributeQueries.UPDATE_ATTRIBUTE_BY_OBJECT_ID_AND_ATTR_ID);
        preparedStatement.setLong(1, attribute.getObjectId());
        preparedStatement.setString(2, attribute.getValue());
        preparedStatement.setDate(3, attribute.getDate());
        preparedStatement.setLong(4, objectId);
        preparedStatement.setLong(5, attrId);
        preparedStatement.execute();

        connection.close();
    }

    public void updateAttributeValueByObjectIdAndAttrId(Attribute attribute, Long objectId, Long attrId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(AttributeQueries.UPDATE_ATTRIBUTE_VALUE_BY_OBJECT_ID_AND_ATTR_ID);

        preparedStatement.setString(1, attribute.getValue());
        preparedStatement.setLong(2, objectId);
        preparedStatement.setLong(3, attrId);
        preparedStatement.execute();

        connection.close();
    }

    public void updateAttributeDateValueByObjectIdAndAttrId(Attribute attribute, Long objectId, Long attrId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(AttributeQueries.UPDATE_ATTRIBUTE_DATE_VALUE_BY_OBJECT_ID_AND_ATTR_ID);

        preparedStatement.setDate(1, attribute.getDate());
        preparedStatement.setLong(2, objectId);
        preparedStatement.setLong(3, attrId);
        preparedStatement.execute();

        connection.close();
    }

    public void deleteAttributeByAttributeId(Long attrId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(AttributeQueries.DELETE_ATTRIBUTES_BY_ATTR_ID);
        preparedStatement.setLong(1, attrId);

        preparedStatement.execute();
        connection.close();
    }

    public void deleteAttributeByObjectId(Long objectId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(AttributeQueries.DELETE_ATTRIBUTES_BY_OBJECT_ID);
        preparedStatement.setLong(1, objectId);

        preparedStatement.execute();
        connection.close();
    }

    public void deleteAttributeByObjectIdAndAttributeId(Long objectId, Long attrId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(AttributeQueries.DELETE_ATTRIBUTES_BY_OBJECT_ID_AND_ATTR_ID);
        preparedStatement.setLong(1, objectId);
        preparedStatement.setLong(2, attrId);

        preparedStatement.execute();
        connection.close();
    }

}
