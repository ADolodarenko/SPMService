package org.dav.learn.enterprise.spmservice.dao;

import org.dav.learn.enterprise.spmservice.config.ViewConfig;
import org.dav.learn.enterprise.spmservice.model.ProcedureId;
import org.dav.learn.enterprise.spmservice.model.ProcedureInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProcedureDAOImpl implements ProcedureDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ProcedureInfo> allProcedures(int pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        Query resultQuery = session.createQuery("from ProcedureInfo");
        resultQuery = resultQuery.setFirstResult(ViewConfig.RECORDS_PER_PAGE * (pageNumber - 1));
        resultQuery = resultQuery.setMaxResults(ViewConfig.RECORDS_PER_PAGE);
        return resultQuery.list();
    }

    @Override
    public void edit(ProcedureInfo procedureInfo) {
        Session session = sessionFactory.getCurrentSession();
        session.update(procedureInfo);
    }

    @Override
    public ProcedureInfo getByIds(short databaseId, int procedureId) {
        Session session = sessionFactory.getCurrentSession();
        ProcedureId id = new ProcedureId(databaseId, procedureId);
        return session.get(ProcedureInfo.class, id);
    }

    @Override
    public int proceduresCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from ProcedureInfo", Number.class).getSingleResult().intValue();
    }
}
