package jpabook.start;

import javax.persistence.*;

@Entity
public class ParentWithEmbeddedID {
    @Id
    @Column(name = "PARENT_ID")
    private String id;

    private String name;
}

