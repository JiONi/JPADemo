package jpabook.start;

import javax.persistence.*;

@Entity
public class ChildWithEmbeddedID {
    @EmbeddedId
    private ChildIdWithEmbeddedID id;

    @MapsId("parentId") //ChildId.parentId 매핑
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parent parent;

    private String name;

}
