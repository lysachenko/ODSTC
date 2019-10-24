package com.netcracker.tc.server.dispatch.user;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.shared.ActionException;
import com.netcracker.tc.server.dispatch.AbstractActionHandler;
import com.netcracker.tc.server.service.api.MailService;
import com.netcracker.tc.server.service.exception.ServiceException;
import com.netcracker.tc.shared.action.GetMailListResult;
import com.netcracker.tc.shared.action.common.GetMailListAction;
import com.netcracker.tc.shared.model.common.MailDTO;
import com.netcracker.tc.shared.model.common.PagingLoadResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMailListHandler extends AbstractActionHandler<GetMailListAction, GetMailListResult> {

    @Autowired
    private MailService mailService;

    public GetMailListHandler() {
    }

    @Override
    protected GetMailListResult process(GetMailListAction action, ExecutionContext context) throws ServiceException, ActionException {
        PagingLoadResultDTO<MailDTO> mailResult = mailService.getMails(action.getPagingLoadConfig(), action.getMailPagingFilterDTO());

        return new GetMailListResult(mailResult);
    }

    @Override
    public Class<GetMailListAction> getActionType() {
        return GetMailListAction.class;
    }
}
