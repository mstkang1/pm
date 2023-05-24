package com.knpharm.pm.web;

import com.knpharm.pm.dto.PopupDto;
import com.knpharm.pm.service.Popup.PopupService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

@Controller
@RequestMapping("/popup")
public class PopupController {

    @Autowired
    private PopupService popupService;

    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    @RequestMapping("/download/{pmFlag}/{popupSeq}")
    public void process(@PathVariable(name = "pmFlag") String pmFlag, @PathVariable(name = "popupSeq") int popupSeq, HttpServletResponse response) throws Exception {
        try {
            // 서비스를 통해 첨부파일 가져오기
            PopupDto popup = popupService.selectPopup(popupSeq);


            String originalName = "";
            String filePath = uploadPath + File.separatorChar;
            String fileName = "";

            if ("P".equals(pmFlag)) {
                // 파일명에 한글이 있는경우 처리
                originalName = new String(popup.getPopupPcOrgFileName().getBytes("utf-8"), "iso-8859-1");
                fileName = popup.getPopupPcSaveFileName();
            } else {
                // 파일명에 한글이 있는경우 처리
                originalName = new String(popup.getPopupMoOrgFileName().getBytes("utf-8"), "iso-8859-1");
                fileName = popup.getPopupMoSaveFileName();
            }

            String path = filePath + fileName;
            String exten = originalName.substring(originalName.lastIndexOf(".")+1, originalName.length());//확장자

            File file = new File(path);
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));

            //형식을 모르는 파일첨부용 contentType
            response.setContentType("image/" + exten);
            response.setHeader("Content-Disposition", "attachment;filename=" + originalName); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더


            //파일복사
            FileCopyUtils.copy(in, response.getOutputStream());
            in.close();
            response.getOutputStream().flush();
            response.getOutputStream().close();

        } catch (Exception e) {
            throw new Exception("download error");

        }
    }
}
