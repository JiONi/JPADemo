package jpabook.start;

import javax.persistence.*;
import java.util.List;

@Entity

public class Product {

    @Id
    private String id;

    @ManyToMany(mappedBy = "products")  //역방향
    private List<Member> members;

    public List<Member> getMembers(){
        return members;
    }
}
