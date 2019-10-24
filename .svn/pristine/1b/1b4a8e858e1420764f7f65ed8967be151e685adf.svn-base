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
import com.netcracker.tc.shared.model.interview.DevInterviewResultDetailDTO;
import com.netcracker.tc.shared.model.interview.InterviewResultDTO;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;

public class DevUserInterviewResultWidget extends Composite {

    private static final int USER_INTERVIEW_RESULT_PANEL = 0;
    private static final int EMPTY_INTERVIEW_RESULT_PANEL = 1;
    private static final int NO_INTERVIEW_RESULT_PANEL = 2;

    private static Binder uiBinder = (Binder) GWT.create(Binder.class);

    @UiField
    DeckPanel mainPanel;
    @UiField
    Paragraph interviewDate;
    @UiField
    ListBox comeListBox;
    @UiField
    TextBox hrTextBox;
    @UiField
    TextBox devTextBox;
    @UiField
    TextArea hrOtherInformationTextArea;
    @UiField
    ListBox hrWorkWiUserListBox;
    @UiField
    TextArea javaSkillTextArea;
    @UiField
    TextArea sqlSkillTextArea;
    @UiField
    TextArea devOtherInformationTextArea;
    @UiField
    ListBox devWorkWiUserListBox;
    @UiField
    ListBox devFinalAssessmentListBox;
    @UiField
    ListBox hrFinalAssessmentListBox;
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

    public DevUserInterviewResultWidget() {
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
            this.interviewResult.setDevInterviewResultDetail(new DevInterviewResultDetailDTO());
            return;
        }
        this.interviewResult = interviewResultDTO;
        this.interviewResult.setInterviewSlot(interviewSlot);

        this.hrTextBox.setText(this.interviewResult.getHr());
        this.devTextBox.setText(this.interviewResult.getInterviewer());
        if (this.interviewResult.getIsCome() != null) {
            this.comeListBox.setSelectedIndex(this.interviewResult.getIsCome().booleanValue() ? 1 : 2);
        }
        DevInterviewResultDetailDTO devInterviewResultDetail = this.interviewResult.getDevInterviewResultDetail();

        this.hrOtherInformationTextArea.setText(devInterviewResultDetail.getHrOtherInformation());
        if (devInterviewResultDetail.getHrWorkWithUser() != null) {
            this.hrWorkWiUserListBox.setSelectedIndex(devInterviewResultDetail.getHrWorkWithUser().booleanValue() ? 1 : 2);
        }
        this.javaSkillTextArea.setText(devInterviewResultDetail.getJavaSkill());
        this.sqlSkillTextArea.setText(devInterviewResultDetail.getSqlSkill());
        this.devOtherInformationTextArea.setText(devInterviewResultDetail.getInterviewerOtherInformation());
        if (devInterviewResultDetail.getInterviewerWorkWithUser() != null) {
            this.devWorkWiUserListBox.setSelectedIndex(devInterviewResultDetail.getInterviewerWorkWithUser().booleanValue() ? 1 : 2);
        }
        if (devInterviewResultDetail.getDevFinalAssessment() != null) {
            this.devFinalAssessmentListBox.setSelectedIndex(devInterviewResultDetail.getDevFinalAssessment().intValue());
        }
        if (devInterviewResultDetail.getHrFinalAssessment() != null) {
            this.hrFinalAssessmentListBox.setSelectedIndex(devInterviewResultDetail.getHrFinalAssessment().intValue());
        }
    }

    private void clearInformation() {
        this.interviewDate.setText("");
        this.hrTextBox.setText("");
        this.devTextBox.setText("");
        this.comeListBox.setSelectedIndex(0);
        this.hrOtherInformationTextArea.setText("");
        this.hrWorkWiUserListBox.setSelectedIndex(0);
        this.javaSkillTextArea.setText("");
        this.sqlSkillTextArea.setText("");
        this.devOtherInformationTextArea.setText("");
        this.devWorkWiUserListBox.setSelectedIndex(0);
        this.devFinalAssessmentListBox.setSelectedIndex(0);
        this.hrFinalAssessmentListBox.setSelectedIndex(0);
    }

    public InterviewResultDTO getInterviewResult() {
        this.interviewResult.setIsCome(getBooleanField(this.comeListBox));
        this.interviewResult.getDevInterviewResultDetail().setHrWorkWithUser(getBooleanField(this.hrWorkWiUserListBox));
        this.interviewResult.getDevInterviewResultDetail().setHrOtherInformation(this.hrOtherInformationTextArea.getText());
        this.interviewResult.getDevInterviewResultDetail().setHrFinalAssessment(Integer.valueOf(this.hrFinalAssessmentListBox.getSelectedIndex()));

        this.interviewResult.getDevInterviewResultDetail().setSqlSkill(this.sqlSkillTextArea.getText());
        this.interviewResult.getDevInterviewResultDetail().setDevFinalAssessment(Integer.valueOf(this.devFinalAssessmentListBox.getSelectedIndex()));
        this.interviewResult.getDevInterviewResultDetail().setJavaSkill(this.javaSkillTextArea.getText());
        this.interviewResult.getDevInterviewResultDetail().setInterviewerWorkWithUser(getBooleanField(this.devWorkWiUserListBox));
        this.interviewResult.getDevInterviewResultDetail().setInterviewerOtherInformation(this.devOtherInformationTextArea.getText());

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
        this.hrOtherInformationTextArea.setReadOnly(false);
        this.hrWorkWiUserListBox.setEnabled(true);
        this.hrFinalAssessmentListBox.setEnabled(true);

        this.javaSkillTextArea.setReadOnly(true);
        this.sqlSkillTextArea.setReadOnly(true);
        this.devOtherInformationTextArea.setReadOnly(true);
        this.devWorkWiUserListBox.setEnabled(false);
        this.devFinalAssessmentListBox.setEnabled(false);
        this.technicalResultRow.setVisible(true);
        this.technicalInterviewerColumn.setVisible(true);
    }

    public void enableDevFields() {
        this.hrResultRow.setVisible(false);
        this.hrInterviewerColumn.setVisible(false);
        this.hrOtherInformationTextArea.setReadOnly(true);
        this.hrWorkWiUserListBox.setEnabled(false);
        this.hrFinalAssessmentListBox.setEnabled(false);

        this.javaSkillTextArea.setEnabled(true);
        this.javaSkillTextArea.setReadOnly(false);
        this.sqlSkillTextArea.setEnabled(true);
        this.sqlSkillTextArea.setReadOnly(false);
        this.devOtherInformationTextArea.setEnabled(true);
        this.devOtherInformationTextArea.setReadOnly(false);
        this.devWorkWiUserListBox.setEnabled(true);
        this.devFinalAssessmentListBox.setEnabled(true);
        this.technicalResultRow.setVisible(true);
        this.technicalInterviewerColumn.setVisible(true);
    }

    public void enableSimpleHRFields() {
        this.hrResultRow.setVisible(true);
        this.hrInterviewerColumn.setVisible(true);
        this.hrOtherInformationTextArea.setEnabled(true);
        this.hrOtherInformationTextArea.setReadOnly(false);
        this.hrWorkWiUserListBox.setEnabled(true);
        this.hrFinalAssessmentListBox.setEnabled(true);

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

    static abstract interface Binder extends UiBinder<Widget, DevUserInterviewResultWidget> {
    }
}
