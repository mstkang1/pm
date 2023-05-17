package com.knpharm.pm.service.banner.impl;

import com.knpharm.pm.dto.BannerDto;
import com.knpharm.pm.mapper.BannerMapper;
import com.knpharm.pm.service.banner.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<BannerDto> selectBannerList(String  brandCode) throws Exception {
        return bannerMapper.selectBannerList(brandCode);
    }

    @Override
    public BannerDto selectBanner(int  bannerSeq) throws Exception {
        return bannerMapper.selectBanner(bannerSeq);
    }
}
