package com.knpharm.pm.service.Popup;


import com.knpharm.pm.dto.PopupDto;

import java.util.List;

public interface PopupService {

    PopupDto selectPopupBrand(String brandCode) throws Exception;

    PopupDto selectPopup(int popupSeq) throws Exception;

    int insertPopup(PopupDto popupDto) throws Exception;

    int updatePopup(PopupDto popupDto) throws Exception;


}
