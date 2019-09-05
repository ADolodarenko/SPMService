package org.dav.learn.enterprise.spmservice.dao;

import org.dav.learn.enterprise.spmservice.model.ProcedureInfo;

import java.util.List;

public interface ProcedureDAO {
    List<ProcedureInfo> allProcedures();
    void edit(ProcedureInfo procedureInfo);
    ProcedureInfo getByIds(short databaseId, int procedureId);
}
