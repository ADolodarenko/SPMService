package org.dav.learn.enterprise.spmservice.service;

import org.dav.learn.enterprise.spmservice.dao.ProcedureDAO;
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
    public List<ProcedureInfo> allProcedures(int pageNumber) {
        return procedureDAO.allProcedures(pageNumber);
    }

    @Transactional
    @Override
    public void edit(ProcedureInfo procedureInfo) {
        procedureDAO.edit(procedureInfo);
    }

    @Transactional
    @Override
    public ProcedureInfo getByIds(short databaseId, int procedureId) {
        return procedureDAO.getByIds(databaseId, procedureId);
    }

    @Transactional
    @Override
    public int proceduresCount() {
        return procedureDAO.proceduresCount();
    }
}
