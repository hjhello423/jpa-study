package com.hongjun423.jpastudy.service;

import com.hongjun423.jpastudy.MemberRepository;
import com.hongjun423.jpastudy.domain.Delivery;
import com.hongjun423.jpastudy.domain.Member;
import com.hongjun423.jpastudy.domain.Order;
import com.hongjun423.jpastudy.domain.OrderItem;
import com.hongjun423.jpastudy.domain.item.Item;
import com.hongjun423.jpastudy.repository.ItemRepository;
import com.hongjun423.jpastudy.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.ServiceMode;

@ServiceMode
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    //주문
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        //엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);

        return order.getId();
    }

    //취소
    @Transactional
    public void candelOrder(Long orderid) {
        //주문 엔티티 조히ㅗ
        Order order = orderRepository.findOne(orderid);
        //주문 취소
        order.cancel();
    }

    //검색
//    public List<Order> findOrders(OrderSearch orderSearch) {
//        return orderRepository.findAll(orderSearch);
//    }
}
