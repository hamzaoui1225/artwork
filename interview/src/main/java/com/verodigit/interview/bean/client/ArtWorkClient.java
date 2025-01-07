package com.verodigit.interview.bean.client;

import com.verodigit.interview.model.artwork.ArtWorkList;
import com.verodigit.interview.model.artwork.ArtWorkSingle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@Component
public class ArtWorkClient {
    private final WebClient client;

    public ArtWorkClient(@Value("${artWork.baseUrl}") String baseUrl
    ){
        this.client = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    @Cacheable("artWorkPages")
    public ArtWorkList fetchArtWorkData(Integer pageNumber) {
        return client
                .get().uri("?fields=id,title,image_id,description,short_description,provenance_text,date_end&page=" + pageNumber)
                .retrieve()
                .bodyToMono(ArtWorkList.class)
                .block();
    }
    @Cacheable("artWorkId")
    public ArtWorkSingle getArtWorkById(Integer id) {
        return client
                .get().uri("/" + id)
                .retrieve()
                .bodyToMono(ArtWorkSingle.class)
                .block();
    }

    @Cacheable("artWorkQuery")
    public ArtWorkList findArtWork(String query, Integer page) {
        return client
                .get().uri("/search?fields=id,title,image_id,description,short_description,provenance_text,date_end&q=" + query + "&page=" + page)
                .retrieve()
                .bodyToMono(ArtWorkList.class)
                .block();
    }

}
