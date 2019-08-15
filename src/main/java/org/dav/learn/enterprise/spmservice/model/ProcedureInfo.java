package org.dav.learn.enterprise.spmservice.model;

public class ProcedureInfo {
    private int databaseId;
    private int procedureId;
    private String procedureName;
    private String procedureDescription;

    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }

    public int getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(int procedureId) {
        this.procedureId = procedureId;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getProcedureDescription() {
        return procedureDescription;
    }

    public void setProcedureDescription(String procedureDescription) {
        this.procedureDescription = procedureDescription;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("databaseId=");
        builder.append(databaseId);
        builder.append(", ");
        builder.append("procedureId=");
        builder.append(procedureId);
        builder.append(", ");
        builder.append("procedureName=");
        builder.append(procedureName);
        builder.append(", ");
        builder.append("procedureDescription=");
        builder.append(procedureDescription);

        return builder.toString();
    }
}
