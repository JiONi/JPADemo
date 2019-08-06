package jpabook.start;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class GrandChildIdWithEmbeddedID implements Serializable {
    private ChildId childId;    //MapsId("childId")로 매핑

    @Column(name="GRANDCHILD_ID")
    private String id;
}
