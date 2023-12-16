package com.example.SectionService.Controller;


import com.example.SectionService.DTO.CreateSectionDTO;
import com.example.SectionService.DTO.ResponeSectionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/section")
public interface ISectionController {

    @PostMapping("/addSection")
    @ResponseStatus(HttpStatus.CREATED)
    ResponeSectionDTO createSection(@RequestBody CreateSectionDTO dto) throws  IOException;


    @GetMapping("/getSections")
    List<ResponeSectionDTO> getSections();

    @GetMapping("/getSection/{id}")
    List<ResponeSectionDTO> getSectionByCourseID(@PathVariable int id);


    @GetMapping("/deleteSectionByCourseID/{courseId}")
    public int deleteSectionByCourseID( @PathVariable int courseId);


}
