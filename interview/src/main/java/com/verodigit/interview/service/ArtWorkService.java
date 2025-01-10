package com.verodigit.interview.service;

import com.verodigit.interview.bean.client.ArtWorkClient;
import com.verodigit.interview.exception.APIException;
import com.verodigit.interview.model.artwork.ArtWorkList;
import com.verodigit.interview.model.artwork.ArtWorkSingle;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtWorkService {

    final ArtWorkClient client;

    String fixImageLink(String image) {
        return "https://www.artic.edu/iiif/2/" + image + "/full/400,/0/default.jpg";
    }

    void fixImageList(ArtWorkList list) {
        list.data.forEach(artWork -> artWork.setImage_id(fixImageLink(artWork.getImage_id())));
    }

    public ArtWorkList searchForArtWorks(String query, Integer page) throws APIException {
        if (StringUtils.isEmpty(query)) throw new APIException("query must be present.");
        if (page < 1) throw new APIException("page number must be positive");
        var res = client.findArtWork(query, page);
        fixImageList(res);
        return res;
    }

    public ArtWorkSingle findArtWorkById(Integer id) throws APIException {
        if (id < 0) throw new APIException("invalid id");
        var res = client.getArtWorkById(id);
        res.data.setImage_id(fixImageLink(res.data.getImage_id()));
        return res;
    }

    public ArtWorkList getArkWorks(Integer page) throws APIException {
        if (page < 1) throw new APIException("page number must be positive");
        var res = client.fetchArtWorkData(page);
        fixImageList(res);
        return res;
    }


}
