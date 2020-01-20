package com.netcracker.tc.server.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttrTypeManager {
    public final static String ATTR_ID = "ATTR_ID";
    public final static String OBJECT_TYPE_ID = "OBJECT_TYPE_ID";
    public final static String OBJECT_TYPE_ID_REF = "OBJECT_TYPE_ID_REF";
    public final static String CODE = "CODE";
    public final static String NAME = "NAME";

    private Connection conn;

    public void  createAttrType(AttrType attrType) throws SQLException {
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.INSERT_NEW_ATTR_TYPE);
        preparedStmt.setInt (1, attrType.getAttributeTypeId());
        preparedStmt.setInt (2, attrType.getObjectTypeId());
        preparedStmt.setInt (3, attrType.getObjectTypeIdRefer());
        preparedStmt.setString(4, attrType.getCode());
        preparedStmt.setString(5, attrType.getName());

        preparedStmt.execute();

        conn.close();
    }

    public AttrType getAttrTypeById(int id) throws SQLException {
        AttrType attrType  = new AttrType();
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.SELECT_ATTR_TYPE_BY_ID);
        preparedStmt.setInt (1, id);

        ResultSet rs = preparedStmt.executeQuery();

        while (rs.next()){
            attrType.setAttributeTypeId(rs.getInt(ATTR_ID));
            attrType.setObjectTypeId(rs.getInt(OBJECT_TYPE_ID));
            attrType.setObjectTypeIdRefer(rs.getInt(OBJECT_TYPE_ID_REF));
            attrType.setCode(rs.getString(CODE));
            attrType.setName(rs.getString(NAME));
        }

        conn.close();
        return attrType;
    }

    //get all attribute_types by object_id

    public List<AttrType> getAllAttrTypeByObjectTypeId(int objectTypeId) throws SQLException {
        AttrType attrType = new AttrType();
        List<AttrType> listOfAttrTypes = new ArrayList<AttrType>();

        PreparedStatement statement = conn.prepareStatement(Queries.SELECT_ATTR_TYPE_BY_OBJECT_TYPE_ID);
        statement.setInt (1, objectTypeId);

        ResultSet rs = statement.executeQuery();;

        while (rs.next()){
            attrType.setAttributeTypeId(rs.getInt(ATTR_ID));
            attrType.setObjectTypeId(rs.getInt(OBJECT_TYPE_ID));
            attrType.setObjectTypeIdRefer(rs.getInt(OBJECT_TYPE_ID_REF));
            attrType.setCode(rs.getString(CODE));
            attrType.setName(rs.getString(NAME));

            listOfAttrTypes.add(attrType);
        }
        conn.close();
        return listOfAttrTypes;
    }




}
