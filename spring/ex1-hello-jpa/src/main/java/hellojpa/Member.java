package hellojpa;

import javax.persistence.*;
import java.util.Date;


// JPA를 사용한다고 지정하기 위해 @Entity 사용
@Entity
// 아래와 같은 형식으로 테이블을 지정 가능.
// @Table(name = "USER")
public class Member {

    // @Column(name = "username")
    // 컬럼도 마찬가지

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

//    public Long getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(Long teamId) {
//        this.teamId = teamId;
//    }

    @Id @GeneratedValue
    private Long id;
    @Column(name = "USERNAME")
    private String name;
    private int age;

//    @Column(name="TEAM_ID")
//    private Long teamId;

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {
        this.team = team;

        team.getMembers().add(this);
    }

    // 객체 지향 모델링을 위해(객체 연관관계 사용)
    // 관계와 조인하는 컬럼을 적어주어야 함
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;




//    private Integer age;
    // @Enumerated : 보통 db에서 enum type을 못쓰므로 지정하는 어노테이션
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//    @Lob
//    private String description;
//
//    // @Transient는 DB에 반영하지 않고 메모리안에서만 실행
//    @Transient
//    private int temp;
//    public Member() {
//    }




}
