package com.example.up.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude =  {"title", "done"})
public class Task {
    @Id
   private String id;
    private String title;
    private Boolean done;
}
