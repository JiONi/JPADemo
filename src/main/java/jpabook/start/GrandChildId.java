package jpabook.start;

import java.io.Serializable;

public class GrandChildId implements Serializable {

    private ChildId child;  //GrandChild.child 매핑
    private String id;      //GrandChild.id 매핑
}
