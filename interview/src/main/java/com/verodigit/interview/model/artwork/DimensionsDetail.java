package com.verodigit.interview.model.artwork;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DimensionsDetail {
    public Integer depth;
    public Integer width;
    public Integer height;
    public Object diameter;
    public String clarification;
}
