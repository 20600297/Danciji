package com.xiqi.wzq.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UpdateVocabularyStatusDto {

    @JsonProperty("wordnumb")
    private Integer wordNumb;

    @JsonProperty("words")
    private List<String> words;

    @JsonProperty("status")
    private Integer status;
}
