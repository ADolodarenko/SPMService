package org.dav.learn.enterprise.spmservice.model;

import java.io.Serializable;

public class ProcedureId implements Serializable {
    private short databaseId;
    private int procedureId;

    public ProcedureId() {}

    public ProcedureId(short databaseId, int procedureId) {
        this.databaseId = databaseId;
        this.procedureId = procedureId;
    }

    public short getDatabaseId() {
        return databaseId;
    }

    public int getProcedureId() {
        return procedureId;
    }

    @Override
    public int hashCode() {
        int result = databaseId;

        result += 31 * result + procedureId;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (obj == this) return true;

        if ( !ProcedureId.class.equals(obj.getClass()) )
            return false;

        ProcedureId that = (ProcedureId) obj;

        return this.databaseId == that.databaseId && this.procedureId == that.procedureId;
    }
}
