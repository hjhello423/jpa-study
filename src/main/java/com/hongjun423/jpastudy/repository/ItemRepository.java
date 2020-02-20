package com.hongjun423.jpastudy.repository;

import com.hongjun423.jpastudy.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item); // item은 영속화 전에 id값 없음
        } else {
            em.merge(item); //update
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i form Item i", Item.class)
                .getResultList();
    }

}
