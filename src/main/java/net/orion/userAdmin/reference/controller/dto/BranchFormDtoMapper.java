package net.orion.userAdmin.reference.controller.dto;

import net.orion.userAdmin.reference.domain.Branch;
import org.modelmapper.ModelMapper;

public class BranchFormDtoMapper {

    public static BranchFormDto asDto(Branch branch) {
        if (branch == null) { return null; }
        else {
            return new ModelMapper().map(branch, BranchFormDto.class);
        }
    }

    public static Branch asEntity(BranchFormDto branchFormDto) {
        if (branchFormDto == null) { return null; }
        else {
            return new ModelMapper().map(branchFormDto, Branch.class);
        }
    }

}
