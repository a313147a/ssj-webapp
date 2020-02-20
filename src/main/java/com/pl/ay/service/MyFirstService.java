package com.pl.ay.service;

import com.pl.ay.entity.QtNewIPOStock;
import com.pl.ay.model.QtNewIPOStockModel;
import com.pl.ay.repository.MyFirstRepository;
import com.pl.ay.util.CopyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pl on 2019/8/30
 */
@Service
@Slf4j
public class MyFirstService {

    @Autowired
    private MyFirstRepository myFirstRepository;

    public List<QtNewIPOStockModel> findByTradeDate(){
        List<QtNewIPOStockModel> result = new ArrayList<>();
        List<QtNewIPOStock> list =  myFirstRepository.findByTradeDate("20190830");
        result = CopyUtils.copyList(list, QtNewIPOStockModel.class);
        return  result;
    }
}
