package eav;

public class Queries {
    
    public static final String INSERT_NEW_OBJECT_TYPE="INSERT INTO objtype(OBJECT_TYPE_ID, PARENT_ID, CODE, NAME, DESCRIPTION) VALUES(?, ?, ?, ?, ?)";
    public static final String SELECT_OBJECT_TYPE_BY_ID="SELECT * FROM objtype WHERE OBJECT_TYPE_ID = ?";
    public static final String SELECT_ALL_OBJECT_TYPES ="SELECT * FROM objtype";
    public static final String DELETE_OBJECT_TYPE_BY_ID ="DELETE FROM objtype WHERE OBJECT_TYPE_ID = ?";
    public static final String UPDATE_OBJECT_TYPE_NAME_BY_ID ="UPDATE  objtype SET NAME = ? WHERE OBJECT_TYPE_ID = ?";
    public static final String UPDATE_OBJECT_TYPE_CODE_BY_ID ="UPDATE  objtype SET CODE = ? WHERE OBJECT_TYPE_ID = ?";
    public static final String UPDATE_OBJECT_TYPE_PARENT_BY_ID ="UPDATE  objtype SET PARENT_ID = ? WHERE OBJECT_TYPE_ID = ?";
    public static final String UPDATE_OBJECT_TYPE_DESCRIPTION_BY_ID ="UPDATE  objtype SET DESCRIPTION = ? WHERE OBJECT_TYPE_ID = ?";

}
