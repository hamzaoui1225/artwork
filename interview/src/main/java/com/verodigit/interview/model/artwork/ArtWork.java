package com.verodigit.interview.model.artwork;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtWork {
     Integer id;
    @JsonIgnore
     String api_model;
    @JsonIgnore
     String api_link;
    @JsonIgnore
     Boolean is_boosted;
    @JsonProperty("title")
     String title;
    @JsonIgnore
     Object alt_titles;
    @JsonIgnore
     Thumbnail thumbnail;
    @JsonIgnore
     String main_reference_number;
    @JsonIgnore
     Boolean has_not_been_viewed_much;
    @JsonIgnore
     Integer boost_rank;
    @JsonIgnore
     Integer date_start;
    @JsonProperty("date_end")
     Integer date_end;
    @JsonIgnore
     String date_display;
    @JsonIgnore
     String date_qualifier_title;
    @JsonIgnore
     Integer date_qualifier_id;
    @JsonIgnore
     String artist_display;
    @JsonIgnore
     String place_of_origin;
    @JsonProperty("description")
     String description;
    @JsonProperty("short_description")
     String short_description;
    @JsonIgnore
     String dimensions;
    @JsonIgnore
     ArrayList<DimensionsDetail> dimensions_detail;
    @JsonIgnore
     String medium_display;
    @JsonIgnore
     String inscriptions;
    @JsonIgnore
     String credit_line;
    @JsonIgnore
     String catalogue_display;
    @JsonIgnore
     String ation_history;
    @JsonIgnore
     String exhibition_history;
    @JsonProperty("provenance_text")
     String provenance_text;
    @JsonIgnore
     Object edition;
    @JsonIgnore
     String publishing_verification_level;
    @JsonIgnore
     Integer Integerernal_department_id;
    @JsonIgnore
     Integer fiscal_year;
    @JsonIgnore
     Object fiscal_year_deaccession;
    @JsonIgnore
     Boolean is__domain;
    @JsonIgnore
     Boolean is_zoomable;
    @JsonIgnore
     Integer max_zoom_window_size;
    @JsonIgnore
     String copyright_notice;
    @JsonIgnore
     Boolean has_multimedia_resources;
    @JsonIgnore
     Boolean has_educational_resources;
    @JsonIgnore
     Boolean has_advanced_imaging;
    @JsonIgnore
     Double colorfulness;
    @JsonIgnore
     Color color;
    @JsonIgnore
     Double latitude;
    @JsonIgnore
     Double longitude;
    @JsonIgnore
     String latlon;
    @JsonIgnore
     Boolean is_on_view;
    @JsonIgnore
     String on_loan_display;
    @JsonIgnore
     String gallery_title;
    @JsonIgnore
     Integer gallery_id;
    @JsonIgnore
     Object nomisma_id;
    @JsonIgnore
     String artwork_type_title;
    @JsonIgnore
     Integer artwork_type_id;
    @JsonIgnore
     String department_title;
    @JsonIgnore
     String department_id;
    @JsonIgnore
     Integer artist_id;
    @JsonIgnore
     String artist_title;
    @JsonIgnore
     ArrayList<Object> alt_artist_ids;
    @JsonIgnore
     ArrayList<Integer> artist_ids;
    @JsonIgnore
     ArrayList<String> artist_titles;
    @JsonIgnore
     ArrayList<String> category_ids;
    @JsonIgnore
     ArrayList<String> category_titles;
    @JsonIgnore
     ArrayList<String> term_titles;
    @JsonIgnore
     String style_id;
    @JsonIgnore
     String style_title;
    @JsonIgnore
     ArrayList<String> alt_style_ids;
    @JsonIgnore
     ArrayList<String> style_ids;
    @JsonIgnore
     ArrayList<String> style_titles;
    @JsonIgnore
     String classification_id;
    @JsonIgnore
     String classification_title;
    @JsonIgnore
     ArrayList<String> alt_classification_ids;
    @JsonIgnore
     ArrayList<String> classification_ids;
    @JsonIgnore
     ArrayList<String> classification_titles;
    @JsonIgnore
     String subject_id;
    @JsonIgnore
     ArrayList<String> alt_subject_ids;
    @JsonIgnore
     ArrayList<String> subject_ids;
    @JsonIgnore
     ArrayList<String> subject_titles;
    @JsonIgnore
     String material_id;
    @JsonIgnore
     ArrayList<String> alt_material_ids;
    @JsonIgnore
     ArrayList<String> material_ids;
    @JsonIgnore
     ArrayList<String> material_titles;
    @JsonIgnore
     String technique_id;
    @JsonIgnore
     ArrayList<String> alt_technique_ids;
    @JsonIgnore
     ArrayList<String> technique_ids;
    @JsonIgnore
     ArrayList<String> technique_titles;
    @JsonIgnore
     ArrayList<String> theme_titles;
    @JsonAlias("image_id")
    @JsonProperty("image")
     String image_id;
    @JsonIgnore
     ArrayList<String> alt_image_ids;
    @JsonIgnore
     ArrayList<String> document_ids;
    @JsonIgnore
     ArrayList<String> sound_ids;
    @JsonIgnore
     ArrayList<Object> video_ids;
    @JsonIgnore
     ArrayList<String> text_ids;
    @JsonIgnore
     ArrayList<Double> section_ids;
    @JsonIgnore
     ArrayList<String> section_titles;
    @JsonIgnore
     ArrayList<Object> site_ids;
    @JsonIgnore
     String suggest_autocomplete_boosted;
    @JsonIgnore
     ArrayList<SuggestAutocompleteAll> suggest_autocomplete_all;
    @JsonIgnore
     Date source_updated_at;
    @JsonIgnore
     Date updated_at;
    @JsonIgnore
     Date timestamp;
}
