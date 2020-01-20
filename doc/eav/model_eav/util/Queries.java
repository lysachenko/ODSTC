package com.netcracker.tc.server.persistence.model_eav.util;

public class Queries {
    //for ObjType
    public static final String INSERT_NEW_OBJECT_TYPE="INSERT INTO objtype(OBJECT_TYPE_ID, PARENT_ID, CODE, NAME, DESCRIPTION) VALUES(?, ?, ?, ?, ?);";
    public static final String SELECT_OBJECT_TYPE_BY_ID="SELECT * FROM objtype WHERE OBJECT_TYPE_ID = ?;";
    public static final String SELECT_ALL_OBJECT_TYPES ="SELECT * FROM objtype;";
    public static final String DELETE_OBJECT_BY_ID ="DELETE FROM objtype WHERE OBJECT_TYPE_ID = ?;";



    //for AttrType

    public static final  String INSERT_NEW_ATTR_TYPE = "INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE, NAME) VALUES(?, ?, ?, ?, ?, ?);";
    public static final String SELECT_ATTR_TYPE_BY_ID="SELECT * FROM attrtype WHERE ATTR_ID = ?;";
    public static final String SELECT_ATTR_TYPE_BY_OBJECT_TYPE_ID="SELECT * FROM attrtype WHERE OBJECT_TYPE_ID = ?;";
}
