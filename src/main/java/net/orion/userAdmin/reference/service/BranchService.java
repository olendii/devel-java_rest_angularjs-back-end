package net.orion.userAdmin.reference.service;

import net.orion.userAdmin.reference.domain.Branch;

import java.util.List;

public interface BranchService {

    void saveBranch(Branch branch);

    List<Branch> findAllBranches();

    void deleteBranchById(short id);

    Branch findBranchById(short id);

    void updateBranch(Branch branch);

    Branch findBranchByName(String name);

    boolean isBranchExist(Branch branch);

}
