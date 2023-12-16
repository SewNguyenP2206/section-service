package com.example.SectionService.Client;

import com.example.SectionService.DTO.ResponeVideoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "VIDEO-APP",path = "/api/video")
public interface VideoClient {
    @GetMapping("/findAllVideoBySectionID/{id}")
    public List<ResponeVideoDTO> findAllVideoBySectionID(@PathVariable int id);
}
