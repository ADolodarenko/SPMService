package org.dav.learn.enterprise.spmservice.service;

import org.dav.learn.enterprise.spmservice.model.ProcedureInfo;

import java.util.List;

public interface ProcedureService {
    List<ProcedureInfo> allProcedures();
    void edit(ProcedureInfo procedureInfo);
    ProcedureInfo getByIds(short databaseId, int procedureId);
}
