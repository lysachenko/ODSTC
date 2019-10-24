package com.netcracker.tc.shared.action.resume;

import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.shared.model.user.UserStatusDTO;

public class EditUserStatusAction extends UnsecuredActionImpl<NoResult> {

    private Long userId;

    private UserStatusDTO userStatusDTO;

    private String mailResult;
    private String mailSubject;


    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private EditUserStatusAction() {
    }

    public UserStatusDTO getUserStatusDTO() {
        return userStatusDTO;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMailResult() {
        return mailResult;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public EditUserStatusAction(UserStatusDTO userStatusDTO, Long userId , String mailBody, String mailSubject) {
        this.userStatusDTO = userStatusDTO;
        this.userId = userId;
        this.mailResult = mailBody;
        this.mailSubject = mailSubject;

    }

    public void setUserStatusDTO(UserStatusDTO userStatusDTO) {
        this.userStatusDTO = userStatusDTO;
    }
}