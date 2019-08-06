package jpabook.start;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ChildIdWithEmbeddedID implements Serializable {
    private String parentId;    //@MapsId("parentId")로 매핑

    @Column(name = "CHILD_ID")
    private String id;
}
