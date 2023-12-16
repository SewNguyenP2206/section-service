package com.example.SectionService.Service;


import com.example.SectionService.Client.VideoClient;
import com.example.SectionService.DTO.CreateSectionDTO;
import com.example.SectionService.DTO.ResponeSectionDTO;
import com.example.SectionService.Entity.Section;
import com.example.SectionService.Repository.SectionRepository;
import com.example.SectionService.ResponeObject.ResponeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfSection implements ISectionService {
    @Autowired
    SectionRepository sectionRepository ;

    @Autowired
    VideoClient videoClient;


    @Override
    public ResponeSectionDTO fromSectionIntoResponeSectionDTO(Section section)
    {
        ResponeSectionDTO sectionDTO = new ResponeSectionDTO();
        sectionDTO.setId(section.getId());
        sectionDTO.setName(section.getName());
        sectionDTO.setCourseId(section.getCourseId());
        sectionDTO.setAccountId(section.getAccountId());
        sectionDTO.setVideos(videoClient.findAllVideoBySectionID(section.getId()));//FeignCall
        return sectionDTO;
    }


    @Override
    public Section createSection(CreateSectionDTO dto) {
        Section section = new Section();
        section.setName(dto.getName());
        section.setAccountId(dto.getAccountId());
        section.setCourseId(dto.getCourseId());
        return sectionRepository.save(section);
    }

    @Override
    public int deleteSectionByCourseID(int courseId)
    {
        return sectionRepository.deleteSectionsByCourseID(courseId);
    }

    @Override
    public List<Section> getSectionList(int ID) {
        List<Section> sectionList = sectionRepository.findByCourseId(ID);
        return sectionList;
    }

    @Override
    public List<Section> getSections() {
        List<Section> sectionList = sectionRepository.findAll();
        return sectionList;
    }





    @Override
    public List<ResponeSectionDTO> getSectionByCourseID(int id) {
        List<Section> foundSection = sectionRepository.findByCourseId(id);
        List<ResponeSectionDTO> responeSectionDTOS =  foundSection.stream().map(section -> fromSectionIntoResponeSectionDTO(section)).toList();
        if(responeSectionDTOS != null)
        {
           return responeSectionDTOS;
        }
        else
        {
            return null;
        }

    }
}
