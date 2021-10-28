package maburhan.recipeapp.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
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
