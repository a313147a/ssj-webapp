package com.pl.ay.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by pl on 2019/7/10
 * 新股列表
 */
@Data
@Entity
@Table(name = "T_NEW_STOCK_INFO")
public class QtNewIPOStock extends BaseEntity{

    @Column(name = "PROD_CODE")
    private String prodCode;

    @Column(name = "PROD_NAME")
    private String prodName;

    @Column(name = "SECU_MARKET")
    private String secuMarket;

    @Column(name = "STOCK_CODE")
    private String stockCode;

    @Column(name = "PROSPECTUS_DATE")
    private Date prospectusDate;

    @Column(name = "ISSUE_PRICE")
    private Double issuePrice;

    @Column(name = "ISSUE_VOL")
    private Integer issueVol;

    @Column(name = "ALLOT_MAX")
    private Double allotMax;

    @Column(name = "DILUTED_PE_RATIO")
    private Double dilutedPeRadio;

    @Column(name = "NAPS")
    private Double naps;

    @Column(name = "INDURSTRY")
    private String indurstry;

    @Column(name = "LISTED_SECTOR")
    private String listedSector;

}
