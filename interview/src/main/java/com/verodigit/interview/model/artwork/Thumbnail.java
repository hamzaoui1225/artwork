package com.verodigit.interview.model.artwork;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Thumbnail {
    public String lqip;
    public Integer width;
    public Integer height;
    public String alt_text;
}
