package com.shohrab.notepadservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Note extends BaseEntity {

    @Column
    private String title;

    @Column
    private String body;

}