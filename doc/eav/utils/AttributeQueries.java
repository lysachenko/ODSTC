package eav.queries;

public class AttributeQueries {

    public static final String INSERT_NEW_ATTRIBUTE
            = "insert into ATTRIBUTES(ATTR_ID, OBJECT_ID, VALUE, DATE_VALUE) VALUES (?, ?, ?, ?)";

    public static final String SELECT_ATTRIBUTES_BY_ATTR_ID
            = "select ATTR_ID, OBJECT_ID, VALUE, DATE_VALUE from ATTRIBUTES where ATTR_ID = ?";
    public static final String SELECT_ATTRIBUTES_BY_OBJECT_ID
            = "select ATTR_ID, OBJECT_ID, VALUE, DATE_VALUE from ATTRIBUTES where OBJECT_ID = ?";

    public static final String UPDATE_ATTRIBUTE_BY_OBJECT_ID_AND_ATTR_ID
            = "update ATTRIBUTES set OBJECT_ID = ?, VALUE = ?, DATE_VALUE = ? " +
            "where OBJECT_ID = ? and ATTR_ID = ?";
    public static final String UPDATE_ATTRIBUTE_VALUE_BY_OBJECT_ID_AND_ATTR_ID
            = "update ATTRIBUTES set VALUE = ? where OBJECT_ID = ? and ATTR_ID = ?";
    public static final String UPDATE_ATTRIBUTE_DATE_VALUE_BY_OBJECT_ID_AND_ATTR_ID
            = "update ATTRIBUTES set DATE_VALUE = ? where OBJECT_ID = ? and ATTR_ID = ?";

    public static final String DELETE_ATTRIBUTES_BY_OBJECT_ID
            = "delete from ATTRIBUTES where OBJECT_ID = ?";
    public static final String DELETE_ATTRIBUTES_BY_ATTR_ID
            = "delete from ATTRIBUTES where ATTR_ID = ?";
    public static final String DELETE_ATTRIBUTES_BY_OBJECT_ID_AND_ATTR_ID
            = "delete from ATTRIBUTES where OBJECT_ID = ? and ATTR_ID = ?";

}
