package eav.manager;

import eav.model.Object;
import eav.queries.ObjectQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjectManager {

    private static final String OBJECT_ID = "OBJECT_ID";
    private static final String PARENT_ID = "PARENT_ID";
    private static final String OBJECT_TYPE_ID = "OBJECT_TYPE_ID";
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";

    private Connection connection;

    public ObjectManager(Connection connection) {
        this.connection = connection;
    }

    public void createObject(Object object) throws SQLException {

        if (object.getParentId() != null) {
            PreparedStatement preparedStatement = connection.prepareStatement(ObjectQueries.INSERT_NEW_OBJECT);
            preparedStatement.setLong(1, object.getObjectId());
            preparedStatement.setLong(2, object.getParentId());
            preparedStatement.setLong(3, object.getObjectTypeId());
            preparedStatement.setString(4, object.getName());
            preparedStatement.setString(5, object.getDescription());
            preparedStatement.execute();
        } else {
            PreparedStatement preparedStatement = connection.prepareStatement(ObjectQueries.INSERT_NEW_OBJECT_WITHOUT_PARENT_ID);
            preparedStatement.setLong(1, object.getObjectId());
            preparedStatement.setLong(2, object.getObjectTypeId());
            preparedStatement.setString(3, object.getName());
            preparedStatement.setString(4, object.getDescription());
            preparedStatement.execute();
        }

        connection.close();
    }

    public List<Object> getAllObjects() throws SQLException {

        List<Object> objects = new ArrayList<Object>();

        PreparedStatement preparedStatement = connection.prepareStatement(ObjectQueries.SELECT_ALL_OBJECTS);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Object object = new Object();
            object.setObjectId(resultSet.getLong(OBJECT_ID));
            object.setParentId(resultSet.getLong(PARENT_ID));
            object.setObjectTypeId(resultSet.getLong(OBJECT_TYPE_ID));
            object.setName(resultSet.getString(NAME));
            object.setDescription(resultSet.getString(DESCRIPTION));
        }

        connection.close();
        return objects;
    }

    public Object getObjectById(Long objectId) throws SQLException {

        Object object = new Object();
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectQueries.SELECT_OBJECT_BY_OBJECT_ID);
        preparedStatement.setLong(1, objectId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            object.setObjectId(resultSet.getLong(OBJECT_ID));
            object.setParentId(resultSet.getLong(PARENT_ID));
            object.setObjectTypeId(resultSet.getLong(OBJECT_TYPE_ID));
            object.setName(resultSet.getString(NAME));
            object.setDescription(resultSet.getString(DESCRIPTION));
        }

        connection.close();
        return object;
    }

    public List<Object> getObjectsByObjectTypeId(Long objectTypeId) throws SQLException {

        List<Object> objects = new ArrayList<Object>();

        PreparedStatement preparedStatement = connection.prepareStatement(ObjectQueries.SELECT_OBJECTS_BY_OBJECT_TYPE_ID);
        preparedStatement.setLong(1, objectTypeId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Object object = new Object();
            object.setObjectId(resultSet.getLong(OBJECT_ID));
            object.setParentId(resultSet.getLong(PARENT_ID));
            object.setObjectTypeId(resultSet.getLong(OBJECT_TYPE_ID));
            object.setName(resultSet.getString(NAME));
            object.setDescription(resultSet.getString(DESCRIPTION));
        }

        connection.close();
        return objects;
    }

    public List<Object> getObjectsByParentId(Long parentId) throws SQLException {

        List<Object> objects = new ArrayList<Object>();

        PreparedStatement preparedStatement = connection.prepareStatement(ObjectQueries.SELECT_OBJECTS_BY_PARENT_ID);
        preparedStatement.setLong(1, parentId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Object object = new Object();
            object.setObjectId(resultSet.getLong(OBJECT_ID));
            object.setParentId(resultSet.getLong(PARENT_ID));
            object.setObjectTypeId(resultSet.getLong(OBJECT_TYPE_ID));
            object.setName(resultSet.getString(NAME));
            object.setDescription(resultSet.getString(DESCRIPTION));
        }

        connection.close();
        return objects;
    }

    public void updateObjectById(Object object, Long objectId) throws SQLException {

        if (object.getParentId() != null) {
            PreparedStatement preparedStatement = connection.prepareStatement(ObjectQueries.UPDATE_OBJECT_BY_ID);
            preparedStatement.setLong(1, object.getParentId());
            preparedStatement.setLong(2, object.getObjectTypeId());
            preparedStatement.setString(3, object.getName());
            preparedStatement.setString(4, object.getDescription());
            preparedStatement.setLong(5, objectId);
            preparedStatement.execute();
        } else {
            PreparedStatement preparedStatement = connection.prepareStatement(ObjectQueries.UPDATE_OBJECT_BY_ID_WITHOUT_PARENT_ID);
            preparedStatement.setLong(1, object.getObjectTypeId());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setString(3, object.getDescription());
            preparedStatement.setLong(4, objectId);
            preparedStatement.execute();
        }

        connection.close();
    }

    public void deleteObjectById(Long objectId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectQueries.DELETE_OBJECT_BY_ID);
        preparedStatement.setLong(1, objectId);

        preparedStatement.execute();
        connection.close();
    }

    public void deleteObjectsByParentId(Long parentId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectQueries.DELETE_OBJECTS_BY_PARENT_ID);
        preparedStatement.setLong(1, parentId);

        preparedStatement.execute();
        connection.close();
    }

    public void deleteObjectsByObjectTypeId(Long objectTypeId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectQueries.DELETE_OBJECTS_BY_OBJECT_TYPE_ID);
        preparedStatement.setLong(1, objectTypeId);

        preparedStatement.execute();
        connection.close();
    }


}
