package net.orion.userAdmin.reference.service;

import net.orion.userAdmin.reference.dao.BranchDao;
import net.orion.userAdmin.reference.domain.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("branchService")
@Transactional
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchDao dao;

    public void saveBranch(Branch branch) {
        dao.saveBranch(branch);
    }

    public List<Branch> findAllBranches() {
        return dao.findAllBranches();
    }

    public void deleteBranchById(short id) {
        dao.deleteBranchById(id);
    }

    public Branch findBranchById(short id) {
        return dao.findBranchById(id);
    }

    public void updateBranch(Branch branch) {
        dao.updateBranch(branch);
    }

    public Branch findBranchByName(String name) {
        return dao.findBranchByName(name);
    }

    public boolean isBranchExist(Branch branch) {
        return findBranchByName(branch.getName()) != null;
    }

}
