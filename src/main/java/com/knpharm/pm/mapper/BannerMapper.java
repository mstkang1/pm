package com.knpharm.pm.mapper;

import com.knpharm.pm.dto.BannerDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {
    List<BannerDto> selectBannerList(String brandCode) throws Exception;

    BannerDto selectBanner(int bannerSeq) throws Exception;

}
