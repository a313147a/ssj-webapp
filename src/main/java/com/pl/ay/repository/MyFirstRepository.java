package com.pl.ay.repository;

import com.pl.ay.entity.QtNewIPOStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by pl on 2019/8/30
 */
public interface MyFirstRepository extends JpaRepository<QtNewIPOStock, Long>{

    @Query(" FROM QtNewIPOStock t WHERE to_char(t.prospectusDate, 'yyyyMMdd')=?1")
    List<QtNewIPOStock> findByTradeDate(String tradeDate);
}
