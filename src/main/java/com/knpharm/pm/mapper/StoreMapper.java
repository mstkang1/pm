package com.knpharm.pm.mapper;

import com.knpharm.pm.dto.StoreDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    List<StoreDto> selectStoreList(StoreDto storeDto) throws Exception;
}
