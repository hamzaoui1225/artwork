package com.verodigit.interview.controller;

import com.verodigit.interview.exception.APIException;
import com.verodigit.interview.model.artwork.ArtWorkList;
import com.verodigit.interview.model.artwork.ArtWorkSingle;
import com.verodigit.interview.service.ArtWorkService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Art Work")
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtWorkController {

    final ArtWorkService artService;

    public ArtWorkController(ArtWorkService artService) {
        this.artService = artService;
    }

    @GetMapping("artwork")
    ArtWorkList getArtWorkPage(@RequestParam Integer page) throws APIException {
        return artService.getArkWorks(page);
    }

    @GetMapping("artwork/{id}")
    ArtWorkSingle findArtWorkById(@PathVariable("id") Integer id) throws APIException {
        return artService.findArtWorkById(id);
    }

    @GetMapping("artwork/search/{query}")
    ArtWorkList findArtWorkQuery(@PathVariable("query") String query, @RequestParam Integer page) throws APIException {
        return artService.searchForArtWorks(query, page);
    }

}
