package org.dav.learn.enterprise.spmservice.service;

import org.dav.learn.enterprise.spmservice.dao.ProcedureDAO;
import org.dav.learn.enterprise.spmservice.dao.ProcedureDAOImpl;
import org.dav.learn.enterprise.spmservice.model.ProcedureInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProcedureServiceImpl implements ProcedureService {
    private ProcedureDAO procedureDAO;

    @Autowired
    public void setProcedureDAO(ProcedureDAO procedureDAO) {
        this.procedureDAO = procedureDAO;
    }

    @Transactional
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
