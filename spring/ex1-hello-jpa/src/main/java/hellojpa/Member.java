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

    @Id
    private Long id;
    @Column(name = "name")
    private String username;
    private Integer age;
    // @Enumerated : 보통 db에서 enum type을 못쓰므로 지정하는 어노테이션
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;

    // @Transient는 DB에 반영하지 않고 메모리안에서만 실행
    @Transient
    private int temp;
    public Member() {
    }



}
