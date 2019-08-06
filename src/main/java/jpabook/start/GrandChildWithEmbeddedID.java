package jpabook.start;

import javax.persistence.*;

@Entity
public class GrandChildWithEmbeddedID {

    @EmbeddedId
    private GrandChildWithEmbeddedID id;

    @MapsId("childId")  //GrandChildIdWithEmbeddedID.childId 매핑
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "PARENT_ID"), @JoinColumn(name = "CHILD_ID")})
    private Child child;

    private String name;

}
