package net.orion.userAdmin.reference.controller.dto;

import net.orion.userAdmin.reference.domain.Branch;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class BranchListDtoMapper {

    public static List<BranchListDto> asDto(List<Branch> branches) {
        return new ModelMapper().map(branches,  new TypeToken<List<BranchListDto>>() {}.getType());
    }

    public static List<Branch> asEntity(List<BranchListDto> branchListDtos) {
        return new ModelMapper().map(branchListDtos, new TypeToken<List<Branch>>() {}.getType());
    }

}
