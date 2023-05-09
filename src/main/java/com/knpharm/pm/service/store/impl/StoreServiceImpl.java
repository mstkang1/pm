package com.knpharm.pm.service.store.impl;

import com.knpharm.pm.dto.StoreDto;
import com.knpharm.pm.mapper.StoreMapper;
import com.knpharm.pm.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<StoreDto> selectStoreList(StoreDto storeDto) throws Exception {
        return storeMapper.selectStoreList(storeDto);
    }
}
