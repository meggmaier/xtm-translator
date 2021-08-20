package com.translator.xtm.repository;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsageHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String word;

    @Column
    private Date dateOfUsage;

    private Long ranking;

    public UsageHistory(String word) {
        this.word = word;
        this.dateOfUsage = new Date();
    }

    public UsageHistory(String word, Long ranking) {
        this.word = word;
        this.ranking = ranking;
    }
}
