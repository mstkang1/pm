package com.knpharm.pm.domain;

import lombok.Data;


@Data
public class StoreVO {
    private int storeSeq;

    private String brandCode;

    private String productName;

    private String storeName;

    private String address;

    private float latitude;

    private float longitude;

    private int distance;

}
