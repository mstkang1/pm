package com.knpharm.pm.service.Popup.Impl;

import com.knpharm.pm.dto.PopupDto;
import com.knpharm.pm.mapper.PopupMapper;
import com.knpharm.pm.service.Popup.PopupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopupServiceImpl implements PopupService {

    @Autowired
    private PopupMapper popupMapper;

    @Override
    public List<PopupDto> selectPopupList(String brandCode) throws Exception {
        return popupMapper.selectPopupList(brandCode);
    }

    @Override
    public PopupDto selectPopup(int popupSeq) throws Exception {
        return popupMapper.selectPopup(popupSeq);
    }

    @Override
    public int insertPopup(PopupDto popupDto) throws Exception {
        return popupMapper.insertPopup(popupDto);
    }

    @Override
    public int updatePopup(PopupDto popupDto) throws Exception {
        return popupMapper.updatePopup(popupDto);
    }
    
}
