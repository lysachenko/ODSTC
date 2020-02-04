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

    public ObjectReferenceManager(Connection connection) throws SQLException {
        this.connection = connection;
    }

    public void createObjectReference(ObjectReference objectReference) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.INSERT_NEW_OBJECT_REFERENCE);
        preparedStatement.setLong(1, objectReference.getAttrId());
        preparedStatement.setLong(2, objectReference.getReference());
        preparedStatement.setLong(3, objectReference.getObjectId());
        preparedStatement.execute();
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

        return objectReferences;
    }

    public void updateObjectReferenceByReference(ObjectReference objectReference, Long referenceId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.UPDATE_OBJECT_REFERENCE_BY_REFERENCE);
        preparedStatement.setLong(1, objectReference.getAttrId());
        preparedStatement.setLong(2, objectReference.getReference());
        preparedStatement.setLong(3, objectReference.getObjectId());
        preparedStatement.setLong(4, referenceId);

        preparedStatement.execute();
    }

    public void deleteObjectReferenceByReference(Long referenceId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.DELETE_OBJECT_REFERENCE_BY_REFERENCE);
        preparedStatement.setLong(1, referenceId);

        preparedStatement.execute();
    }

    public void deleteObjectReferenceByReferenceIdAndObjectId(Long referenceId, Long objectId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ObjectReferenceQueries.DELETE_OBJECT_REFERENCE_BY_REFERENCE_AND_OBJECT_ID);
        preparedStatement.setLong(1, referenceId);
        preparedStatement.setLong(2, objectId);

        preparedStatement.execute();
    }

}
