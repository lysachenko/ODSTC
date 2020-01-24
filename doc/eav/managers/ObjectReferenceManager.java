package eav.manager;

import eav.model.ObjectReference;
import eav.queries.ObjectReferenceQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjectReferenceManager {

    public static final String ATTR_ID = "ATTR_ID";
    public static final String REFERENCE = "REFERENCE";
    public static final String OBJECT_ID = "OBJECT_ID";

    private Connection connection;

    public ObjectReferenceManager(Connection connection) {
        this.connection = connection;
    }

    public void createObjectReference(ObjectReference objectReference) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.INSERT_NEW_OBJECT_REFERENCE);
        preparedStatement.setLong(1, objectReference.getAttrId());
        preparedStatement.setLong(2, objectReference.getReference());
        preparedStatement.setLong(3, objectReference.getObjectId());
        preparedStatement.execute();

        connection.close();
    }

    public List<ObjectReference> getObjectReferencesByAttrId(Long attrId) throws SQLException {

        List<ObjectReference> objectReferences = new ArrayList<ObjectReference>();
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.SELECT_OBJECT_REFERENCE_BY_ATTR_ID);
        preparedStatement.setLong(1, attrId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            ObjectReference objectReference = new ObjectReference();
            objectReference.setAttrId(resultSet.getLong(ATTR_ID));
            objectReference.setReference(resultSet.getLong(REFERENCE));
            objectReference.setObjectId(resultSet.getLong(OBJECT_ID));

            objectReferences.add(objectReference);
        }

        connection.close();
        return objectReferences;
    }

    public List<ObjectReference> getObjectReferencesByReference(Long referenceId) throws SQLException {

        List<ObjectReference> objectReferences = new ArrayList<ObjectReference>();
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.SELECT_OBJECT_REFERENCE_BY_REFERENCE);
        preparedStatement.setLong(1, referenceId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            ObjectReference objectReference = new ObjectReference();
            objectReference.setAttrId(resultSet.getLong(ATTR_ID));
            objectReference.setReference(resultSet.getLong(REFERENCE));
            objectReference.setObjectId(resultSet.getLong(OBJECT_ID));

            objectReferences.add(objectReference);
        }

        connection.close();
        return objectReferences;
    }

    public List<ObjectReference> getObjectReferencesByObjectId(Long objectId) throws SQLException {

        List<ObjectReference> objectReferences = new ArrayList<ObjectReference>();
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.SELECT_OBJECT_REFERENCE_BY_OBJECT_ID);
        preparedStatement.setLong(1, objectId);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            ObjectReference objectReference = new ObjectReference();
            objectReference.setAttrId(resultSet.getLong(ATTR_ID));
            objectReference.setReference(resultSet.getLong(REFERENCE));
            objectReference.setObjectId(resultSet.getLong(OBJECT_ID));

            objectReferences.add(objectReference);
        }

        connection.close();
        return objectReferences;
    }

    public void updateObjectReferenceByAttrId(ObjectReference objectReference, Long attrId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.UPDATE_OBJECT_REFERENCE_BY_ATTR_ID);
        preparedStatement.setLong(1, objectReference.getAttrId());
        preparedStatement.setLong(2, objectReference.getReference());
        preparedStatement.setLong(3, objectReference.getObjectId());
        preparedStatement.setLong(4, attrId);

        preparedStatement.execute();

        connection.close();
    }

    public void updateObjectReferenceByReference(ObjectReference objectReference, Long referenceId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.UPDATE_OBJECT_REFERENCE_BY_REFERENCE);
        preparedStatement.setLong(1, objectReference.getAttrId());
        preparedStatement.setLong(2, objectReference.getReference());
        preparedStatement.setLong(3, objectReference.getObjectId());
        preparedStatement.setLong(4, referenceId);

        preparedStatement.execute();

        connection.close();
    }

    public void updateObjectReferenceByObjectId(ObjectReference objectReference, Long objectId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.UPDATE_OBJECT_REFERENCE_BY_OBJECT_ID);
        preparedStatement.setLong(1, objectReference.getAttrId());
        preparedStatement.setLong(2, objectReference.getReference());
        preparedStatement.setLong(3, objectReference.getObjectId());
        preparedStatement.setLong(4, objectId);

        preparedStatement.execute();

        connection.close();
    }

    public void deleteObjectReferenceByAttrId(Long attrId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.DELETE_OBJECT_REFERENCE_BY_ATTR_ID);
        preparedStatement.setLong(1, attrId);

        preparedStatement.execute();
        connection.close();
    }

    public void deleteObjectReferenceByReference(Long referenceId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.DELETE_OBJECT_REFERENCE_BY_REFERENCE);
        preparedStatement.setLong(1, referenceId);

        preparedStatement.execute();
        connection.close();
    }

    public void deleteObjectReferenceByObjectId(Long objectId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.DELETE_OBJECT_REFERENCE_BY_OBJECT_ID);
        preparedStatement.setLong(1, objectId);

        preparedStatement.execute();
        connection.close();
    }

}
