package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    // repository와 달리 비즈니스적인 메서드 모음
    // test 생성시 ctrl + shift + T

//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

    // repository를 직접 생성하는 것이 아닌, 외부에서 넣어주도록 바꾸는 것
    // 의존성 주입(Dependency Injection)

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 이미 작성 완료되어 있는 클래스나 메소드 위에 /** 를 입력하고 Enter를 누르면
    // 알아서 필요한 param, return 등의 태그를 생성
    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원X
        // ctrl + alt + v : 변수 자동 추출

        // ctrl + alt + shift + T : 선택지 중에 extract method를 할 수 있음
        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
