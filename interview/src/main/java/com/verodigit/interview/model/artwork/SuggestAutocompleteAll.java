package com.verodigit.interview.model.artwork;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuggestAutocompleteAll {
    public ArrayList<String> input;
    public Contexts contexts;
    public int weight;
}
