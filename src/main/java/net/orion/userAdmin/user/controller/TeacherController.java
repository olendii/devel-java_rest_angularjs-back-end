package net.orion.userAdmin.user.controller;

import net.orion.userAdmin.user.controller.dto.TeacherFormDto;
import net.orion.userAdmin.user.controller.dto.TeacherFormDtoMapper;
import net.orion.userAdmin.user.controller.dto.TeacherListDto;
import net.orion.userAdmin.user.controller.dto.TeacherListDtoMapper;
import net.orion.userAdmin.user.domain.Teacher;
import net.orion.userAdmin.user.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class TeacherController {
    
    @Autowired
    private TeacherService teacherService;

    // Retrieve all teachers
    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public ResponseEntity<List<TeacherListDto>> listAllTeachers() {
        List<TeacherListDto> teacherListDtos = TeacherListDtoMapper.asDto(teacherService.findAllTeachers());
        if(teacherListDtos.isEmpty()){
            return new ResponseEntity<List<TeacherListDto>>(HttpStatus.NO_CONTENT);
            //You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<TeacherListDto>>(teacherListDtos, HttpStatus.OK);
    }

    // Retrieve single teacher
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TeacherFormDto> getTeacher(@PathVariable("id") long id) {
        TeacherFormDto teacherFormDto = TeacherFormDtoMapper.asDto(teacherService.findTeacherById(id));
        if (teacherFormDto == null) {
            return new ResponseEntity<TeacherFormDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TeacherFormDto>(teacherFormDto, HttpStatus.OK);
    }

    // Create a teacher
    @RequestMapping(value = "/teachers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTeacher(@RequestBody TeacherFormDto teacherFormDto,
                                              UriComponentsBuilder ucBuilder) {

        Teacher newTeacher = TeacherFormDtoMapper.asEntity(teacherFormDto);
        if (teacherService.isTeacherExist(newTeacher)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        teacherService.saveTeacher(newTeacher);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/teachers/{id}").buildAndExpand(newTeacher.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    // Update a teacher
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TeacherFormDto> updateTeacher(@PathVariable("id") long id,
                                                        @RequestBody TeacherFormDto teacherFormDto) {

        TeacherFormDto currentTeacher = TeacherFormDtoMapper.asDto(teacherService.findTeacherById(id));

        if (currentTeacher == null) {
            return new ResponseEntity<TeacherFormDto>(HttpStatus.NOT_FOUND);
        }

        teacherService.updateTeacher(TeacherFormDtoMapper.asEntity(teacherFormDto));
        return new ResponseEntity<TeacherFormDto>(teacherFormDto, HttpStatus.OK);
    }

    // Delete a teacher
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TeacherFormDto> deleteTeacher(@PathVariable("id") long id) {

        Teacher teacher = teacherService.findTeacherById(id);
        if (teacher == null) {
            return new ResponseEntity<TeacherFormDto>(HttpStatus.NOT_FOUND);
        }

        teacherService.deleteTeacherById(id);
        return new ResponseEntity<TeacherFormDto>(HttpStatus.NO_CONTENT);
    }

}
