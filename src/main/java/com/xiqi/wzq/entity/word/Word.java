package com.xiqi.wzq.entity.word;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long eid;

    @JsonProperty("word")
    @Column(length = 50)
    String word;

    String category;

    @JsonProperty("poss")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "word_id")
    List<Pos> poss;

    @JsonProperty("wfss")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "word_id")
    List<Wfs> wfss;

}
