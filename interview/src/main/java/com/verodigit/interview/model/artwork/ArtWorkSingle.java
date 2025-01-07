package com.verodigit.interview.model.artwork;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtWorkSingle {
    public ArtWork data;
    @JsonIgnore
    public Info info;
    @JsonIgnore
    public Config config;
}

