package net.orion.userAdmin.user.controller.dto;

import net.orion.userAdmin.user.domain.Learner;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;

import java.util.List;

public class LearnerListDtoMapper {

    public static List<LearnerListDto> asDto(List<Learner> learners) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Learner.class, LearnerListDto.class);
        modelMapper.addMappings(new PropertyMap<Learner, LearnerListDto>() {
            @Override
            protected void configure() {
                map().setBranchName(source.getBranch().getName());
            }
        });
        return modelMapper.map(learners,  new TypeToken<List<LearnerListDto>>() {}.getType());
    }

    public static List<Learner> asEntity(List<LearnerListDto> learnerListDtos) {
        return new ModelMapper().map(learnerListDtos, new TypeToken<List<Learner>>() {}.getType());
    }

}
