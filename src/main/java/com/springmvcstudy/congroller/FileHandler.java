package com.springmvcstudy.congroller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileHandler {

    @PostMapping("/upload")
    public String upload(MultipartFile img, HttpServletRequest request) {
        if (img.getSize() > 0) {
            // 获取保存上传文件的 file 路径
            String path = request.getServletContext().getRealPath("file");
            // 获取上传的文件名
            String name = img.getOriginalFilename();
            File file = new File(path,name);
            try {
                img.transferTo(file);
                // 保存上传之后的文件路径
                request.setAttribute("path", "/file/" + name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }

    @PostMapping("/uploads")
    public String uploads(MultipartFile[] imgs, HttpServletRequest request) {
        List<String> files = new ArrayList<>(3);

        for (MultipartFile img : imgs) {
            if (img.getSize() > 0) {
                // 获取保存上传文件的 file 路径
                String path = request.getServletContext().getRealPath("file");
                // 获取上传的文件名
                String name = img.getOriginalFilename();
                File file = new File(path,name);
                try {
                    img.transferTo(file);
                    // 保存上传之后的文件路径
                    files.add("/file/" + name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("files", files);
        return "uploads";
    }

    @GetMapping("/download/{name}")
    public void download(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response) {
        if (name != null) {
            name += ".png";
            String path = request.getServletContext().getRealPath("file");
            File file = new File(path, name);
            OutputStream outputStream = null;
            if (file.exists()) {
                response.setContentType("application/force-download");
                response.setHeader("Content-Disposition", "attachment;filename=" + name);
                try {
                    outputStream = response.getOutputStream();
                    outputStream.write(FileUtils.readFileToByteArray(file));
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
