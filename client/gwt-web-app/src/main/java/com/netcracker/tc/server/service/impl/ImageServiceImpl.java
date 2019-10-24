package com.netcracker.tc.server.service.impl;

import com.netcracker.tc.server.service.api.ImageService;
import com.netcracker.tc.server.service.api.ResumeService;
import com.netcracker.tc.server.service.api.UserService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.server.servlet.Session;
import com.netcracker.tc.shared.model.user.UserDTO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.File;

@Component
public class ImageServiceImpl implements ImageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);

    public static String userPhotoFolderPath;

    @Autowired
    UserService userService;

    @Autowired
    ResumeService resumeService;

    ServletContext servletContext;

    @Autowired
    public void setServletContext(ServletContext servletContext){
        this.servletContext = servletContext;

        userPhotoFolderPath = File.separator + "tmp" + File.separator + "user" + File.separator + "photo";
        File uploadFile = new File(userPhotoFolderPath);
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }
    }

    @Override
    public String saveUserPhoto(FileItem item) throws ServiceException {
        if (!item.isFormField()) {
            Long userId = Session.getUserId();
            UserDTO user = userService.getUser(userId);

            deleteUserPhoto(user);
            String fileName = item.getName();
            if (fileName != null) {
                fileName = user.getLogin() + "." + FilenameUtils.getExtension(fileName);
            }

            File uploadedFile = new File(userPhotoFolderPath, fileName);
            try {
                if (uploadedFile.createNewFile()) {
                    item.write(uploadedFile);

                    resumeService.savePhotoPath(userId, fileName);

                    return fileName;
                }
            } catch (Exception e) {
                LOGGER.error("Ошибка сохранения UserPhoto. ", e);
                throw new ServiceException("Can't save photo. Please, contact administrator.");
            }
        }

        return null;
    }

    @Override
    public void deleteUserPhoto() throws ServiceException{
        Long userId = (Long) Session.getUserId();
        UserDTO user = userService.getUser(userId);
        deleteUserPhoto(user);
    }

    private void deleteUserPhoto(UserDTO user){
        if (user.getResume() != null && user.getResume().getPhotoPath() != null) {
            File file = new File(userPhotoFolderPath, user.getResume().getPhotoPath());
            file.delete();
        }
    }

    public String getUserPhotoFolderPath() {
        return userPhotoFolderPath;
    }
}
