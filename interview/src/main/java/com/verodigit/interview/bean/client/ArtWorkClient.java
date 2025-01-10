package com.verodigit.interview.bean.client;

import com.verodigit.interview.model.artwork.ArtWorkList;
import com.verodigit.interview.model.artwork.ArtWorkSingle;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

import static com.verodigit.interview.config.AdapterWebClientConfig.ADAPTER_WEBCLIENT_BEAN_NAME;

@Component
public class ArtWorkClient {

    @Autowired
    @Qualifier(ADAPTER_WEBCLIENT_BEAN_NAME)
    @NotNull
    private final WebClient client;



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
