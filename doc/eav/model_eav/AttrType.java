package com.netcracker.tc.server.persistence;

public class AttrType {

    private int attributeTypeId;
    private int objectTypeId;
    private int objectTypeIdRefer;
    private String code;
    private String name;

    public int getAttributeTypeId() {
        return attributeTypeId;
    }

    public void setAttributeTypeId(int attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
    }

    public int getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(int objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public int getObjectTypeIdRefer() {
        return objectTypeIdRefer;
    }

    public void setObjectTypeIdRefer(int objectTypeIdRefer) {
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
