package com.netcracker.tc.shared.action.user;

import com.netcracker.tc.shared.action.common.PagingResult;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;
import com.netcracker.tc.shared.model.user.UserDTO;

/**
 * Created by unconsionable on 15.06.2014.
 */
public class GetUserListResult extends PagingResult<UserDTO> {

    public GetUserListResult(PagingLoadResultDTO<UserDTO> pagingLoadResult) {
        super(pagingLoadResult);
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private GetUserListResult(){
    }
}
