package com.example.demo.interest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestRepository extends JpaRepository<Interest, Long> {
    List<Interest> findAllByMemberId(long memberId);
    List<Interest> findAllByMerchandiseId(long merchandiseId);
}
