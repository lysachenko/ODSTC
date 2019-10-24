package com.netcracker.tc.client.ui.widget.resume;

import com.github.gwtbootstrap.client.ui.FileUpload;
import com.github.gwtbootstrap.client.ui.HelpInline;
import com.github.gwtbootstrap.client.ui.Image;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.netcracker.tc.shared.ServicePath;

public class UploadPhotoWidget extends Composite {

    private FileUpload fileUpload;
    private FormPanel form;
    private Image image;
    private int version = 0;

    private String userImage;

    public UploadPhotoWidget() {
        VerticalPanel verticalPanel = new VerticalPanel();
        initImage();
        initUploadForm();

        HelpInline helpInline = new HelpInline();
        helpInline.setText("Фотография:");
        verticalPanel.add(helpInline);
        verticalPanel.add(image);
        verticalPanel.add(form);

        initWidget(verticalPanel);
    }

    private void initUploadForm() {
        form = new FormPanel();
        form.setAction(ServicePath.IMAGE_SERVICE_PATH);
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);

        form.setWidget(initFileUpload());
        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                if (event.getResults().contains("Невозможно")) {
                    Window.alert(event.getResults());
                } else {
                    setUserImage(event.getResults());
                }
            }
        });
    }

    private VerticalPanel initFileUpload() {
        VerticalPanel uploadPanel = new VerticalPanel();
        fileUpload = new FileUpload();
        fileUpload.setName("uploadFileField");
        fileUpload.setTitle("Загрузить новую фотографию");
        fileUpload.setSearchQuery(false);
        fileUpload.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent event) {
                if (!fileUpload.getFilename().isEmpty()) {
                    form.submit();
                }
            }
        });
        uploadPanel.add(fileUpload);

        return uploadPanel;
    }

    private void initImage() {
        image = new Image();
        image.setPixelSize(300, 300);
    }

    public void setUserImage(String userImage) {
        if (userImage != null) {
            version++;
            this.userImage = userImage;
            image.setUrl(GWT.getHostPageBaseURL() + "/tmp/user/photo/" + userImage + "?version=" + version);
        } else {
            image.setUrl(GWT.getHostPageBaseURL() + "user/photo/" + "noPhoto" + "?version=" + version);
        }
    }

    public String getUserPhoto() {
        return userImage;
    }

    public void disableFields(){
        fileUpload.setVisible(false);
    }
}