package jpabook.start;

import java.io.Serializable;

public class ChildId implements Serializable {
    private String parent;  //Child.parent 매핑
    private String childId; //Child.childId 매핑
}
