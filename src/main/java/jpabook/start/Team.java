package jpabook.start;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<Member>();

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Team(String id, String name){
        this.id = id;
        this.name = name;
    }

    public List<Member> getMembers(){
        return members;
    }

    public void addMember(Member member){
        this.members.add(member);

        //무한루프에 빠지지 않도록 체크
        if(member.getTeam() != this){
            member.setTeam(this);
        }
    }
}
