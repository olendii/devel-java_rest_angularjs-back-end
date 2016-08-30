package net.orion.userAdmin.reference.dao;

import net.orion.userAdmin.common.dao.AbstractDao;
import net.orion.userAdmin.reference.domain.Branch;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("branchDao")
public class BranchDaoImpl extends AbstractDao implements BranchDao {

    public void saveBranch(Branch branch) {
        persist(branch);
    }

    @SuppressWarnings("unchecked")
    public List<Branch> findAllBranches() {
        Criteria criteria = getSession().createCriteria(Branch.class);
        return (List<Branch>) criteria.list();
    }

    public void deleteBranchById(short id) {
        Query query = getSession().createSQLQuery("delete from branch where branch_id = :branch_id");
        query.setShort("branch_id", id);
        query.executeUpdate();
    }

    public Branch findBranchById(short id) {
        Criteria criteria = getSession().createCriteria(Branch.class);
        criteria.add(Restrictions.eq("id", id));
        return (Branch) criteria.uniqueResult();
    }

    public void updateBranch(Branch branch) {
        getSession().update(branch);
    }

    public Branch findBranchByName(String name) {
        Criteria criteria = getSession().createCriteria(Branch.class);
        criteria.add(Restrictions.eq("name", name));
        return (Branch) criteria.uniqueResult();
    }

}
