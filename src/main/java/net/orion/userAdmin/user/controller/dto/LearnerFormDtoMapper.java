package net.orion.userAdmin.user.controller.dto;

import net.orion.userAdmin.user.domain.Learner;
import org.modelmapper.ModelMapper;

public class LearnerFormDtoMapper {

    public static LearnerFormDto asDto(Learner learner) {
        if (learner == null) { return null; }
        else {
            return new ModelMapper().map(learner, LearnerFormDto.class);
        }
    }

    public static Learner asEntity(LearnerFormDto learnerFormDto) {
        if (learnerFormDto == null) { return null; }
        else {
            return new ModelMapper().map(learnerFormDto, Learner.class);
        }
    }

}
