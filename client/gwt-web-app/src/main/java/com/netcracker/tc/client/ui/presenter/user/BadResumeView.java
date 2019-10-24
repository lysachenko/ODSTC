package com.netcracker.tc.client.ui.presenter.user;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 *
 * @author anla1215
 */
public class BadResumeView extends com.gwtplatform.mvp.client.ViewImpl implements BadResumePresenter.ViewImpl{
    
    private static String MESSAGE = "<center><h4>К сожалению, мы не готовы пригласить Вас на интервью в этом году,"
            + " так как анкета не соответствует некоторым обязательным критериям.</h4>\n"
            + " <br> \n" 
            + " <h5>Желаем Вам удачи в дальнейшем обучении!</h5></center>";
    
    @UiField
    HTML messageHTML;
    
    
    @Inject
    BadResumeView(BadResumeView.Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setBadResumeView() {
        messageHTML.setHTML(MESSAGE);
    }
    
    
    interface Binder extends UiBinder<Widget, BadResumeView> {
    }
    
    
}
