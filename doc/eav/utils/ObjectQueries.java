package eav.queries;

public class ObjectQueries {

    public static final String INSERT_NEW_OBJECT
            = "insert into OBJECTS (OBJECT_ID, PARENT_ID, OBJECT_TYPE_ID, NAME, DESCRIPTION) VALUES (seq_for_object.nextval, ?, ?, ?, ?)";
    public static final String INSERT_NEW_OBJECT_WITHOUT_PARENT_ID
            = "insert into OBJECTS (OBJECT_ID, OBJECT_TYPE_ID, NAME, DESCRIPTION) VALUES (seq_for_object.nextval, ?, ?, ?)";

    public static final String SELECT_ALL_OBJECTS
            = "select OBJECT_ID, PARENT_ID, OBJECT_TYPE_ID, NAME, DESCRIPTION from OBJECTS";
    public static final String SELECT_OBJECT_BY_OBJECT_ID
            = "select OBJECT_ID, PARENT_ID, OBJECT_TYPE_ID, NAME, DESCRIPTION from OBJECTS where OBJECT_ID = ?";
    public static final String SELECT_OBJECTS_BY_OBJECT_TYPE_ID
            = "select OBJECT_ID, PARENT_ID, OBJECT_TYPE_ID, NAME, DESCRIPTION from OBJECTS where OBJECT_TYPE_ID = ?";
    public static final String SELECT_OBJECTS_BY_PARENT_ID
            = "select OBJECT_ID, PARENT_ID, OBJECT_TYPE_ID, NAME, DESCRIPTION from OBJECTS where PARENT_ID = ?";

    public static final String UPDATE_OBJECT_BY_ID
            = "update OBJECTS set PARENT_ID = ?, OBJECT_TYPE_ID = ?, NAME = ?, DESCRIPTION = ? where OBJECT_ID = ?";
    public static final String UPDATE_OBJECT_BY_ID_WITHOUT_PARENT_ID
            = "update OBJECTS set OBJECT_TYPE_ID = ?, NAME = ?, DESCRIPTION = ? where OBJECT_ID = ?";
    public static final String UPDATE_OBJECT_BY_PARENT_ID
            = "update OBJECTS set PARENT_ID = ?, OBJECT_TYPE_ID = ?, NAME = ?, DESCRIPTION = ? where PARENT_ID = ?";
    public static final String UPDATE_OBJECT_BY_OBJECT_TYPE_ID
            = "update OBJECTS set PARENT_ID = ?, OBJECT_TYPE_ID = ?, NAME = ?, DESCRIPTION = ? where OBJECT_TYPE_ID = ?";

    public static final String DELETE_OBJECT_BY_ID
            = "delete from OBJECTS where OBJECT_ID = ?";
    public static final String DELETE_OBJECTS_BY_PARENT_ID
            = "delete from OBJECTS where PARENT_ID = ?";
    public static final String DELETE_OBJECTS_BY_OBJECT_TYPE_ID
            = "delete from OBJECTS where OBJECT_TYPE_ID = ?";

}

