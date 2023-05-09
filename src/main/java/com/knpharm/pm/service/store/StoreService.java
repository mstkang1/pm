package com.knpharm.pm.service.store;

import com.knpharm.pm.dto.StoreDto;

import java.util.List;

public interface StoreService {
    List<StoreDto> selectStoreList(StoreDto storeDto) throws Exception;
}
