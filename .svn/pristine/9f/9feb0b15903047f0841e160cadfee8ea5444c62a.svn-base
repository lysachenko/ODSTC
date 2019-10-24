package com.netcracker.tc.server.service.api;

import com.netcracker.tc.server.persistence.model.user.User;
import com.netcracker.tc.server.service.exception.ServiceException;
import org.apache.commons.fileupload.FileItem;

import java.io.IOException;

public interface ImageService {

    String saveUserPhoto(FileItem item) throws ServiceException, IOException;

    void deleteUserPhoto() throws ServiceException;

    String getUserPhotoFolderPath();
}