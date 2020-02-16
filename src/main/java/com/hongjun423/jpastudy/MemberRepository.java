package com.hongjun423.jpastudy;

import com.hongjun423.jpastudy.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("tmpMemberRepository")
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }
}
