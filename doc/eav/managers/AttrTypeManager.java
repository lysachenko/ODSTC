package com.netcracker.tc.server.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttrTypeManager {
    private static final String ATTR_ID = "ATTR_ID";
    private static final String OBJECT_TYPE_ID = "OBJECT_TYPE_ID";
    private static final String OBJECT_TYPE_ID_REF = "OBJECT_TYPE_ID_REF";
    private static final String CODE = "CODE";
    private static final String NAME = "NAME";

    private Connection conn;

    public AttrTypeManager(Connection connection) throws SQLException {
        this.conn =connection;
        conn.setAutoCommit(false);
    }

    public void createAttrType(AttrType attrType) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Queries.INSERT_NEW_ATTR_TYPE);
        ps.setLong(1, attrType.getAttributeTypeId());
        ps.setLong(2, attrType.getObjectTypeId());
        ps.setLong(3, attrType.getObjectTypeIdRefer());
        ps.setString(4, attrType.getCode());
        ps.setString(5, attrType.getName());

        ps.execute();

        conn.commit();
        conn.close();
    }

    public AttrType getAttrTypeById(Long id) throws SQLException {
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.SELECT_ATTR_TYPE_BY_ID);
        preparedStmt.setLong (1, id);

        ResultSet rs = preparedStmt.executeQuery();
        AttrType attrType  = new AttrType();

        while (rs.next()) {
            attrType.setAttributeTypeId(rs.getLong(ATTR_ID));
            attrType.setObjectTypeId(rs.getLong(OBJECT_TYPE_ID));
            attrType.setObjectTypeIdRefer(rs.getLong(OBJECT_TYPE_ID_REF));
            attrType.setCode(rs.getString(CODE));
            attrType.setName(rs.getString(NAME));
        }

        conn.close();
        return attrType;
    }

    public List<AttrType> getAllAttrTypes() throws SQLException {
        List<AttrType> listOfAttrTypes = new ArrayList<AttrType>();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(Queries.SELECT_ALL_ATTR_TYPES);

        while (rs.next()){
            AttrType attrType = new AttrType();
            attrType.setAttributeTypeId(rs.getLong(ATTR_ID));
            attrType.setObjectTypeId(rs.getLong(OBJECT_TYPE_ID));
            attrType.setObjectTypeIdRefer(rs.getLong(OBJECT_TYPE_ID_REF));
            attrType.setCode(rs.getString(CODE));
            attrType.setName(rs.getString(NAME));

            listOfAttrTypes.add(attrType);
        }
        conn.close();
        return listOfAttrTypes;
    }

    public void deleteAttrTypeById(Long id) throws SQLException {
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.DELETE_ATTR_TYPE_BY_ID);
        preparedStmt.setLong (1, id);
        preparedStmt.execute();
        conn.commit();
        conn.close();
    }

    public void updateAttrTypeCodeById(Long id, String code) throws SQLException {
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.UPDATE_ATTR_TYPE_CODE_BY_ID);
        preparedStmt.setString (1, code);
        preparedStmt.setLong (2, id);
        preparedStmt.execute();
        conn.commit();
        conn.close();
    }

    public void updateAttrTypeNameById(Long id, String name) throws SQLException {
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.UPDATE_ATTR_TYPE_NAME_BY_ID);
        preparedStmt.setString (1, name);
        preparedStmt.setLong (2, id);
        preparedStmt.execute();
        conn.commit();
        conn.close();
    }

    public void updateAttrTypeObjTypeById(Long id, Long objTypeId) throws SQLException {
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.UPDATE_ATTR_TYPE_OBJ_TYPE_BY_ID);
        preparedStmt.setLong (1, objTypeId);
        preparedStmt.setLong (2, id);
        preparedStmt.execute();
        conn.commit();
        conn.close();
    }

    public void updateAttrTypeObjTypeRefById(Long id, Long objTypeRefId) throws SQLException {
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.UPDATE_ATTR_TYPE_OBJ_TYPE_REF_BY_ID);
        preparedStmt.setLong (1, objTypeRefId);
        preparedStmt.setLong (2, id);
        preparedStmt.execute();
        conn.commit();
        conn.close();
    }
}
