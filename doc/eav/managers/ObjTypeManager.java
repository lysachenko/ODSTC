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

    public ObjTypeManager(Connection connection) throws SQLException {
        this.conn =connection;
        conn.setAutoCommit(false);
    }

    public void createObjType(ObjType objType) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Queries.INSERT_NEW_OBJECT_TYPE);

        if(objType.getParentId()!=null){
            ps.setLong(1, objType.getParentId());

        }
        else ps.setString(1, null);

        ps.setString(2, objType.getCode());
        ps.setString(3, objType.getName());
        ps.setString(4, objType.getDescription());

        ps.execute();

        conn.commit();
        conn.close();
    }



    public ObjType getObjTypeById(Long id) throws SQLException {
        ObjType objType  = new ObjType();
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.SELECT_OBJECT_TYPE_BY_ID);
        preparedStmt.setLong (1, id);

        ResultSet rs = preparedStmt.executeQuery();

        while (rs.next()){
            objType.setObjectTypeId(rs.getLong(OBJECT_TYPE_ID));
            objType.setParentId(rs.getLong(PARENT_ID));
            objType.setCode(rs.getString(CODE));
            objType.setName(rs.getString(NAME));
            objType.setDescription(rs.getString(DESCRIPTION));
        }

        conn.close();
        return objType;
    }

    public List<ObjType> getAllObjTypes() throws SQLException {
        List<ObjType> listOfObjTypes = new ArrayList<ObjType>();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(Queries.SELECT_ALL_OBJECT_TYPES);

        while (rs.next()){
            ObjType objType = new ObjType();
            objType.setObjectTypeId(rs.getLong(OBJECT_TYPE_ID));
            objType.setParentId(rs.getLong(PARENT_ID));
            objType.setCode(rs.getString(CODE));
            objType.setName(rs.getString(NAME));
            objType.setDescription(rs.getString(DESCRIPTION));

            listOfObjTypes.add(objType);
        }
        conn.close();
        return listOfObjTypes;
    }

    public void deleteObjTypeById(Long id) throws SQLException {
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.DELETE_OBJECT_TYPE_BY_ID);
        preparedStmt.setLong (1, id);
        preparedStmt.execute();
        conn.commit();
        conn.close();
    }

    public void updateObjTypeNameById(Long id, String name) throws SQLException {
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.UPDATE_OBJECT_TYPE_NAME_BY_ID);
        preparedStmt.setString (1, name);
        preparedStmt.setLong (2, id);
        preparedStmt.execute();
        conn.commit();
        conn.close();
    }

    public void updateObjTypeCodeById(Long id, String code) throws SQLException {
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.UPDATE_OBJECT_TYPE_CODE_BY_ID);
        preparedStmt.setString (1, code);
        preparedStmt.setLong (2, id);
        preparedStmt.execute();
        conn.commit();
        conn.close();
    }

    public void updateObjTypeDescriptionById(Long id, String description) throws SQLException {
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.UPDATE_OBJECT_TYPE_DESCRIPTION_BY_ID);
        preparedStmt.setString (1, description);
        preparedStmt.setLong (2, id);
        preparedStmt.execute();
        conn.commit();
        conn.close();
    }

    public void updateObjTypeParentIdById(Long id, Long parentId) throws SQLException {
        PreparedStatement preparedStmt = conn.prepareStatement(Queries.UPDATE_OBJECT_TYPE_PARENT_BY_ID);
        preparedStmt.setLong (1, parentId);
        preparedStmt.setLong (2, id);
        preparedStmt.execute();
        conn.commit();
        conn.close();
    }
}
