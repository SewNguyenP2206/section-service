package com.example.SectionService.Service;


import com.example.SectionService.DTO.CreateSectionDTO;
import com.example.SectionService.DTO.ResponeSectionDTO;
import com.example.SectionService.Entity.Section;
import com.example.SectionService.ResponeObject.ResponeObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISectionService {


    Section createSection(CreateSectionDTO dto);

    List<Section> getSectionList(int ID);

    public ResponeSectionDTO fromSectionIntoResponeSectionDTO(Section section);

    public int deleteSectionByCourseID(int courseId);

    List<Section> getSections();

    List<ResponeSectionDTO> getSectionByCourseID(int id);



}
