package com.netcracker.tc.server.persistence.model_eav.util;

public class Queries {

    public static final String INSERT_NEW_OBJECT_TYPE="INSERT INTO objtype(OBJECT_TYPE_ID, PARENT_ID, CODE, NAME, DESCRIPTION) VALUES(?, ?, ?, ?, ?);";
    public static final String SELECT_OBJECT_TYPE_BY_ID="SELECT * FROM objtype WHERE OBJECT_TYPE_ID = ?;";
    public static final String SELECT_ALL_OBJECT_TYPES ="SELECT * FROM objtype;";
    public static final String DELETE_OBJECT_BY_ID ="DELETE FROM objtype WHERE OBJECT_TYPE_ID = ?;";


}
