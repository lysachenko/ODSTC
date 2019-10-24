package com.netcracker.tc.client.ui.widget.hr;

import com.github.gwtbootstrap.client.ui.*;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.netcracker.tc.client.ui.widget.simple.SkillLevelListBox;
import com.netcracker.tc.shared.model.interview.InterviewResultDTO;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;
import com.netcracker.tc.shared.model.interview.QAInterviewResultDetailDTO;

public class QAUserInterviewResultWidget extends Composite {

    private static final int USER_INTERVIEW_RESULT_PANEL = 0;
    private static final int EMPTY_INTERVIEW_RESULT_PANEL = 1;
    private static final int NO_INTERVIEW_RESULT_PANEL = 2;

    private static Binder uiBinder = (Binder) GWT.create(Binder.class);

    @UiField
    DeckPanel mainPanel;
    @UiField
    Paragraph interviewDate;
    @UiField
    TextBox hrTextBox;
    @UiField
    TextBox devTextBox;

    @UiField
    ListBox hrComeListBox;
    @UiField
    TextArea hrOtherInformationTextArea;
    @UiField
    ListBox hrWorkWiUserListBox;
    @UiField
    ListBox hrFinalAssessmentListBox;

    @UiField
    TextArea interviewerOtherInformation;
    @UiField
    TextArea interviewerBasicInformation;
    @UiField
    ListBox interviewerComeListBox;
    @UiField
    ListBox interviewerWorkWiUserListBox;
    @UiField
    ListBox interviewerFinalAssessmentListBox;

    @UiField
    SkillLevelListBox qaKnowledge1;
    @UiField
    SkillLevelListBox qaKnowledge2;
    @UiField
    SkillLevelListBox qaKnowledge3;
    @UiField
    SkillLevelListBox qaKnowledge4;
    @UiField
    SkillLevelListBox qaKnowledge5;
    @UiField
    SkillLevelListBox qaKnowledge6;

    @UiField
    SkillLevelListBox itKnowledge1;
    @UiField
    SkillLevelListBox itKnowledge2;
    @UiField
    SkillLevelListBox itKnowledge3;
    @UiField
    SkillLevelListBox itKnowledge4;

    @UiField
    Row technicalResultRow;
    @UiField
    Column technicalInterviewerColumn;
    @UiField
    Row hrResultRow;
    @UiField
    Column hrInterviewerColumn;
    @UiField
    Button saveInterviewResultButton;
    @UiField
    Tooltip saveInterviewResultTooltip;

    private DateTimeFormat fullFormat = DateTimeFormat.getFormat("dd.MM.yyyy HH:mm");
    private InterviewResultDTO interviewResult;

    public QAUserInterviewResultWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setInterviewResult(InterviewSlotDTO interviewSlot, InterviewResultDTO interviewResultDTO) {
        clearInformation();
        if (interviewSlot == null) {
            this.interviewResult = null;
            return;
        }
        this.interviewDate.setText("Дата собеседования: " + this.fullFormat.format(interviewSlot.getInterviewDate()));
        if (interviewResultDTO == null) {
            this.interviewResult = new InterviewResultDTO();
            this.interviewResult.setInterviewSlot(interviewSlot);
            this.interviewResult.setQaInterviewResultDetail(new QAInterviewResultDetailDTO());
            return;
        }

        this.interviewResult = interviewResultDTO;
        this.interviewResult.setInterviewSlot(interviewSlot);

        if (interviewResultDTO.getQaInterviewResultDetail() == null){
            interviewResult.setQaInterviewResultDetail(new QAInterviewResultDetailDTO());
        }
        this.hrTextBox.setText(this.interviewResult.getHr());
        this.devTextBox.setText(this.interviewResult.getInterviewer());

        fillHrInformation(interviewResult.getQaInterviewResultDetail());
        fillInterviewerInformation(interviewResult.getQaInterviewResultDetail());
    }

    private void fillInterviewerInformation(QAInterviewResultDetailDTO qaInterviewResultDetail) {
        fillBoolField(qaInterviewResultDetail.getInterviewerComeToInterview(), interviewerComeListBox);
        interviewerOtherInformation.setText(qaInterviewResultDetail.getInterviewerOther());
        interviewerBasicInformation.setText(qaInterviewResultDetail.getInterviewerBasicInformation());
        fillBoolField(qaInterviewResultDetail.getInterviewerWorkWithUser(), interviewerWorkWiUserListBox);
        if (qaInterviewResultDetail.getInterviewerFinalAssessment() != null) {
            this.interviewerFinalAssessmentListBox.setSelectedIndex(qaInterviewResultDetail.getInterviewerFinalAssessment().intValue());
        }

        qaKnowledge1.setSelectedSkill(qaInterviewResultDetail.getQaKnowledge1());
        qaKnowledge2.setSelectedSkill(qaInterviewResultDetail.getQaKnowledge2());
        qaKnowledge3.setSelectedSkill(qaInterviewResultDetail.getQaKnowledge3());
        qaKnowledge4.setSelectedSkill(qaInterviewResultDetail.getQaKnowledge4());
        qaKnowledge5.setSelectedSkill(qaInterviewResultDetail.getQaKnowledge5());
        qaKnowledge6.setSelectedSkill(qaInterviewResultDetail.getQaKnowledge6());

        itKnowledge1.setSelectedSkill(qaInterviewResultDetail.getItKnowledge1());
        itKnowledge2.setSelectedSkill(qaInterviewResultDetail.getItKnowledge2());
        itKnowledge3.setSelectedSkill(qaInterviewResultDetail.getItKnowledge3());
        itKnowledge4.setSelectedSkill(qaInterviewResultDetail.getItKnowledge4());
    }

    private void fillHrInformation(QAInterviewResultDetailDTO qaInterviewResultDetail) {
        fillBoolField(qaInterviewResultDetail.getHrComeToInterview(), hrComeListBox);
        hrOtherInformationTextArea.setText(qaInterviewResultDetail.getHrOtherInformation());
        fillBoolField(qaInterviewResultDetail.getHrWorkWithUser(), hrWorkWiUserListBox);
        if (qaInterviewResultDetail.getHrFinalAssessment() != null) {
            this.hrFinalAssessmentListBox.setSelectedIndex(qaInterviewResultDetail.getHrFinalAssessment().intValue());
        }
    }

    private void fillBoolField(Boolean value, ListBox field) {
        if (value != null) {
            field.setSelectedIndex(value.booleanValue() ? 1 : 2);
        }
    }

    private void clearInformation() {
        hrTextBox.setText("");
        devTextBox.setText("");

        hrComeListBox.setSelectedIndex(0);
        hrOtherInformationTextArea.setText("");
        hrWorkWiUserListBox.setSelectedIndex(0);
        hrFinalAssessmentListBox.setSelectedIndex(0);

        interviewerComeListBox.setSelectedIndex(0);
        interviewerOtherInformation.setText("");
        interviewerBasicInformation.setText("");
        interviewerWorkWiUserListBox.setSelectedIndex(0);
        interviewerFinalAssessmentListBox.setSelectedIndex(0);
        qaKnowledge1.setSelectedSkill(0);
        qaKnowledge2.setSelectedSkill(0);
        qaKnowledge3.setSelectedSkill(0);
        qaKnowledge4.setSelectedSkill(0);
        qaKnowledge5.setSelectedSkill(0);
        qaKnowledge6.setSelectedSkill(0);
        itKnowledge1.setSelectedSkill(0);
        itKnowledge2.setSelectedSkill(0);
        itKnowledge3.setSelectedSkill(0);
        itKnowledge4.setSelectedSkill(0);
    }

    public InterviewResultDTO getInterviewResult() {
        this.interviewResult.getQaInterviewResultDetail().setHrWorkWithUser(getBooleanField(this.hrWorkWiUserListBox));
        this.interviewResult.getQaInterviewResultDetail().setHrOtherInformation(this.hrOtherInformationTextArea.getText());
        this.interviewResult.getQaInterviewResultDetail().setHrFinalAssessment(Integer.valueOf(this.hrFinalAssessmentListBox.getSelectedIndex()));
        this.interviewResult.getQaInterviewResultDetail().setHrComeToInterview(getBooleanField(hrComeListBox));

        if (interviewerWorkWiUserListBox.isEnabled()) {
            this.interviewResult.getQaInterviewResultDetail().setInterviewerWorkWithUser(getBooleanField(this.interviewerWorkWiUserListBox));
            this.interviewResult.getQaInterviewResultDetail().setInterviewerOther(this.interviewerOtherInformation.getText());
            this.interviewResult.getQaInterviewResultDetail().setInterviewerFinalAssessment(Integer.valueOf(this.interviewerFinalAssessmentListBox.getSelectedIndex()));
            this.interviewResult.getQaInterviewResultDetail().setInterviewerComeToInterview(getBooleanField(interviewerComeListBox));
            this.interviewResult.getQaInterviewResultDetail().setInterviewerBasicInformation(interviewerBasicInformation.getText());

            this.interviewResult.getQaInterviewResultDetail().setItKnowledge1(itKnowledge1.getSelectedSkill());
            this.interviewResult.getQaInterviewResultDetail().setItKnowledge2(itKnowledge2.getSelectedSkill());
            this.interviewResult.getQaInterviewResultDetail().setItKnowledge3(itKnowledge3.getSelectedSkill());
            this.interviewResult.getQaInterviewResultDetail().setItKnowledge4(itKnowledge4.getSelectedSkill());

            this.interviewResult.getQaInterviewResultDetail().setQaKnowledge1(qaKnowledge1.getSelectedSkill());
            this.interviewResult.getQaInterviewResultDetail().setQaKnowledge2(qaKnowledge2.getSelectedSkill());
            this.interviewResult.getQaInterviewResultDetail().setQaKnowledge3(qaKnowledge3.getSelectedSkill());
            this.interviewResult.getQaInterviewResultDetail().setQaKnowledge4(qaKnowledge4.getSelectedSkill());
            this.interviewResult.getQaInterviewResultDetail().setQaKnowledge5(qaKnowledge5.getSelectedSkill());
            this.interviewResult.getQaInterviewResultDetail().setQaKnowledge6(qaKnowledge6.getSelectedSkill());
        }

        return this.interviewResult;
    }

    private Boolean getBooleanField(ListBox comeListBox) {
        if (comeListBox.getSelectedIndex() == 0) {
            return null;
        }
        if (comeListBox.getSelectedIndex() == 1) {
            return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
    }

    public Button getSaveInterviewResultButton() {
        return this.saveInterviewResultButton;
    }

    public void showEmptyPanel() {
        this.mainPanel.showWidget(EMPTY_INTERVIEW_RESULT_PANEL);
    }

    public void showInterviewResultPanel() {
        this.mainPanel.showWidget(USER_INTERVIEW_RESULT_PANEL);
    }

    public void showNoInterviewPanel() {
        this.mainPanel.showWidget(NO_INTERVIEW_RESULT_PANEL);
    }

    public void enableHRFields() {
        this.hrResultRow.setVisible(true);
        this.hrInterviewerColumn.setVisible(true);
        this.hrOtherInformationTextArea.setEnabled(true);
        this.hrWorkWiUserListBox.setEnabled(true);
        this.hrFinalAssessmentListBox.setEnabled(true);
        this.hrComeListBox.setEnabled(true);

        this.interviewerBasicInformation.setEnabled(false);
        this.interviewerOtherInformation.setEnabled(false);
        this.interviewerFinalAssessmentListBox.setEnabled(false);
        this.interviewerWorkWiUserListBox.setEnabled(false);
        this.interviewerComeListBox.setEnabled(false);

        this.qaKnowledge1.setEnabled(false);
        this.qaKnowledge2.setEnabled(false);
        this.qaKnowledge3.setEnabled(false);
        this.qaKnowledge4.setEnabled(false);
        this.qaKnowledge5.setEnabled(false);
        this.qaKnowledge6.setEnabled(false);

        this.itKnowledge1.setEnabled(false);
        this.itKnowledge2.setEnabled(false);
        this.itKnowledge3.setEnabled(false);
        this.itKnowledge4.setEnabled(false);

        this.technicalResultRow.setVisible(true);
        this.technicalInterviewerColumn.setVisible(true);
    }

    public void enableDevFields() {
        this.hrResultRow.setVisible(false);
        this.hrInterviewerColumn.setVisible(false);
        this.hrOtherInformationTextArea.setEnabled(false);
        this.hrWorkWiUserListBox.setEnabled(false);
        this.hrFinalAssessmentListBox.setEnabled(false);
        this.hrComeListBox.setEnabled(false);

        this.interviewerBasicInformation.setEnabled(true);
        this.interviewerOtherInformation.setEnabled(true);
        this.interviewerFinalAssessmentListBox.setEnabled(true);
        this.interviewerWorkWiUserListBox.setEnabled(true);
        this.interviewerComeListBox.setEnabled(true);

        this.qaKnowledge1.setEnabled(true);
        this.qaKnowledge2.setEnabled(true);
        this.qaKnowledge3.setEnabled(true);
        this.qaKnowledge4.setEnabled(true);
        this.qaKnowledge5.setEnabled(true);
        this.qaKnowledge6.setEnabled(true);

        this.itKnowledge1.setEnabled(true);
        this.itKnowledge2.setEnabled(true);
        this.itKnowledge3.setEnabled(true);
        this.itKnowledge4.setEnabled(true);
        this.technicalResultRow.setVisible(true);
        this.technicalInterviewerColumn.setVisible(true);
    }

    public void enableSimpleHRFields() {
        this.hrResultRow.setVisible(true);
        this.hrInterviewerColumn.setVisible(true);
        this.hrOtherInformationTextArea.setEnabled(true);
        this.hrWorkWiUserListBox.setEnabled(true);
        this.hrFinalAssessmentListBox.setEnabled(true);
        this.hrComeListBox.setEnabled(true);

        this.technicalResultRow.setVisible(false);
        this.technicalInterviewerColumn.setVisible(false);
    }

    public void setIsArchive(boolean archive){
        if (archive){
            saveInterviewResultTooltip.setText("Вы не можете редактировать результаты собеседования архивного пользователя.");
        } else {
            saveInterviewResultTooltip.setText("");
        }
        saveInterviewResultTooltip.reconfigure();
        saveInterviewResultButton.setEnabled(!archive);
    }

    static abstract interface Binder extends UiBinder<Widget, QAUserInterviewResultWidget> {
    }
}
