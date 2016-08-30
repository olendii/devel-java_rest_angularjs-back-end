package net.orion.userAdmin.user.controller;

import net.orion.userAdmin.user.controller.dto.LearnerFormDto;
import net.orion.userAdmin.user.controller.dto.LearnerFormDtoMapper;
import net.orion.userAdmin.user.controller.dto.LearnerListDto;
import net.orion.userAdmin.user.controller.dto.LearnerListDtoMapper;
import net.orion.userAdmin.user.domain.Learner;
import net.orion.userAdmin.user.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class LearnerController {
    
    @Autowired
    private LearnerService learnerService;

    // Retrieve all learners
    @RequestMapping(value = "/learners", method = RequestMethod.GET)
    public ResponseEntity<List<LearnerListDto>> listAllLearners() {
        List<LearnerListDto> learnerListDtos = LearnerListDtoMapper.asDto(learnerService.findAllLearners());
        if(learnerListDtos.isEmpty()){
            return new ResponseEntity<List<LearnerListDto>>(HttpStatus.NO_CONTENT);
            //You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<LearnerListDto>>(learnerListDtos, HttpStatus.OK);
    }

    // Retrieve single learner
    @RequestMapping(value = "/learners/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LearnerFormDto> getLearner(@PathVariable("id") long id) {
        LearnerFormDto learnerFormDto = LearnerFormDtoMapper.asDto(learnerService.findLearnerById(id));
        if (learnerFormDto == null) {
            return new ResponseEntity<LearnerFormDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<LearnerFormDto>(learnerFormDto, HttpStatus.OK);
    }

    // Create a learner
    @RequestMapping(value = "/learners", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createLearner(@RequestBody LearnerFormDto learnerFormDto,
                                              UriComponentsBuilder ucBuilder) {

        Learner newLearner = LearnerFormDtoMapper.asEntity(learnerFormDto);
        if (learnerService.isLearnerExist(newLearner)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        learnerService.saveLearner(newLearner);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/learners/{id}").buildAndExpand(newLearner.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    // Update a learner
    @RequestMapping(value = "/learners/{id}", method = RequestMethod.PUT)
    public ResponseEntity<LearnerFormDto> updateLearner(@PathVariable("id") long id,
                                                        @RequestBody LearnerFormDto learnerFormDto) {

        LearnerFormDto currentLearner = LearnerFormDtoMapper.asDto(learnerService.findLearnerById(id));

        if (currentLearner == null) {
            return new ResponseEntity<LearnerFormDto>(HttpStatus.NOT_FOUND);
        }

        learnerService.updateLearner(LearnerFormDtoMapper.asEntity(learnerFormDto));
        return new ResponseEntity<LearnerFormDto>(learnerFormDto, HttpStatus.OK);
    }

    // Delete a learner
    @RequestMapping(value = "/learners/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<LearnerFormDto> deleteLearner(@PathVariable("id") long id) {

        Learner learner = learnerService.findLearnerById(id);
        if (learner == null) {
            return new ResponseEntity<LearnerFormDto>(HttpStatus.NOT_FOUND);
        }

        learnerService.deleteLearnerById(id);
        return new ResponseEntity<LearnerFormDto>(HttpStatus.NO_CONTENT);
    }

}
