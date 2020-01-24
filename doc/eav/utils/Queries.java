package eav;

public class Queries {
    
    public static final String INSERT_NEW_OBJECT_TYPE="INSERT INTO objtype(OBJECT_TYPE_ID, PARENT_ID, CODE, NAME, DESCRIPTION) VALUES(SEQ_FOR_OBJTYPE.nextval, ?, ?, ?, ?)";
    public static final String SELECT_OBJECT_TYPE_BY_ID="SELECT * FROM objtype WHERE OBJECT_TYPE_ID = ?";
    public static final String SELECT_ALL_OBJECT_TYPES ="SELECT * FROM objtype";
    public static final String DELETE_OBJECT_TYPE_BY_ID ="DELETE FROM objtype WHERE OBJECT_TYPE_ID = ?";
    public static final String UPDATE_OBJECT_TYPE_NAME_BY_ID ="UPDATE  objtype SET NAME = ? WHERE OBJECT_TYPE_ID = ?";
    public static final String UPDATE_OBJECT_TYPE_CODE_BY_ID ="UPDATE  objtype SET CODE = ? WHERE OBJECT_TYPE_ID = ?";
    public static final String UPDATE_OBJECT_TYPE_PARENT_BY_ID ="UPDATE  objtype SET PARENT_ID = ? WHERE OBJECT_TYPE_ID = ?";
    public static final String UPDATE_OBJECT_TYPE_DESCRIPTION_BY_ID ="UPDATE  objtype SET DESCRIPTION = ? WHERE OBJECT_TYPE_ID = ?";

    //attr_type
    public static final String INSERT_NEW_ATTR_TYPE="INSERT INTO attrtype(ATTR_ID, OBJECT_TYPE_ID, OBJECT_TYPE_ID_REF, CODE, NAME) VALUES(SEQ_FOR_ATTRTYPE.nextval, ?, ?, ?, ?)";
    public static final String SELECT_ATTR_TYPE_BY_ID = "SELECT * FROM attrtype WHERE ATTR_ID = ?";
    public static final String SELECT_ALL_ATTR_TYPES = "SELECT * FROM attrtype";
    public static final String DELETE_ATTR_TYPE_BY_ID ="DELETE FROM attrtype WHERE ATTR_ID = ?";
    public static final String UPDATE_ATTR_TYPE_CODE_BY_ID ="UPDATE  attrtype SET CODE = ? WHERE ATTR_ID = ?";
    public static final String UPDATE_ATTR_TYPE_NAME_BY_ID ="UPDATE  attrtype SET NAME = ? WHERE ATTR_ID = ?";
    public static final String UPDATE_ATTR_TYPE_OBJ_TYPE_BY_ID ="UPDATE  attrtype SET OBJECT_TYPE_ID = ? WHERE ATTR_ID = ?";
    public static final String UPDATE_ATTR_TYPE_OBJ_TYPE_REF_BY_ID ="UPDATE  attrtype SET OBJECT_TYPE_ID_REF = ? WHERE ATTR_ID = ?";

}
