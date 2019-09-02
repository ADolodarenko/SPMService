package org.dav.learn.enterprise.spmservice.dao;

import org.dav.learn.enterprise.spmservice.model.ProcedureInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ProcedureDAOImpl implements ProcedureDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, ProcedureInfo> procedures = new HashMap<>();

    static {
        ProcedureInfo procedureInfo = new ProcedureInfo();
        procedureInfo.setDatabaseId(5);
        procedureInfo.setProcedureId(AUTO_ID.getAndIncrement());
        procedureInfo.setProcedureName("usp_dav_test");
        procedureInfo.setProcedureDescription("usp_dav_test");
        procedures.put(procedureInfo.getProcedureId(), procedureInfo);
    }

    @Override
    public List<ProcedureInfo> allProcedures() {
        return new ArrayList<>(procedures.values());
    }

    @Override
    public void edit(ProcedureInfo procedureInfo) {
        procedures.put(procedureInfo.getProcedureId(), procedureInfo);
    }

    @Override
    public ProcedureInfo getById(int id) {
        return procedures.get(id);
    }
}
