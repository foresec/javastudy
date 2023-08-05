package hello.hellospring.domain;

import jakarta.persistence.*;

// JPA가 관리하는 Entity
@Entity
public class Member {

    // IDENTITY : db에 값을 넣으면 db가 알아서 id를 자동 생성
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "username")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
