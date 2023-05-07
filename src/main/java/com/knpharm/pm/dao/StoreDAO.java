package com.knpharm.pm.dao;

import com.knpharm.pm.domain.StoreVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreDAO {
    public List<StoreVO> listStore(StoreVO storeVO);
}
