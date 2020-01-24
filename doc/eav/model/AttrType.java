package eav;

public class AttrType {

    private Long attributeTypeId;
    private Long objectTypeId;
    private Long objectTypeIdRefer;
    private String code;
    private String name;

    public Long getAttributeTypeId() {
        return attributeTypeId;
    }

    public void setAttributeTypeId(Long attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
    }

    public Long getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(Long objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public Long getObjectTypeIdRefer() {
        return objectTypeIdRefer;
    }

    public void setObjectTypeIdRefer(Long objectTypeIdRefer) {
        this.objectTypeIdRefer = objectTypeIdRefer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
