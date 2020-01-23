package eav.queries;

public class ObjectReferenceQueries {

    public static final String INSERT_NEW_OBJECT_REFERENCE
            = "insert into OBJREFERENCE (ATTR_ID, REFERENCE, OBJECT_ID) VALUES (?, ?, ?)";

    public static final String SELECT_OBJECT_REFERENCE_BY_ATTR_ID
            = "select ATTR_ID, REFERENCE, OBJECT_ID from OBJREFERENCE where ATTR_ID = ?";
    public static final String SELECT_OBJECT_REFERENCE_BY_REFERENCE
            = "select ATTR_ID, REFERENCE, OBJECT_ID from OBJREFERENCE where REFERENCE = ?";
    public static final String SELECT_OBJECT_REFERENCE_BY_OBJECT_ID
            = "select ATTR_ID, REFERENCE, OBJECT_ID from OBJREFERENCE where OBJECT_ID = ?";

    public static final String UPDATE_OBJECT_REFERENCE_BY_ATTR_ID
            = "update OBJREFERENCE set ATTR_ID = ?, REFERENCE = ?, OBJECT_ID = ? where ATTR_ID = ?";
    public static final String UPDATE_OBJECT_REFERENCE_BY_REFERENCE
            = "update OBJREFERENCE set ATTR_ID = ?, REFERENCE = ?, OBJECT_ID = ? where REFERENCE = ?";
    public static final String UPDATE_OBJECT_REFERENCE_BY_OBJECT_ID
            = "update OBJREFERENCE set ATTR_ID = ?, REFERENCE = ?, OBJECT_ID = ? where OBJECT_ID = ?";

    public static final String DELETE_OBJECT_REFERENCE_BY_ATTR_ID
            = "delete from OBJREFERENCE where ATTR_ID = ?";
    public static final String DELETE_OBJECT_REFERENCE_BY_REFERENCE
            = "delete from OBJREFERENCE where REFERENCE = ?";
    public static final String DELETE_OBJECT_REFERENCE_BY_OBJECT_ID
            = "delete from OBJREFERENCE where OBJECT_ID = ?";

}
