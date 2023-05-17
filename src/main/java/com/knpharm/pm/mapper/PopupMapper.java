package com.knpharm.pm.mapper;

import com.knpharm.pm.dto.PopupDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PopupMapper {
    List<PopupDto> selectPopupList(String brandCode) throws Exception;

    PopupDto selectPopup(int popupSeq) throws Exception;

    int insertPopup(PopupDto popupDto) throws Exception;

    int updatePopup(PopupDto popupDto) throws Exception;
}
