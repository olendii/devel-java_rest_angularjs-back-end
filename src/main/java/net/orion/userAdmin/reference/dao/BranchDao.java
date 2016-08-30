package net.orion.userAdmin.reference.dao;

import net.orion.userAdmin.reference.domain.Branch;

import java.util.List;

public interface BranchDao {

    void saveBranch(Branch branch);

    List<Branch> findAllBranches();

    void deleteBranchById(short id);

    Branch findBranchById(short id);

    void updateBranch(Branch branch);

    Branch findBranchByName(String name);

}
