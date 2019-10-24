//package com.netcracker.tc.client.ui.widget.hr;
//
//import com.github.gwtbootstrap.client.ui.AlertBlock;
//import com.github.gwtbootstrap.client.ui.ControlGroup;
//import com.github.gwtbootstrap.client.ui.Tooltip;
//import com.google.gwt.core.shared.GWT;
//import com.google.gwt.i18n.client.DateTimeFormat;
//import com.google.gwt.uibinder.client.UiBinder;
//import com.google.gwt.uibinder.client.UiField;
//import com.google.gwt.user.client.ui.Composite;
//import com.google.gwt.user.client.ui.Widget;
//import com.netcracker.tc.client.validation.ValidationFactory;
//import com.netcracker.tc.shared.model.common.MailDTO;
//import com.netcracker.tc.shared.model.resume.DevResumeDetailDTO;
//import com.netcracker.tc.shared.model.resume.InstituteDTO;
//import com.netcracker.tc.shared.model.resume.KnowledgeTypeDTO;
//import com.netcracker.tc.shared.model.resume.ResumeDTO;
//
//import javax.validation.ConstraintViolation;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//
//public class MailWidget extends Composite {
//
//    private static Logger LOGGER = Logger.getLogger(MailWidget.class.toString());
//
//    private static Binder uiBinder = GWT.create(Binder.class);
//
//    @UiField
//    Date addedDateField;
//    @UiField
//    Boolean isSentField;
//    @UiField
//    String receiverAddressField;
//    @UiField
//    String receiverSubjectField;
//    @UiField
//    String receiverMessageField;
//
//
//    @UiField
//    ControlGroup addedDateGroup;
//    @UiField
//    ControlGroup isSentGroup;
//    @UiField
//    ControlGroup receiverAddressGroup;
//    @UiField
//    ControlGroup receiverSubjectGroup;
//    @UiField
//    ControlGroup receiverMessageGroup;
//
//
//    @UiField
//    AlertBlock errorAlertBlock;
//
//    private Map<Widget, Tooltip> tooltips;
//    private Map<Widget, Tooltip> actualTooltips;
//
//   /* @UiField
//    Button downloadButton;*/
//
//    public MailWidget() {
//    }
//
//    public MailDTO getMail() {
//
//        MailDTO mailDTO = new MailDTO();
//        mailDTO.setAddedDate(addedDateField.getText());
//        mailDTO.setReceiverAddress(receiverAddressField.getText());
//        mailDTO.setReceiverBody(receiverMessageField.getText());
//        mailDTO.setReceiverSubject(receiverSubjectField.getText());
//        mailDTO.setSent(isSentField.getText());
//
//
//        return mailDTO;
//    }
//
//    public void setDevResume(ResumeDTO resume) {
//        if (resume != null) {
//
//            MailDTO mailDTO = new MailDTO();
//            mailDTO.setAddedDate(addedDateField.getText());
//            mailDTO.setReceiverAddress(receiverAddressField.getText());
//            mailDTO.setReceiverBody(receiverBodyField.getText());
//            mailDTO.setReceiverSubject(receiverSubjectField.getText());
//            mailDTO.setSent(receiverSentField.getText());
//Added
//
//
//            DevResumeDetailDTO devResumeDetailDTO = resume.getDevResumeDetail();
//
//            uploadPhotoWidget.setUserImage(resume.getPhotoPath());
//            surnameField.setText(resume.getSurname());
//            nameField.setText(resume.getName());
//            engSurnameField.setText(resume.getEngSurname());
//            engNameField.setText(resume.getEngName());
//            lastNameField.setText(resume.getLastName());
//            emailField.setText(resume.getEmail());
//            telephoneField.setText(resume.getTelephoneNum());
//            skypeField.setText(resume.getSkype());
//
//            if (devResumeDetailDTO != null) {
//                instituteListBox.setInstitute(devResumeDetailDTO.getInstitute());
//                departmentField.setText(devResumeDetailDTO.getDepartment());
//                courseField.setSelectedValue(devResumeDetailDTO.getCourse());
//                facultyField.setText(devResumeDetailDTO.getFaculty());
//                if (devResumeDetailDTO.getGraduationYear() != null) {
//                    DateTimeFormat format = DateTimeFormat.getFormat("yyyy");
//                    Date year = format.parse(devResumeDetailDTO.getGraduationYear().toString());
//                    graduationYearField.setValue(year);
//                } else {
//                    graduationYearField.setValue(null);
//                }
//                otherContactField.setText(devResumeDetailDTO.getOtherContacts());
//                trainingCenterInterestListBox.setSelectedValue(devResumeDetailDTO.getTrainingCenterInterest());
//                workInNetCrackerInterestListBox.setSelectedValue(devResumeDetailDTO.getWorkInNetCrackerInterest());
//                otherJobInterestTextArea.setText(devResumeDetailDTO.getOtherJobInterests());
//                backEndInterestField.setSelectedValue(devResumeDetailDTO.getBackEndInterest());
//                frontEndInterestField.setSelectedValue(devResumeDetailDTO.getFrontEndInterest());
//                dbInterestField.setSelectedValue(devResumeDetailDTO.getDbInterest());
//                otherWorkTypeSpecificField.setText(devResumeDetailDTO.getOtherWorkTypeSpecific());
//                OOPLevelField.setSelectedSkill(devResumeDetailDTO.getOOPLevel());
//                dbLevelField.setSelectedSkill(devResumeDetailDTO.getDbLevel());
//                webLevelField.setSelectedSkill(devResumeDetailDTO.getWebLevel());
//                userInterfaceLevelField.setSelectedSkill(devResumeDetailDTO.getUserInterfaceLevel());
//                umlLevelField.setSelectedSkill(devResumeDetailDTO.getUmlLevel());
//                otherSkillsLevelField.setText(devResumeDetailDTO.getOtherSkillsLevel());
//                workExperienceField.setText(devResumeDetailDTO.getWorkExperience());
//                englishReadLevelField.setSelectedSkill(devResumeDetailDTO.getEnglishReadLevel());
//                englishWriteLevelField.setSelectedSkill(devResumeDetailDTO.getEnglishWriteLevel());
//                englishSpeakLevelField.setSelectedSkill(devResumeDetailDTO.getEnglishSpeakLevel());
//                whereYouKnowAboutTCField.setText(devResumeDetailDTO.getWhereYouKnowAboutTC());
//                whyTakeYouInNetCrackerField.setText(devResumeDetailDTO.getWhyTakeYouInNetCracker());
//                moreInformationAboutYouField.setText(devResumeDetailDTO.getMoreInformationAboutYou());
//                resumeKnowledgeWidget.setValues(resume.getResumeKnowledges());
//                if (devResumeDetailDTO.getInstitute().isOtherInstitute()) {
//                    otherInstituteRow.setVisible(true);
//                    otherInstituteField.setText(devResumeDetailDTO.getInstituteOtherName());
//                }
//            }
//        }
//    }
//
//    public boolean isValid() {
//        boolean valid = true;
//        LOGGER.log(Level.FINE, " staring isValid, tooltip size - " + tooltips.size());
//
//        ResumeDTO devResumeDetailDTO = getDevResume();
//        Set<ConstraintViolation<ResumeDTO>> violations = ValidationFactory.validate(devResumeDetailDTO);
//        Set<ConstraintViolation<DevResumeDetailDTO>> violations2 = ValidationFactory.validate(devResumeDetailDTO.getDevResumeDetail());
//
//        nameGroup.setStyleName("control-group none");
//        surnameGroup.setStyleName("control-group none");
//        engNameGroup.setStyleName("control-group none");
//        engSurnameGroup.setStyleName("control-group none");
//        lastNameGroup.setStyleName("control-group none");
//        telephoneNumGroup.setStyleName("control-group none");
//        skypeGroup.setStyleName("control-group none");
//        photoPathGroup.setStyleName("control-group none");
//        instituteNameOtherGroup.setStyleName("control-group none");
//        courseGroup.setStyleName("control-group none");
//        facultyGroup.setStyleName("control-group none");
//        departmentGroup.setStyleName("control-group none");
//        otherContactGroup.setStyleName("control-group none");
//        otherJobInterestGroup.setStyleName("control-group none");
//        otherWorkTypeSpecificGroup.setStyleName("control-group none");
//        otherSkillsLevelGroup.setStyleName("control-group none");
//        whereYouKnowAboutTCGroup.setStyleName("control-group none");
//        whyTakeYouInNetCrackerGroup.setStyleName("control-group none");
//        moreInformationAboutYouGroup.setStyleName("control-group none");
//        workExperienceGroup.setStyleName("control-group none");
//        errorAlertBlock.setVisible(false);
//
//        for (ConstraintViolation violation : violations) {
//            if (violation.getPropertyPath().toString().equals("name")) {
//                addTooltip(nameField, violation.getMessage());
//                nameGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("surname")) {
//                addTooltip(surnameField, violation.getMessage());
//                surnameGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("engName")) {
//                addTooltip(engNameField, violation.getMessage());
//                engNameGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("engSurname")) {
//                addTooltip(engSurnameField, violation.getMessage());
//                engSurnameGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("lastName")) {
//                addTooltip(lastNameField, violation.getMessage());
//                lastNameGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("email")) {
//                addTooltip(emailField, violation.getMessage());
//                emailGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("telephoneNum")) {
//                addTooltip(telephoneField, violation.getMessage());
//                telephoneNumGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("skype")) {
//                addTooltip(skypeField, violation.getMessage());
//                skypeGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("photoPath")) {
//                addTooltip(uploadPhotoWidget, violation.getMessage());
//                photoPathGroup.setStyleName("control-group error");
//            }
//            valid = false;
//        }
//
//        for (ConstraintViolation violation : violations2) {
//            if (violation.getPropertyPath().toString().equals("instituteOtherName")) {
//                addTooltip(otherInstituteField, violation.getMessage());
//                instituteNameOtherGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("course")) {
//                addTooltip(courseField, violation.getMessage());
//                courseGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("faculty")) {
//                addTooltip(facultyField, violation.getMessage());
//                facultyGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("department")) {
//                addTooltip(departmentField, violation.getMessage());
//                departmentGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("otherContacts")) {
//                addTooltip(otherContactField, violation.getMessage());
//                otherContactGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("otherJobInterests")) {
//                addTooltip(otherJobInterestTextArea, violation.getMessage());
//                otherJobInterestGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("otherWorkTypeSpecific")) {
//                addTooltip(otherWorkTypeSpecificField, violation.getMessage());
//                otherWorkTypeSpecificGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("otherSkillsLevel")) {
//                addTooltip(otherSkillsLevelField, violation.getMessage());
//                otherSkillsLevelGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("workExperience")) {
//                addTooltip(workExperienceField, violation.getMessage());
//                workExperienceGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("whereYouKnowAboutTC")) {
//                addTooltip(whereYouKnowAboutTCField, violation.getMessage());
//                whereYouKnowAboutTCGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("whyTakeYouInNetCracker")) {
//                addTooltip(whyTakeYouInNetCrackerField, violation.getMessage());
//                whyTakeYouInNetCrackerGroup.setStyleName("control-group error");
//            }
//            if (violation.getPropertyPath().toString().equals("moreInformationAboutYou")) {
//                addTooltip(moreInformationAboutYouGroup, violation.getMessage());
//                moreInformationAboutYouGroup.setStyleName("control-group error");
//            }
//            valid = false;
//        }
//
//        if (graduationYearField.getValue() != null) {
//            graduationYearGroup.setStyleName("control-group none");
//        } else {
//            valid = false;
//            graduationYearGroup.setStyleName("control-group error");
//            addTooltip(graduationYearField, "Год окончания должен состоять из цифр.");
//        }
//
//        if (agreementCheckBox.getValue() == Boolean.TRUE) {
//            agreementGroup.setStyleName("control-group none");
//        } else {
//            valid = false;
//            agreementGroup.setStyleName("control-group error");
//        }
//
//        errorAlertBlock.setVisible(!valid);
//        errorAlertBlock.setText("Ошибка при валидации полей. Проверьте корректность значений.");
//
//        cleanTooltip();
//
//        LOGGER.log(Level.FINE, "end isValid, valid = " + valid);
//
//        return valid;
//    }
//
//    private void cleanTooltip() {
//        LOGGER.log(Level.FINE, "clean tooltip");
//        for (Tooltip tooltip : tooltips.values())
//            if(!actualTooltips.containsValue(tooltip)) {
//                tooltip.setText("");
//                tooltip.reconfigure();
//                tooltip.clear();
//            }
//        tooltips.clear();
//        tooltips.putAll(actualTooltips);
//        actualTooltips.clear();
//    }
//
//    private void addTooltip(Widget widget, String message) {
//        LOGGER.log(Level.FINE, " add addTooltip ");
//        if (tooltips.containsKey(widget)) {
//            actualTooltips.put(widget,tooltips.get(widget));
//            return;
//        }
//
//        Tooltip tooltip = new Tooltip();
//        tooltip.setWidget(widget);
//        tooltip.setShowDelay(1);
//        tooltip.setText(message);
//        tooltip.reconfigure();
//        actualTooltips.put(widget, tooltip);
//    }
//
//    public void setInstitutes(List<InstituteDTO> instituteDTOList) {
//        instituteListBox.setInstituteList(instituteDTOList);
//    }
//
//    public void setKnowledgeTypes(List<KnowledgeTypeDTO> knowledgeTypes) {
//        resumeKnowledgeWidget.setKnowledgeTypes(knowledgeTypes);
//    }
//
//    public void disableFields() {
//        uploadPhotoWidget.disableFields();
//        surnameField.setEnabled(false);
//        nameField.setEnabled(false);
//        engSurnameField.setEnabled(false);
//        engNameField.setEnabled(false);
//        lastNameField.setEnabled(false);
//        instituteListBox.setEnabled(false);
//        otherInstituteField.setEnabled(false);
//        courseField.setEnabled(false);
//        facultyField.setEnabled(false);
//        departmentField.setEnabled(false);
//        graduationYearField.setReadOnly(false);
//        emailField.setEnabled(false);
//        telephoneField.setEnabled(false);
//        skypeField.setEnabled(false);
//        otherContactField.setEnabled(false);
//        trainingCenterInterestListBox.setEnabled(false);
//        workInNetCrackerInterestListBox.setEnabled(false);
//        otherJobInterestTextArea.setEnabled(false);
//        backEndInterestField.setEnabled(false);
//        frontEndInterestField.setEnabled(false);
//        dbInterestField.setEnabled(false);
//        otherWorkTypeSpecificField.setEnabled(false);
//        resumeKnowledgeWidget.disableFields();
//        OOPLevelField.setEnabled(false);
//        dbLevelField.setEnabled(false);
//        webLevelField.setEnabled(false);
//        userInterfaceLevelField.setEnabled(false);
//        umlLevelField.setEnabled(false);
//        otherSkillsLevelField.setEnabled(false);
//        workExperienceField.setEnabled(false);
//        englishReadLevelField.setEnabled(false);
//        englishWriteLevelField.setEnabled(false);
//        englishSpeakLevelField.setEnabled(false);
//        whereYouKnowAboutTCField.setEnabled(false);
//        whyTakeYouInNetCrackerField.setEnabled(false);
//        moreInformationAboutYouField.setEnabled(false);
//        agreementCheckBox.setEnabled(false);
//    }
//
//    public void clearFields() {
//        uploadPhotoWidget.setUserImage("");
//        surnameField.setText("");
//        nameField.setText("");
//        engSurnameField.setText("");
//        engNameField.setText("");
//        lastNameField.setText("");
//        instituteListBox.setSelectedIndex(-1);
//        otherInstituteField.setText("");
//        courseField.setSelectedIndex(0);
//        facultyField.setText("");
//        departmentField.setText("");
//        graduationYearField.setValue(null);
//        emailField.setText("");
//        telephoneField.setText("");
//        skypeField.setText("");
//        otherContactField.setText("");
//        trainingCenterInterestListBox.setSelectedIndex(0);
//        workInNetCrackerInterestListBox.setSelectedIndex(0);
//        otherJobInterestTextArea.setText("");
//        backEndInterestField.setSelectedIndex(0);
//        frontEndInterestField.setSelectedIndex(0);
//        dbInterestField.setSelectedIndex(0);
//        otherWorkTypeSpecificField.setText("");
//        OOPLevelField.setSelectedIndex(0);
//        dbLevelField.setSelectedIndex(0);
//        webLevelField.setSelectedIndex(0);
//        userInterfaceLevelField.setSelectedIndex(0);
//        umlLevelField.setSelectedIndex(0);
//        otherSkillsLevelField.setText("");
//        workExperienceField.setText("");
//        englishReadLevelField.setSelectedIndex(0);
//        englishWriteLevelField.setSelectedIndex(0);
//        englishSpeakLevelField.setSelectedIndex(0);
//        whereYouKnowAboutTCField.setText("");
//        whyTakeYouInNetCrackerField.setText("");
//        moreInformationAboutYouField.setText("");
//        agreementCheckBox.setEnabled(false);
//    }
//
//  /*  public Button getDownloadButton() {
//        return downloadButton;
//    }*/
//
//    interface Binder extends UiBinder<Widget, MailWidget> {
//    }
//}