package com.netcracker.tc.client.ui.widget.hr;

import com.google.gwt.user.cellview.client.TextColumn;
import com.netcracker.tc.client.ui.widget.common.AbstractAsyncTableWidget;
import com.netcracker.tc.shared.model.common.MailDTO;

public class MailAsyncTableWidget extends AbstractAsyncTableWidget<MailDTO> {

    @Override
    protected void initTableColumns() {
        TextColumn<MailDTO> addressColumn = new TextColumn<MailDTO>() {
            @Override
            public String getValue(MailDTO object) {
                return object.getReceiverAddress();
            }
        };
        TextColumn<MailDTO> bodyColumn = new TextColumn<MailDTO>() {
            @Override
            public String getValue(MailDTO object) {
                return object.getReceiverBody();
            }
        };
        TextColumn<MailDTO> subjectColumn = new TextColumn<MailDTO>() {
            @Override
            public String getValue(MailDTO object) {
                return object.getReceiverSubject();
            }
        };
        TextColumn<MailDTO> sentColumn = new TextColumn<MailDTO>() {
            @Override
            public String getValue(MailDTO object) {
                return object.getSent().toString();
            }
        };
        TextColumn<MailDTO> timeColumn = new TextColumn<MailDTO>() {
            @Override
            public String getValue(MailDTO object) {
                return object.getAddedDate().toString();
            }
        };

        table.addColumn(addressColumn, "Address");
        table.addColumn(bodyColumn, "Body");
        table.addColumn(subjectColumn, "Subject");
        table.addColumn(sentColumn, "Sent");
        table.addColumn(timeColumn, "Time");
    }
}