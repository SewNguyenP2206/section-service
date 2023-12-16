package com.example.SectionService.Controller;


import com.example.SectionService.DTO.CreateSectionDTO;
import com.example.SectionService.DTO.ResponeSectionDTO;
import com.example.SectionService.ResponeObject.ResponeObject;
import com.example.SectionService.Service.ServiceOfSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://academy.arthub.s3-website-ap-southeast-1.amazonaws.com/", maxAge = 3600)
@RestController
public class SectionController implements ISectionController {

    @Autowired
    ServiceOfSection sectionService;

    @Override
    public ResponeSectionDTO createSection(CreateSectionDTO dto) {
        return sectionService.fromSectionIntoResponeSectionDTO(sectionService.createSection(dto));
    }

    @Override
    public List<ResponeSectionDTO> getSections() {
        return null;
    }

    @Override
    public List<ResponeSectionDTO> getSectionByCourseID(int id) {
        return sectionService.getSectionByCourseID(id);

    }

    @Override
    public int deleteSectionByCourseID(int courseId) {
        return sectionService.deleteSectionByCourseID(courseId);
    }
}
