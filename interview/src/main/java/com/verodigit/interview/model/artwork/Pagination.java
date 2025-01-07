package com.verodigit.interview.model.artwork;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pagination {
    @JsonIgnore
    public Integer total;
    @JsonIgnore
    public Integer limit;
    @JsonIgnore
    public Integer offset;
    @JsonProperty("total")
    public Integer total_pages;
    @JsonAlias("current_page")
    @JsonProperty("current")
    public Integer current_page;
    @JsonIgnore
    public String next_url;
}
