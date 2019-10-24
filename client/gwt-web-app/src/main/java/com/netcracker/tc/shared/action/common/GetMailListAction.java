package com.netcracker.tc.shared.action.common;

import com.netcracker.tc.shared.action.GetMailListResult;
import com.netcracker.tc.shared.model.common.MailDTO;
import com.netcracker.tc.shared.model.common.PagingLoadConfigDTO;
import com.netcracker.tc.shared.model.filter.MailFilterDTO;

/**
 * Created by unconsionable on 15.06.2014.
 */
public class GetMailListAction extends PagingActon<MailDTO, GetMailListResult> {

    private MailFilterDTO mailPagingFilterDTO;

    public GetMailListAction(PagingLoadConfigDTO pagingLoadConfig, MailFilterDTO mailPagingFilterDTO) {
        super(pagingLoadConfig);
        this.mailPagingFilterDTO = mailPagingFilterDTO;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    private GetMailListAction() {
    }

    public MailFilterDTO getMailPagingFilterDTO() {
        return mailPagingFilterDTO;
    }

    public void setUserPagingFilterDTO(MailFilterDTO mailPagingFilterDTO) {
        this.mailPagingFilterDTO = mailPagingFilterDTO;
    }
}