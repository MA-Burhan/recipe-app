package maburhan.recipeapp.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private String recipeNotes;

    @OneToOne(mappedBy = "notes")
    private Recipe recipe;

}
