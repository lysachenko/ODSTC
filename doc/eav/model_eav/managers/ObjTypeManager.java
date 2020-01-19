package com.netcracker.tc.server.persistence.model_eav.managers;

import com.netcracker.tc.server.persistence.model_eav.ObjType;
import com.netcracker.tc.server.persistence.model_eav.util.Queries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ObjTypeManager {

    public final static String OBJECT_TYPE_ID = "OBJECT_TYPE_ID";
    public final static String PARENT_ID = "PARENT_ID";
    public final static String CODE = "CODE";
    public final static String NAME = "NAME";
    public final static String DESCRIPTION = "DESCRIPTION";

    private Connection conn;

    public void  createObjType(ObjType objType) throws SQLException {

        PreparedStatement preparedStmt = conn.prepareStatement(Queries.INSERT_NEW_OBJECT_TYPE);
        preparedStmt.setInt (1, objType.getObjectTypeId());
        preparedStmt.setInt (2, objType.getParentId());
        preparedStmt.setString (3, objType.getCode());
        preparedStmt.setString(4, objType.getName());
        preparedStmt.setString(5, objType.getDescription());

        preparedStmt.execute();

        conn.close();
    }

    public ObjType getObjectTypeById(int id) throws SQLException {
        ObjType objType  = new ObjType();
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.SELECT_OBJECT_TYPE_BY_ID);
        preparedStmt.setInt (1, id);

        ResultSet rs = preparedStmt.executeQuery();

        while (rs.next()){
            objType.setObjectTypeId(rs.getInt(OBJECT_TYPE_ID));
            objType.setParentId(rs.getInt(PARENT_ID));
            objType.setCode(rs.getString(CODE));
            objType.setName(rs.getString(NAME));
            objType.setDescription(rs.getString(DESCRIPTION));
        }

        conn.close();
        return objType;
    }

    public List<ObjType> getAllObjectTypes() throws SQLException {
        ObjType objType = new ObjType(); //!!!!!!!!!1
        List<ObjType> listOfObjTypes = new ArrayList<ObjType>();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(Queries.SELECT_ALL_OBJECT_TYPES);

        while (rs.next()){
            objType.setObjectTypeId(rs.getInt(OBJECT_TYPE_ID));
            objType.setParentId(rs.getInt(PARENT_ID));
            objType.setCode(rs.getString(CODE));
            objType.setName(rs.getString(NAME));
            objType.setDescription(rs.getString(DESCRIPTION));

            listOfObjTypes.add(objType);
        }
        conn.close();
        return listOfObjTypes;
    }

    public void deleteObjectTypeById(int id) throws SQLException {
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.DELETE_OBJECT_BY_ID); //ON CASCADE DELETE
        preparedStmt.setInt (1, id);

        preparedStmt.execute();

        conn.close();
    }




}
