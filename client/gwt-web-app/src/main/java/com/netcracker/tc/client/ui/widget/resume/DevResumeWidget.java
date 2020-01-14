package com.netcracker.tc.client.ui.widget.resume;

import com.github.gwtbootstrap.client.ui.*;
import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.ListBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.github.gwtbootstrap.client.ui.Tooltip;
import com.github.gwtbootstrap.datetimepicker.client.ui.DateTimeBoxAppended;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.netcracker.tc.client.ui.widget.simple.*;
import com.netcracker.tc.client.validation.ValidationFactory;
import com.netcracker.tc.shared.model.resume.DevResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.InstituteDTO;
import com.netcracker.tc.shared.model.resume.KnowledgeTypeDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;

import javax.validation.ConstraintViolation;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

    /*
    Composite A type of widget that can wrap another widget,
    hiding the wrapped widget's methods. When added to a panel,
    a composite behaves exactly as if the widget it wraps had been added.
    */

public class DevResumeWidget extends Composite {


    private static Logger LOGGER = Logger.getLogger(DevResumeWidget.class.toString());
    //private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(DevResumeWidget.class);
    private static Binder uiBinder = GWT.create(Binder.class);
    @UiField
    UploadPhotoWidget uploadPhotoWidget;
    @UiField
    TextBox surnameField;
    @UiField
    TextBox nameField;
    @UiField
    TextBox engSurnameField;
    @UiField
    TextBox engNameField;
    @UiField
    TextBox lastNameField;
    @UiField
    InstituteListBox instituteListBox;
    @UiField
    Row otherInstituteRow;
    @UiField
    TextBox otherInstituteField;
    @UiField
    ListBox courseField;
    @UiField
    TextBox facultyField;
    @UiField
    TextBox departmentField;
    @UiField
    TextBox specialtyField;
    @UiField
    DateTimeBoxAppended graduationYearField;
    @UiField
    TextBox emailField;
    @UiField
    TextBox telephoneField;
    @UiField
    TextBox skypeField;
    @UiField
    TextAreaHjb otherContactField;
    // I insert it
    @UiField
    AlertBlock otherContactFieldLengthInfo;
    @UiField
    CheckListBox trainingCenterInterestListBox;
    @UiField
    CheckListBox workInNetCrackerInterestListBox;
    @UiField
    TextAreaHjb otherJobInterestTextArea;
    // I insert it
    @UiField
    AlertBlock otherJobInterestLengthInfo;
    @UiField
    CheckListBox backEndInterestField;
    @UiField
    CheckListBox frontEndInterestField;
    @UiField
    CheckListBox dbInterestField;
    @UiField
    TextAreaHjb otherWorkTypeSpecificField;
    @UiField
    AlertBlock otherWorkTypeSpecificFieldLengthInfo;
    @UiField
    ResumeKnowledgeWidget resumeKnowledgeWidget;
    @UiField
    SkillLevelListBox OOPLevelField;
    @UiField
    SkillLevelListBox dbLevelField;
    @UiField
    SkillLevelListBox webLevelField;
    @UiField
    SkillLevelListBox userInterfaceLevelField;
    @UiField
    SkillLevelListBox umlLevelField;
    @UiField
    TextAreaHjb otherSkillsLevelField;
    @UiField
    AlertBlock otherSkillsLevelFieldLengthInfo;
    @UiField
    TextAreaHjb workExperienceField;
    @UiField
    AlertBlock workExperienceFieldLengthInfo;
    @UiField
    SkillLevelListBox englishReadLevelField;
    @UiField
    SkillLevelListBox englishWriteLevelField;
    @UiField
    SkillLevelListBox englishSpeakLevelField;
    @UiField
    TextAreaHjb whereYouKnowAboutTCField;
    @UiField
    AlertBlock whereYouKnowAboutTCFieldLengthInfo;
    @UiField
    TextAreaHjb whyTakeYouInNetCrackerField;
    @UiField
    AlertBlock whyTakeYouInNetCrackerFieldLengthInfo;
    @UiField
    TextAreaHjb moreInformationAboutYouField;
    @UiField
    AlertBlock moreInformationAboutYouFieldLengthInfo;
    @UiField
    CheckBox agreementCheckBox;
    @UiField
    ControlGroup nameGroup;
    @UiField
    ControlGroup surnameGroup;
    @UiField
    ControlGroup engNameGroup;
    @UiField
    ControlGroup engSurnameGroup;
    @UiField
    ControlGroup lastNameGroup;
    @UiField
    ControlGroup instituteNameGroup;
    @UiField
    ControlGroup instituteNameOtherGroup;
    @UiField
    ControlGroup courseGroup;
    @UiField
    ControlGroup facultyGroup;
    @UiField
    ControlGroup departmentGroup;
    @UiField
    ControlGroup specialtyGroup;
    @UiField
    ControlGroup graduationYearGroup;
    @UiField
    ControlGroup photoPathGroup;
    @UiField
    ControlGroup emailGroup;
    @UiField
    ControlGroup telephoneNumGroup;
    @UiField
    ControlGroup skypeGroup;
    @UiField
    ControlGroup agreementGroup;

    @UiField
    ControlGroup otherContactGroup;
    @UiField
    ControlGroup otherJobInterestGroup;
    @UiField
    ControlGroup otherWorkTypeSpecificGroup;
    @UiField
    ControlGroup otherSkillsLevelGroup;
    @UiField
    ControlGroup whereYouKnowAboutTCGroup;
    @UiField
    ControlGroup whyTakeYouInNetCrackerGroup;
    @UiField
    ControlGroup moreInformationAboutYouGroup;
    @UiField
    ControlGroup workExperienceGroup;

    @UiField
    AlertBlock errorAlertBlock;

    private Map<Widget, Tooltip> tooltips;
    private Map<Widget, Tooltip> actualTooltips;

   /* @UiField
    Button downloadButton;*/

    public DevResumeWidget() {
        tooltips = new HashMap<Widget, Tooltip>();
        actualTooltips = new HashMap<Widget, Tooltip>();
        initWidget(uiBinder.createAndBindUi(this));
        setAlertBlocks();
        instituteListBox.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                otherInstituteRow.setVisible(instituteListBox.getSelectedInstitute().isOtherInstitute());
            }
        });
    }

    private void setAlertBlocks() {
        otherJobInterestTextArea.setAlertBlock(otherJobInterestLengthInfo);
        otherContactField.setAlertBlock(otherContactFieldLengthInfo);
        otherWorkTypeSpecificField.setAlertBlock(otherWorkTypeSpecificFieldLengthInfo);
        otherSkillsLevelField.setAlertBlock(otherSkillsLevelFieldLengthInfo);
        workExperienceField.setAlertBlock(workExperienceFieldLengthInfo);
        whereYouKnowAboutTCField.setAlertBlock(whereYouKnowAboutTCFieldLengthInfo);
        whyTakeYouInNetCrackerField.setAlertBlock(whyTakeYouInNetCrackerFieldLengthInfo);
        moreInformationAboutYouField.setAlertBlock(moreInformationAboutYouFieldLengthInfo);
    }

    public ResumeDTO getDevResume() {
        LOGGER.log(Level.FINE, "get " + engSurnameField.getText());
        ResumeDTO resume = new ResumeDTO();

        resume.setSurname(surnameField.getText());
        resume.setName(nameField.getText());
        resume.setEngSurname(engSurnameField.getText());
        resume.setEngName(engNameField.getText());
        resume.setLastName(lastNameField.getText());
        resume.setEmail(emailField.getText());
        resume.setTelephoneNum(telephoneField.getText());
        resume.setSkype(skypeField.getText());
        resume.setPhotoPath(uploadPhotoWidget.getUserPhoto());
        resume.setResumeKnowledges(resumeKnowledgeWidget.getResumeKnowledges());

        DevResumeDetailDTO devResumeDetailDTO = new DevResumeDetailDTO();
        devResumeDetailDTO.setInstitute(instituteListBox.getSelectedInstitute());
        devResumeDetailDTO.setCourse(courseField.getValue());
        devResumeDetailDTO.setFaculty(facultyField.getText());
        devResumeDetailDTO.setDepartment(departmentField.getText());
        devResumeDetailDTO.setSpecialty(specialtyField.getText());

        if (graduationYearField.getValue() != null) {
            DateTimeFormat format = DateTimeFormat.getFormat("yyyy");
            String year = format.format(graduationYearField.getValue());
            devResumeDetailDTO.setGraduationYear(Integer.valueOf(year));
        }
        devResumeDetailDTO.setOtherContacts(otherContactField.getText());
        devResumeDetailDTO.setTrainingCenterInterest(trainingCenterInterestListBox.getSelectedValue());
        devResumeDetailDTO.setWorkInNetCrackerInterest(workInNetCrackerInterestListBox.getSelectedValue());
        devResumeDetailDTO.setOtherJobInterests(otherJobInterestTextArea.getText());
        devResumeDetailDTO.setBackEndInterest(backEndInterestField.getSelectedValue());
        devResumeDetailDTO.setFrontEndInterest(frontEndInterestField.getSelectedValue());
        devResumeDetailDTO.setDbInterest(dbInterestField.getSelectedValue());
        devResumeDetailDTO.setOtherWorkTypeSpecific(otherWorkTypeSpecificField.getText());
        devResumeDetailDTO.setOOPLevel(OOPLevelField.getSelectedSkill());
        devResumeDetailDTO.setDbLevel(dbLevelField.getSelectedSkill());
        devResumeDetailDTO.setWebLevel(webLevelField.getSelectedSkill());
        devResumeDetailDTO.setUserInterfaceLevel(userInterfaceLevelField.getSelectedSkill());
        devResumeDetailDTO.setUmlLevel(umlLevelField.getSelectedSkill());
        devResumeDetailDTO.setOtherSkillsLevel(otherSkillsLevelField.getText());
        devResumeDetailDTO.setWorkExperience(workExperienceField.getText());
        devResumeDetailDTO.setEnglishReadLevel(englishReadLevelField.getSelectedSkill());
        devResumeDetailDTO.setEnglishSpeakLevel(englishSpeakLevelField.getSelectedSkill());
        devResumeDetailDTO.setEnglishWriteLevel(englishWriteLevelField.getSelectedSkill());
        devResumeDetailDTO.setWhereYouKnowAboutTC(whereYouKnowAboutTCField.getText());
        devResumeDetailDTO.setWhyTakeYouInNetCracker(whyTakeYouInNetCrackerField.getText());
        devResumeDetailDTO.setMoreInformationAboutYou(moreInformationAboutYouField.getText());
        if (instituteListBox.getSelectedInstitute().isOtherInstitute()) {
            devResumeDetailDTO.setInstituteOtherName(otherInstituteField.getText());
        } else {
            devResumeDetailDTO.setInstituteOtherName(null);
        }


        resume.setDevResumeDetail(devResumeDetailDTO);

        return resume;
    }

    public void setDevResume(ResumeDTO resume) {
        otherInstituteRow.setVisible(false);
        if (resume != null) {
            LOGGER.log(Level.ALL, "set " + resume.getEngSurname());
            DevResumeDetailDTO devResumeDetailDTO = resume.getDevResumeDetail();

            uploadPhotoWidget.setUserImage(resume.getPhotoPath());
            surnameField.setText(resume.getSurname());
            nameField.setText(resume.getName());
            engSurnameField.setText(resume.getEngSurname());
            engNameField.setText(resume.getEngName());
            lastNameField.setText(resume.getLastName());
            emailField.setText(resume.getEmail());
            telephoneField.setText(resume.getTelephoneNum());
            skypeField.setText(resume.getSkype());

            if (devResumeDetailDTO != null) {
                instituteListBox.setInstitute(devResumeDetailDTO.getInstitute());
                departmentField.setText(devResumeDetailDTO.getDepartment());
                specialtyField.setText(devResumeDetailDTO.getSpecialty());
                courseField.setSelectedValue(devResumeDetailDTO.getCourse());
                facultyField.setText(devResumeDetailDTO.getFaculty());
                if (devResumeDetailDTO.getGraduationYear() != null) {
                    DateTimeFormat format = DateTimeFormat.getFormat("yyyy");
                    Date year = format.parse(devResumeDetailDTO.getGraduationYear().toString());
                    graduationYearField.setValue(year);
                } else {
                    graduationYearField.setValue(null);
                }
                otherContactField.setText(devResumeDetailDTO.getOtherContacts());
                trainingCenterInterestListBox.setSelectedValue(devResumeDetailDTO.getTrainingCenterInterest());
                workInNetCrackerInterestListBox.setSelectedValue(devResumeDetailDTO.getWorkInNetCrackerInterest());
                otherJobInterestTextArea.setText(devResumeDetailDTO.getOtherJobInterests());
                backEndInterestField.setSelectedValue(devResumeDetailDTO.getBackEndInterest());
                frontEndInterestField.setSelectedValue(devResumeDetailDTO.getFrontEndInterest());
                dbInterestField.setSelectedValue(devResumeDetailDTO.getDbInterest());
                otherWorkTypeSpecificField.setText(devResumeDetailDTO.getOtherWorkTypeSpecific());
                OOPLevelField.setSelectedSkill(devResumeDetailDTO.getOOPLevel());
                dbLevelField.setSelectedSkill(devResumeDetailDTO.getDbLevel());
                webLevelField.setSelectedSkill(devResumeDetailDTO.getWebLevel());
                userInterfaceLevelField.setSelectedSkill(devResumeDetailDTO.getUserInterfaceLevel());
                umlLevelField.setSelectedSkill(devResumeDetailDTO.getUmlLevel());
                otherSkillsLevelField.setText(devResumeDetailDTO.getOtherSkillsLevel());
                workExperienceField.setText(devResumeDetailDTO.getWorkExperience());
                englishReadLevelField.setSelectedSkill(devResumeDetailDTO.getEnglishReadLevel());
                englishWriteLevelField.setSelectedSkill(devResumeDetailDTO.getEnglishWriteLevel());
                englishSpeakLevelField.setSelectedSkill(devResumeDetailDTO.getEnglishSpeakLevel());
                whereYouKnowAboutTCField.setText(devResumeDetailDTO.getWhereYouKnowAboutTC());
                whyTakeYouInNetCrackerField.setText(devResumeDetailDTO.getWhyTakeYouInNetCracker());
                moreInformationAboutYouField.setText(devResumeDetailDTO.getMoreInformationAboutYou());
                resumeKnowledgeWidget.setValues(resume.getResumeKnowledges());
                if (devResumeDetailDTO.getInstitute().isOtherInstitute()) {
                    otherInstituteRow.setVisible(true);
                    otherInstituteField.setText(devResumeDetailDTO.getInstituteOtherName());
                }
            }
        }
    }

    public boolean isValid() {
        boolean valid = true;
        LOGGER.log(Level.FINE, " staring isValid, tooltip size - " + tooltips.size());

        ResumeDTO devResumeDetailDTO = getDevResume();
        Set<ConstraintViolation<ResumeDTO>> violations = ValidationFactory.validate(devResumeDetailDTO);
        Set<ConstraintViolation<DevResumeDetailDTO>> violations2 = ValidationFactory.validate(devResumeDetailDTO.getDevResumeDetail());

        nameGroup.setStyleName("control-group none");
        surnameGroup.setStyleName("control-group none");
        engNameGroup.setStyleName("control-group none");
        engSurnameGroup.setStyleName("control-group none");
        lastNameGroup.setStyleName("control-group none");
        telephoneNumGroup.setStyleName("control-group none");
        skypeGroup.setStyleName("control-group none");
        photoPathGroup.setStyleName("control-group none");
        instituteNameOtherGroup.setStyleName("control-group none");
        courseGroup.setStyleName("control-group none");
        facultyGroup.setStyleName("control-group none");
        departmentGroup.setStyleName("control-group none");
        specialtyGroup.setStyleName("control-group none");
        otherContactGroup.setStyleName("control-group none");
        otherJobInterestGroup.setStyleName("control-group none");
        otherWorkTypeSpecificGroup.setStyleName("control-group none");
        otherSkillsLevelGroup.setStyleName("control-group none");
        whereYouKnowAboutTCGroup.setStyleName("control-group none");
        whyTakeYouInNetCrackerGroup.setStyleName("control-group none");
        moreInformationAboutYouGroup.setStyleName("control-group none");
        workExperienceGroup.setStyleName("control-group none");
        errorAlertBlock.setVisible(false);

        List<String> errorMessages = new ArrayList<String>();

        for (ConstraintViolation violation : violations) {
            if (violation.getPropertyPath().toString().equals("name")) {
                addTooltip(nameField, violation.getMessage());
                nameGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("surname")) {
                addTooltip(surnameField, violation.getMessage());
                surnameGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("engName")) {
                addTooltip(engNameField, violation.getMessage());
                engNameGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("engSurname")) {
                addTooltip(engSurnameField, violation.getMessage());
                engSurnameGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("lastName")) {
                addTooltip(lastNameField, violation.getMessage());
                lastNameGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("email")) {
                addTooltip(emailField, violation.getMessage());
                emailGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("telephoneNum")) {
                addTooltip(telephoneField, violation.getMessage());
                telephoneNumGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("skype")) {
                addTooltip(skypeField, violation.getMessage());
                skypeGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("photoPath")) {
                addTooltip(uploadPhotoWidget, violation.getMessage());
                photoPathGroup.setStyleName("control-group error");
            }
            errorMessages.add(violation.getMessage());
            valid = false;
        }

        for (ConstraintViolation violation : violations2) {
            if (violation.getPropertyPath().toString().equals("instituteOtherName")) {
                addTooltip(otherInstituteField, violation.getMessage());
                instituteNameOtherGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("course")) {
                addTooltip(courseField, violation.getMessage());
                courseGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("faculty")) {
                addTooltip(facultyField, violation.getMessage());
                facultyGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("department")) {
                addTooltip(departmentField, violation.getMessage());
                departmentGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("specialty")) {
                addTooltip(specialtyField, violation.getMessage());
                specialtyGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("otherContacts")) {
                addTooltip(otherContactField, violation.getMessage());
                otherContactGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("otherJobInterests")) {
                addTooltip(otherJobInterestTextArea, violation.getMessage());
                otherJobInterestGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("otherWorkTypeSpecific")) {
                addTooltip(otherWorkTypeSpecificField, violation.getMessage());
                otherWorkTypeSpecificGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("otherSkillsLevel")) {
                addTooltip(otherSkillsLevelField, violation.getMessage());
                otherSkillsLevelGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("workExperience")) {
                addTooltip(workExperienceField, violation.getMessage());
                workExperienceGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("whereYouKnowAboutTC")) {
                addTooltip(whereYouKnowAboutTCField, violation.getMessage());
                whereYouKnowAboutTCGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("whyTakeYouInNetCracker")) {
                addTooltip(whyTakeYouInNetCrackerField, violation.getMessage());
                whyTakeYouInNetCrackerGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("moreInformationAboutYou")) {
                addTooltip(moreInformationAboutYouGroup, violation.getMessage());
                moreInformationAboutYouGroup.setStyleName("control-group error");
            }
            errorMessages.add(violation.getMessage());
            valid = false;
        }

        if (graduationYearField.getValue() != null) {
            graduationYearGroup.setStyleName("control-group none");
        } else {
            valid = false;
            graduationYearGroup.setStyleName("control-group error");
            addTooltip(graduationYearField, "Год окончания должен состоять из цифр.");
            errorMessages.add("Год окончания должен состоять из цифр.");
        }

        if (agreementCheckBox.getValue() == Boolean.TRUE) {
            agreementGroup.setStyleName("control-group none");
        } else {
            valid = false;
            agreementGroup.setStyleName("control-group error");
            errorMessages.add("Вы не дали согласие на обработку данных.");
        }

        StringBuffer errorMessageText = new StringBuffer("Ошибка при валидации полей. Проверьте корректность значений. <br> <ul>");
        for (String errorMessage : errorMessages) {
            errorMessageText.append("<li>" + errorMessage + "</li>");
        }
        errorMessageText.append("</ul>");

        errorAlertBlock.setVisible(!valid);
        errorAlertBlock.setHTML(errorMessageText.toString());

        cleanTooltip();

//        LOGGER.log(Level.FINE, "end isValid, valid = " + valid);

        return valid;
    }

    private void cleanTooltip() {
//        LOGGER.log(Level.FINE, "clean tooltip");
        for (Tooltip tooltip : tooltips.values())
            if (!actualTooltips.containsValue(tooltip)) {
                tooltip.setText("");
                tooltip.reconfigure();
                tooltip.clear();
            }
        tooltips.clear();
        tooltips.putAll(actualTooltips);
        actualTooltips.clear();
    }

    private void addTooltip(Widget widget, String message) {
//        LOGGER.log(Level.FINE, " add addTooltip ");
        if (tooltips.containsKey(widget)) {
            actualTooltips.put(widget, tooltips.get(widget));
            return;
        }

        Tooltip tooltip = new Tooltip();
        tooltip.setWidget(widget);
        tooltip.setShowDelay(1);
        tooltip.setText(message);
        tooltip.reconfigure();
        actualTooltips.put(widget, tooltip);
    }

    public void setInstitutes(List<InstituteDTO> instituteDTOList) {
        instituteListBox.setInstituteList(instituteDTOList);
    }

    public void setKnowledgeTypes(List<KnowledgeTypeDTO> knowledgeTypes) {
        resumeKnowledgeWidget.setKnowledgeTypes(knowledgeTypes);
    }

    public void disableFields() {
        /*uploadPhotoWidget.disableFields();
        surnameField.setEnabled(false);
        nameField.setEnabled(false);
        engSurnameField.setEnabled(false);
        engNameField.setEnabled(false);
        lastNameField.setEnabled(false);
        instituteListBox.setEnabled(false);
        otherInstituteField.setEnabled(false);
        courseField.setEnabled(false);
        facultyField.setEnabled(false);
        departmentField.setEnabled(false);
        specialtyField.setEnabled(false);
        graduationYearField.setReadOnly(false);
        emailField.setEnabled(false);
        telephoneField.setEnabled(false);
        skypeField.setEnabled(false);
        otherContactField.setEnabled(false);
        trainingCenterInterestListBox.setEnabled(false);
        workInNetCrackerInterestListBox.setEnabled(false);
        otherJobInterestTextArea.setEnabled(false);
        backEndInterestField.setEnabled(false);
        frontEndInterestField.setEnabled(false);
        dbInterestField.setEnabled(false);
        otherWorkTypeSpecificField.setEnabled(false);
        resumeKnowledgeWidget.disableFields();
        OOPLevelField.setEnabled(false);
        dbLevelField.setEnabled(false);
        webLevelField.setEnabled(false);
        userInterfaceLevelField.setEnabled(false);
        umlLevelField.setEnabled(false);
        otherSkillsLevelField.setEnabled(false);
        workExperienceField.setEnabled(false);
        englishReadLevelField.setEnabled(false);
        englishWriteLevelField.setEnabled(false);
        englishSpeakLevelField.setEnabled(false);
        whereYouKnowAboutTCField.setEnabled(false);
        whyTakeYouInNetCrackerField.setEnabled(false);
        moreInformationAboutYouField.setEnabled(false);
        agreementCheckBox.setEnabled(false);*/

        uploadPhotoWidget.disableFields();
        surnameField.setReadOnly(true);
        nameField.setReadOnly(true);
        engSurnameField.setReadOnly(true);
        engNameField.setReadOnly(true);
        lastNameField.setReadOnly(true);
        instituteListBox.setEnabled(false);
        otherInstituteField.setReadOnly(true);
        courseField.setEnabled(false);
        facultyField.setReadOnly(true);
        departmentField.setReadOnly(true);
        specialtyField.setReadOnly(true);
        graduationYearField.setReadOnly(false);
        emailField.setReadOnly(true);
        telephoneField.setReadOnly(true);
        skypeField.setReadOnly(true);
        otherContactField.setReadOnly(true);
        trainingCenterInterestListBox.setEnabled(false);
        workInNetCrackerInterestListBox.setEnabled(false);
        otherJobInterestTextArea.setReadOnly(true);
        backEndInterestField.setEnabled(false);
        frontEndInterestField.setEnabled(false);
        dbInterestField.setEnabled(false);
        otherWorkTypeSpecificField.setReadOnly(true);
        resumeKnowledgeWidget.disableFields();
        OOPLevelField.setEnabled(false);
        dbLevelField.setEnabled(false);
        webLevelField.setEnabled(false);
        userInterfaceLevelField.setEnabled(false);
        umlLevelField.setEnabled(false);
        otherSkillsLevelField.setReadOnly(true);
        workExperienceField.setReadOnly(true);
        englishReadLevelField.setEnabled(false);
        englishWriteLevelField.setEnabled(false);
        englishSpeakLevelField.setEnabled(false);
        whereYouKnowAboutTCField.setReadOnly(true);
        whyTakeYouInNetCrackerField.setReadOnly(true);
        moreInformationAboutYouField.setReadOnly(true);
        agreementCheckBox.setEnabled(false);
    }

    public void clearFields() {
        uploadPhotoWidget.setUserImage("");
        surnameField.setText("");
        nameField.setText("");
        engSurnameField.setText("");
        engNameField.setText("");
        lastNameField.setText("");
        instituteListBox.setSelectedIndex(-1);
        otherInstituteField.setText("");
        courseField.setSelectedIndex(0);
        facultyField.setText("");
        departmentField.setText("");
        specialtyField.setText("");
        graduationYearField.setValue(null);
        emailField.setText("");
        telephoneField.setText("");
        skypeField.setText("");
        otherContactField.setText("");
        trainingCenterInterestListBox.setSelectedIndex(0);
        workInNetCrackerInterestListBox.setSelectedIndex(0);
        otherJobInterestTextArea.setText("");
        backEndInterestField.setSelectedIndex(0);
        frontEndInterestField.setSelectedIndex(0);
        dbInterestField.setSelectedIndex(0);
        otherWorkTypeSpecificField.setText("");
        OOPLevelField.setSelectedIndex(0);
        dbLevelField.setSelectedIndex(0);
        webLevelField.setSelectedIndex(0);
        userInterfaceLevelField.setSelectedIndex(0);
        umlLevelField.setSelectedIndex(0);
        otherSkillsLevelField.setText("");
        workExperienceField.setText("");
        englishReadLevelField.setSelectedIndex(0);
        englishWriteLevelField.setSelectedIndex(0);
        englishSpeakLevelField.setSelectedIndex(0);
        whereYouKnowAboutTCField.setText("");
        whyTakeYouInNetCrackerField.setText("");
        moreInformationAboutYouField.setText("");
        agreementCheckBox.setEnabled(false);
    }

  /*  public Button getDownloadButton() {
        return downloadButton;
    }*/

    interface Binder extends UiBinder<Widget, DevResumeWidget> {
    }
}