package com.netcracker.tc.shared.action.common;

import com.netcracker.tc.shared.action.user.GetUserListResult;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.filter.UserPagingFilterDTO;
import com.netcracker.tc.shared.model.user.UserDTO;

/**
 * Created by unconsionable on 15.06.2014.
 */
public class GetUserListAction extends PagingActon<UserDTO, GetUserListResult> {

    private UserPagingFilterDTO userPagingFilterDTO;

    public GetUserListAction(PagingLoadConfigDTO pagingLoadConfig, UserPagingFilterDTO userPagingFilterDTO) {
        super(pagingLoadConfig);
        this.userPagingFilterDTO = userPagingFilterDTO;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private GetUserListAction() {
    }

    public UserPagingFilterDTO getUserPagingFilterDTO() {
        return userPagingFilterDTO;
    }

    public void setUserPagingFilterDTO(UserPagingFilterDTO userPagingFilterDTO) {
        this.userPagingFilterDTO = userPagingFilterDTO;
    }
}