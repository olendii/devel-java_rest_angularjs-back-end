package net.orion.userAdmin.reference.controller;

import net.orion.userAdmin.reference.controller.dto.BranchFormDto;
import net.orion.userAdmin.reference.controller.dto.BranchFormDtoMapper;
import net.orion.userAdmin.reference.controller.dto.BranchListDto;
import net.orion.userAdmin.reference.controller.dto.BranchListDtoMapper;
import net.orion.userAdmin.reference.domain.Branch;
import net.orion.userAdmin.reference.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class BranchController {

    @Autowired
    private BranchService branchService;

    // Retrieve all branches
    @RequestMapping(value = "/branches", method = RequestMethod.GET)
    public ResponseEntity<List<BranchListDto>> listAllBranches() {
        List<BranchListDto> branchListDtos = BranchListDtoMapper.asDto(branchService.findAllBranches());
        if(branchListDtos.isEmpty()){
            return new ResponseEntity<List<BranchListDto>>(HttpStatus.NO_CONTENT);
            //You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<BranchListDto>>(branchListDtos, HttpStatus.OK);
    }

    // Retrieve single branch
    @RequestMapping(value = "/branches/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BranchFormDto> getBranch(@PathVariable("id") short id) {
        BranchFormDto branchFormDto = BranchFormDtoMapper.asDto(branchService.findBranchById(id));
        if (branchFormDto == null) {
            return new ResponseEntity<BranchFormDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BranchFormDto>(branchFormDto, HttpStatus.OK);
    }

    // Create a branch
    @RequestMapping(value = "/branches", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBranch(@RequestBody BranchFormDto branchFormDto, UriComponentsBuilder ucBuilder) {

        Branch newBranch = BranchFormDtoMapper.asEntity(branchFormDto);
        if (branchService.isBranchExist(newBranch)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        branchService.saveBranch(newBranch);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/branches/{id}").buildAndExpand(newBranch.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    // Update a branch
    @RequestMapping(value = "/branches/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BranchFormDto> updateBranch(@PathVariable("id") short id,
                                                      @RequestBody BranchFormDto branchFormDto) {

        BranchFormDto currentBranch = BranchFormDtoMapper.asDto(branchService.findBranchById(id));

        if (currentBranch == null) {
            return new ResponseEntity<BranchFormDto>(HttpStatus.NOT_FOUND);
        }

        branchService.updateBranch(BranchFormDtoMapper.asEntity(branchFormDto));
        return new ResponseEntity<BranchFormDto>(branchFormDto, HttpStatus.OK);
    }

    // Delete a branch
    @RequestMapping(value = "/branches/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<BranchFormDto> deleteBranch(@PathVariable("id") short id) {

        Branch branch = branchService.findBranchById(id);
        if (branch == null) {
            return new ResponseEntity<BranchFormDto>(HttpStatus.NOT_FOUND);
        }

        branchService.deleteBranchById(id);
        return new ResponseEntity<BranchFormDto>(HttpStatus.NO_CONTENT);
    }

}
