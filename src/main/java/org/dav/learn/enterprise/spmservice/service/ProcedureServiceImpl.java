package org.dav.learn.enterprise.spmservice.service;

import org.dav.learn.enterprise.spmservice.dao.ProcedureDAO;
import org.dav.learn.enterprise.spmservice.dao.ProcedureDAOImpl;
import org.dav.learn.enterprise.spmservice.model.ProcedureInfo;

import java.util.List;

public class ProcedureServiceImpl implements ProcedureService {
    private ProcedureDAO procedureDAO = new ProcedureDAOImpl();

    @Override
    public List<ProcedureInfo> allProcedures() {
        return procedureDAO.allProcedures();
    }

    @Override
    public void edit(ProcedureInfo procedureInfo) {
        procedureDAO.edit(procedureInfo);
    }

    @Override
    public ProcedureInfo getById(int id) {
        return procedureDAO.getById(id);
    }
}
