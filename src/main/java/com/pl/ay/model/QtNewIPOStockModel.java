package com.pl.ay.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by pl on 2019/8/30
 */
@Data
public class QtNewIPOStockModel {
    private String prodCode;
    private String prodName;
    private String secuMarket;
    private String stockCode;
    private Date prospectusDate;
    private Double issuePrice;
    private Integer issueVol;
    private Double allotMax;
    private Double dilutedPeRadio;
    private Double naps;
    private String indurstry;
    private String listedSector;
}
