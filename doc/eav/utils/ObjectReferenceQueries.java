package eav.queries;

public class ObjectReferenceQueries {

    public static final String INSERT_NEW_OBJECT_REFERENCE
            = "insert into OBJREFERENCE (ATTR_ID, REFERENCE, OBJECT_ID) VALUES (?, ?, ?)";

    public static final String SELECT_OBJECT_REFERENCE_BY_REFERENCE
            = "select ATTR_ID, REFERENCE, OBJECT_ID from OBJREFERENCE where REFERENCE = ?";

    public static final String UPDATE_OBJECT_REFERENCE_BY_REFERENCE
            = "update OBJREFERENCE set ATTR_ID = ?, REFERENCE = ?, OBJECT_ID = ? where REFERENCE = ?";
    public static final String UPDATE_OBJECT_REFERENCE_BY_REFERENCE_AND_OBJECT_ID
            = "update OBJREFERENCE set ATTR_ID = ?, REFERENCE = ?, OBJECT_ID = ? where REFERENCE = ? and OBJECT_ID = ?";

    public static final String DELETE_OBJECT_REFERENCE_BY_REFERENCE
            = "delete from OBJREFERENCE where REFERENCE = ?";
    public static final String DELETE_OBJECT_REFERENCE_BY_REFERENCE_AND_OBJECT_ID
            = "delete from OBJREFERENCE where REFERENCE = ? and OBJECT_ID = ?";

}
