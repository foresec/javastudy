package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        // 트랜젝션 필요
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member = new Member();
//
//            member.setId(1L);
//            member.setName("hello");
//            em.persist(member);


//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId());
            // 삭제
//            em.remove(findMember);
            // 수정 : 뭔가 바뀌면 JPA에서 알아서 DB에도 업데이트 해줌
//            findMember.setName("HelloJPA");


            tx.commit();

            // JPQL :  DB테이블이 아닌 객체나 엔티티를 대상으로 하는 객체 지향 쿼리
        } catch (Exception e) {
            tx.rollback();

        } finally {
            // EntityManager는 사용이 다끝나면 닫아줘야함
            em.close();
            
        }


        emf.close();

    }

}
