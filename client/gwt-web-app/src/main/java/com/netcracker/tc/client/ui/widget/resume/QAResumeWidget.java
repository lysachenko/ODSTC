package com.netcracker.tc.client.ui.widget.resume;

import com.github.gwtbootstrap.client.ui.*;
import com.github.gwtbootstrap.datetimepicker.client.ui.DateTimeBoxAppended;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.CalendarUtil;
import com.netcracker.tc.client.ui.widget.simple.InstituteListBox;
import com.netcracker.tc.client.ui.widget.simple.SkillLevelListBox;
import com.netcracker.tc.client.validation.ValidationFactory;
import com.netcracker.tc.shared.model.resume.DevResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.InstituteDTO;
import com.netcracker.tc.shared.model.resume.QAResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;

import javax.validation.ConstraintViolation;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class QAResumeWidget extends Composite {

    private static Binder uiBinder = GWT.create(Binder.class);
    @UiField
    UploadPhotoWidget uploadPhotoWidget;
    @UiField
    TextBox surnameField;
    @UiField
    TextBox nameField;
    @UiField
    TextBox lastNameField;
    @UiField
    InstituteListBox instituteListBox;
    @UiField
    Row otherInstituteRow;
    @UiField
    TextBox otherInstituteField;
    @UiField
    TextBox courseField;
    @UiField
    TextBox facultyField;
    @UiField
    DateTimeBoxAppended graduationYearField;
    @UiField
    ListBox isStudentBox;
    @UiField
    TextBox emailField;
    @UiField
    TextBox telephoneField;
    @UiField
    TextBox skypeField;
    @UiField
    TextArea otherContactField;
    @UiField
    CheckBox trainingCenterInterestField;
    @UiField
    CheckBox workInNetCrackerInterestField;
    @UiField
    TextArea otherInterestTextArea;
    @UiField
    CheckBox qaDevelopmentField;
    @UiField
    CheckBox softwareDevelopmentField;
    @UiField
    TextArea otherJobInterestTextArea;
    @UiField
    CheckBox qaExpertWorkTypeField;
    @UiField
    CheckBox qaAutomationWorkTypeField;
    @UiField
    CheckBox qaDevelopmentWorkTypeField;
    @UiField
    CheckBox softwareDevelopmentWorkTypeField;
    @UiField
    CheckBox leadershipWorkTypeField;
    @UiField
    TextArea otherWorkTypeSpecificField;
    @UiField
    SkillLevelListBox softwareDevLifeCycleField;
    @UiField
    SkillLevelListBox qaRoleInLifeCycleField;
    @UiField
    SkillLevelListBox whatIsTestCaseField;
    @UiField
    SkillLevelListBox whatIsDefectField;
    @UiField
    SkillLevelListBox testingTypeField;
    @UiField
    SkillLevelListBox networkTechnologyLevelField;
    @UiField
    SkillLevelListBox OOPLevelField;
    @UiField
    SkillLevelListBox dbSqlLevelField;
    @UiField
    SkillLevelListBox clientServerArchitectureAndWebField;
    @UiField
    TextArea otherSkillsLevelField;
    @UiField
    TextArea workExperienceField;
    @UiField
    SkillLevelListBox englishReadLevelField;
    @UiField
    SkillLevelListBox englishWriteLevelField;
    @UiField
    SkillLevelListBox englishSpeakLevelField;
    @UiField
    TextArea whereYouKnowAboutTCField;
    @UiField
    TextArea whyTakeYouInNetCrackerField;
    @UiField
    TextArea moreInformationAboutYouField;
    @UiField
    CheckBox agreementCheckBox;

    @UiField
    Tooltip surnameTooltip;
    @UiField
    Tooltip nameTooltip;
    @UiField
    Tooltip lastNameTooltip;
    @UiField
    Tooltip courseTooltip;
    @UiField
    Tooltip otherInstituteTooltip;
    @UiField
    Tooltip facultyTooltip;
    //    @UiField
//    Tooltip graduationYearTooltip;
    @UiField
    Tooltip uploadPhotoTooltip;
    @UiField
    Tooltip emailTooltip;
    @UiField
    Tooltip telephoneTooltip;
    @UiField
    Tooltip skypeTooltip;
    @UiField
    Tooltip otherContactTooltip;
    @UiField
    Tooltip otherInterestTooltip;
    @UiField
    Tooltip otherJobTooltip;
    @UiField
    Tooltip otherWorkTypeSpecificTooltip;
    @UiField
    Tooltip otherSkillsLevelTooltip;
    @UiField
    Tooltip workExperienceTooltip;
    @UiField
    Tooltip whereYouKnowAboutTCTooltip;
    @UiField
    Tooltip whyTakeYouInNetCrackerTooltip;
    @UiField
    Tooltip moreInformationAboutYouTooltip;
    @UiField
    Tooltip agreementTooltip;

    @UiField
    ControlGroup surnameGroup;
    @UiField
    ControlGroup nameGroup;
    @UiField
    ControlGroup lastNameGroup;
    @UiField
    ControlGroup otherInstituteGroup;
    @UiField
    ControlGroup courseGroup;
    @UiField
    ControlGroup facultyGroup;
    @UiField
    ControlGroup graduationYearGroup;
    @UiField
    ControlGroup uploadPhotoGroup;
    @UiField
    ControlGroup emailGroup;
    @UiField
    ControlGroup telephoneGroup;
    @UiField
    ControlGroup skypeGroup;
    @UiField
    ControlGroup otherContactGroup;
    @UiField
    ControlGroup otherInterestGroup;
    @UiField
    ControlGroup otherJobGroup;
    @UiField
    ControlGroup otherWorkTypeSpecificGroup;
    @UiField
    ControlGroup otherSkillsLevelGroup;
    @UiField
    ControlGroup workExperienceGroup;
    @UiField
    ControlGroup whereYouKnowAboutTCGroup;
    @UiField
    ControlGroup whyTakeYouInNetCrackerGroup;
    @UiField
    ControlGroup moreInformationAboutYouGroup;
    @UiField
    ControlGroup agreementGroup;

    @UiField
    AlertBlock errorAlertBlock;

   /* @UiField
    Button downloadButton;*/

    public QAResumeWidget() {
        initWidget(uiBinder.createAndBindUi(this));

        graduationYearField.getWidget(0).setWidth("179px");

        instituteListBox.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                otherInstituteRow.setVisible(instituteListBox.getSelectedInstitute().isOtherInstitute());
            }
        });
    }

    public ResumeDTO getQAResume() {
        ResumeDTO resumeDTO = new ResumeDTO();

        resumeDTO.setSurname(surnameField.getText());
        resumeDTO.setName(nameField.getText());
        resumeDTO.setLastName(lastNameField.getText());
        resumeDTO.setEmail(emailField.getText());
        resumeDTO.setTelephoneNum(telephoneField.getText());
        resumeDTO.setSkype(skypeField.getText());
        resumeDTO.setPhotoPath(uploadPhotoWidget.getUserPhoto());

        QAResumeDetailDTO qaResumeDetailDTO = new QAResumeDetailDTO();
        qaResumeDetailDTO.setInstitute(instituteListBox.getSelectedInstitute());
        if (instituteListBox.getSelectedInstitute().isOtherInstitute()) {
            qaResumeDetailDTO.setInstituteOtherName(otherInstituteField.getText());
        } else {
            qaResumeDetailDTO.setInstituteOtherName(null);
        }
        qaResumeDetailDTO.setCourse(courseField.getValue());
        qaResumeDetailDTO.setFaculty(facultyField.getText());
//        qaResumeDetailDTO.setDepartment(departmentField.getText());
        if (graduationYearField.getValue() != null){
            DateTimeFormat format = DateTimeFormat.getFormat("yyyy");
            String year = format.format(graduationYearField.getValue());
            qaResumeDetailDTO.setGraduationYear(Integer.valueOf(year));
        }
//        if (graduationYearField.getText().matches("[0-9]*")) {
//            if (!graduationYearField.getText().isEmpty()) {
//                qaResumeDetailDTO.setGraduationYear(Integer.parseInt(graduationYearField.getText()));
//            }
//        }
        qaResumeDetailDTO.setIsStudent(isStudentBox.getSelectedIndex() == 1);
        qaResumeDetailDTO.setOtherContacts(otherContactField.getText());
        qaResumeDetailDTO.setTrainingCenterInterest(trainingCenterInterestField.getValue());
        qaResumeDetailDTO.setWorkInNetCrackerInterest(workInNetCrackerInterestField.getValue());
        qaResumeDetailDTO.setOtherInterests(otherInterestTextArea.getText());

        qaResumeDetailDTO.setQaDevelopment(qaDevelopmentField.getValue());
        qaResumeDetailDTO.setSoftwareDevelopment(softwareDevelopmentField.getValue());
        qaResumeDetailDTO.setOtherJobInterests(otherJobInterestTextArea.getText());
        qaResumeDetailDTO.setQaExpertWorkType(qaExpertWorkTypeField.getValue());
        qaResumeDetailDTO.setQaAutomationWorkType(qaAutomationWorkTypeField.getValue());
        qaResumeDetailDTO.setQaDevelopmentWorkType(qaDevelopmentWorkTypeField.getValue());
        qaResumeDetailDTO.setSoftwareDevelopmentWorkType(softwareDevelopmentWorkTypeField.getValue());
        qaResumeDetailDTO.setLeadershipWorkType(leadershipWorkTypeField.getValue());
        qaResumeDetailDTO.setOtherWorkTypeSpecific(otherWorkTypeSpecificField.getText());

        qaResumeDetailDTO.setSoftwareDevLifeCycle(softwareDevLifeCycleField.getSelectedSkill());
        qaResumeDetailDTO.setQaRoleInLifeCycle(qaRoleInLifeCycleField.getSelectedSkill());
        qaResumeDetailDTO.setWhatIsTestCase(whatIsTestCaseField.getSelectedSkill());
        qaResumeDetailDTO.setWhatIsDefect(whatIsDefectField.getSelectedSkill());
        qaResumeDetailDTO.setTestingType(testingTypeField.getSelectedSkill());
        qaResumeDetailDTO.setNetworkTechnology(networkTechnologyLevelField.getSelectedSkill());
        qaResumeDetailDTO.setOOP(OOPLevelField.getSelectedSkill());
        qaResumeDetailDTO.setDbSql(dbSqlLevelField.getSelectedSkill());
        qaResumeDetailDTO.setClientServerArchitectureAndWeb(clientServerArchitectureAndWebField.getSelectedSkill());

        qaResumeDetailDTO.setOtherSkillsLevel(otherSkillsLevelField.getText());
        qaResumeDetailDTO.setWorkExperience(workExperienceField.getText());
        qaResumeDetailDTO.setEnglishReadLevel(englishReadLevelField.getSelectedSkill());
        qaResumeDetailDTO.setEnglishSpeakLevel(englishSpeakLevelField.getSelectedSkill());
        qaResumeDetailDTO.setEnglishWriteLevel(englishWriteLevelField.getSelectedSkill());
        qaResumeDetailDTO.setWhereYouKnowAboutTC(whereYouKnowAboutTCField.getText());
        qaResumeDetailDTO.setWhyTakeYouInNetCracker(whyTakeYouInNetCrackerField.getText());
        qaResumeDetailDTO.setMoreInformationAboutYou(moreInformationAboutYouField.getText());

        resumeDTO.setQaResumeDetail(qaResumeDetailDTO);

        return resumeDTO;
    }

    public void setQAResume(ResumeDTO resume) {
        if (resume != null) {
            QAResumeDetailDTO qaResumeDetail = resume.getQaResumeDetail();

            uploadPhotoWidget.setUserImage(resume.getPhotoPath());
            surnameField.setText(resume.getSurname());
            nameField.setText(resume.getName());
            lastNameField.setText(resume.getLastName());
            emailField.setText(resume.getEmail());
            telephoneField.setText(resume.getTelephoneNum());
            skypeField.setText(resume.getSkype());

            if (qaResumeDetail != null) {
                instituteListBox.setInstitute(qaResumeDetail.getInstitute());
                if (qaResumeDetail.getInstitute().isOtherInstitute()) {
                    otherInstituteRow.setVisible(true);
                    otherInstituteField.setText(qaResumeDetail.getInstituteOtherName());
                }

//                departmentField.setText(qaResumeDetail.getDepartment());
                courseField.setValue(qaResumeDetail.getCourse());
                facultyField.setText(qaResumeDetail.getFaculty());

                if (qaResumeDetail.getGraduationYear() !=null){
                    DateTimeFormat format = DateTimeFormat.getFormat("yyyy");
                    Date year = format.parse(qaResumeDetail.getGraduationYear().toString());
                    graduationYearField.setValue(year);
                } else {
                    graduationYearField.setValue(null);
                }
                isStudentBox.setSelectedIndex(qaResumeDetail.getIsStudent() ? 1 : 0);
                otherContactField.setText(qaResumeDetail.getOtherContacts());

                trainingCenterInterestField.setValue(qaResumeDetail.getTrainingCenterInterest());
                workInNetCrackerInterestField.setValue(qaResumeDetail.getWorkInNetCrackerInterest());
                otherInterestTextArea.setValue(qaResumeDetail.getOtherInterests());
                qaDevelopmentField.setValue(qaResumeDetail.getQaDevelopment());
                softwareDevelopmentField.setValue(qaResumeDetail.getSoftwareDevelopment());
                otherJobInterestTextArea.setValue(qaResumeDetail.getOtherJobInterests());
                qaExpertWorkTypeField.setValue(qaResumeDetail.getQaExpertWorkType());
                qaAutomationWorkTypeField.setValue(qaResumeDetail.getQaAutomationWorkType());
                qaDevelopmentWorkTypeField.setValue(qaResumeDetail.getQaDevelopmentWorkType());
                softwareDevelopmentWorkTypeField.setValue(qaResumeDetail.getSoftwareDevelopmentWorkType());
                leadershipWorkTypeField.setValue(qaResumeDetail.getLeadershipWorkType());
                otherWorkTypeSpecificField.setValue(qaResumeDetail.getOtherWorkTypeSpecific());

                softwareDevLifeCycleField.setSelectedSkill(qaResumeDetail.getSoftwareDevLifeCycle());
                qaRoleInLifeCycleField.setSelectedSkill(qaResumeDetail.getQaRoleInLifeCycle());
                whatIsTestCaseField.setSelectedSkill(qaResumeDetail.getWhatIsTestCase());
                whatIsDefectField.setSelectedSkill(qaResumeDetail.getWhatIsDefect());
                testingTypeField.setSelectedSkill(qaResumeDetail.getTestingType());
                networkTechnologyLevelField.setSelectedSkill(qaResumeDetail.getNetworkTechnology());
                OOPLevelField.setSelectedSkill(qaResumeDetail.getOOP());
                dbSqlLevelField.setSelectedSkill(qaResumeDetail.getDbSql());
                clientServerArchitectureAndWebField.setSelectedSkill(qaResumeDetail.getClientServerArchitectureAndWeb());

                otherSkillsLevelField.setText(qaResumeDetail.getOtherSkillsLevel());
                workExperienceField.setText(qaResumeDetail.getWorkExperience());
                englishReadLevelField.setSelectedSkill(qaResumeDetail.getEnglishReadLevel());
                englishWriteLevelField.setSelectedSkill(qaResumeDetail.getEnglishWriteLevel());
                englishSpeakLevelField.setSelectedSkill(qaResumeDetail.getEnglishSpeakLevel());
                whereYouKnowAboutTCField.setText(qaResumeDetail.getWhereYouKnowAboutTC());
                whyTakeYouInNetCrackerField.setText(qaResumeDetail.getWhyTakeYouInNetCracker());
                moreInformationAboutYouField.setText(qaResumeDetail.getMoreInformationAboutYou());
            }
        }
    }

    public boolean isValid() {
        boolean valid = true;

        ResumeDTO resumeDTO = getQAResume();
        Set<ConstraintViolation<ResumeDTO>> violations = ValidationFactory.validate(resumeDTO);
        Set<ConstraintViolation<QAResumeDetailDTO>> violations2 = ValidationFactory.validate(resumeDTO.getQaResumeDetail());

        surnameTooltip.setText("");
        nameTooltip.setText("");
        lastNameTooltip.setText("");
        courseTooltip.setText("");
        facultyTooltip.setText("");
//        graduationYearTooltip.setText("");
        emailTooltip.setText("");
        telephoneTooltip.setText("");
        skypeTooltip.setText("");
        otherContactTooltip.setText("");
        otherInterestTooltip.setText("");
        otherJobTooltip.setText("");
        otherWorkTypeSpecificTooltip.setText("");
        otherSkillsLevelTooltip.setText("");
        workExperienceTooltip.setText("");
        whereYouKnowAboutTCTooltip.setText("");
        whyTakeYouInNetCrackerTooltip.setText("");
        moreInformationAboutYouTooltip.setText("");
        agreementTooltip.setText("");

        nameGroup.setStyleName("control-group none");
        surnameGroup.setStyleName("control-group none");
        lastNameGroup.setStyleName("control-group none");
        telephoneGroup.setStyleName("control-group none");
        skypeGroup.setStyleName("control-group none");
        uploadPhotoGroup.setStyleName("control-group none");
        otherInstituteGroup.setStyleName("control-group none");
        courseGroup.setStyleName("control-group none");
        facultyGroup.setStyleName("control-group none");
        emailGroup.setStyleName("control-group none");
        otherContactGroup.setStyleName("control-group none");
        otherInterestGroup.setStyleName("control-group none");
        otherJobGroup.setStyleName("control-group none");
        otherWorkTypeSpecificGroup.setStyleName("control-group none");
        otherSkillsLevelGroup.setStyleName("control-group none");
        whereYouKnowAboutTCGroup.setStyleName("control-group none");
        whyTakeYouInNetCrackerGroup.setStyleName("control-group none");
        moreInformationAboutYouGroup.setStyleName("control-group none");
        workExperienceGroup.setStyleName("control-group none");
        errorAlertBlock.setVisible(false);

        for (ConstraintViolation violation : violations) {
            if (violation.getPropertyPath().toString().equals("name")) {
                nameTooltip.setText(violation.getMessage());
                nameGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("surname")) {
                surnameTooltip.setText(violation.getMessage());
                surnameGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("lastName")) {
                lastNameTooltip.setText(violation.getMessage());
                lastNameGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("email")) {
                emailTooltip.setText(violation.getMessage());
                emailGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("telephoneNum")) {
                telephoneTooltip.setText(violation.getMessage());
                telephoneGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("skype")) {
                skypeTooltip.setText(violation.getMessage());
                skypeGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("photoPath")) {
                uploadPhotoTooltip.setText(violation.getMessage());
                uploadPhotoGroup.setStyleName("control-group error");
            }
            valid = false;
        }

        for (ConstraintViolation violation : violations2) {
            if (violation.getPropertyPath().toString().equals("instituteOtherName")) {
                otherInstituteTooltip.setText(violation.getMessage());
                otherInstituteGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("course")) {
                courseTooltip.setText(violation.getMessage());
                courseGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("faculty")) {
                facultyTooltip.setText(violation.getMessage());
                facultyGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("otherContacts")) {
                otherContactTooltip.setText(violation.getMessage());
                otherContactGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("otherInterests")) {
                otherInterestTooltip.setText(violation.getMessage());
                otherInterestGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("otherJobInterests")) {
                otherJobTooltip.setText(violation.getMessage());
                otherJobGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("otherWorkTypeSpecific")) {
                otherWorkTypeSpecificTooltip.setText(violation.getMessage());
                otherWorkTypeSpecificGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("otherSkillsLevel")) {
                otherSkillsLevelTooltip.setText(violation.getMessage());
                otherSkillsLevelGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("workExperience")) {
                workExperienceTooltip.setText(violation.getMessage());
                workExperienceGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("whereYouKnowAboutTC")) {
                whereYouKnowAboutTCTooltip.setText(violation.getMessage());
                whereYouKnowAboutTCGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("whyTakeYouInNetCracker")) {
                whyTakeYouInNetCrackerTooltip.setText(violation.getMessage());
                whyTakeYouInNetCrackerGroup.setStyleName("control-group error");
            }
            if (violation.getPropertyPath().toString().equals("moreInformationAboutYou")) {
                moreInformationAboutYouTooltip.setText(violation.getMessage());
                moreInformationAboutYouGroup.setStyleName("control-group error");
            }
            valid = false;
        }

//        if (graduationYearField.getText().matches("[0-9]*")) {
//            graduationYearGroup.setStyleName("control-group none");
//        } else {
//            valid = false;
//            graduationYearGroup.setStyleName("control-group error");
//            graduationYearTooltip.setText("Год окончания должен состоять из цифр.");
//        }

        if (agreementCheckBox.getValue() == Boolean.TRUE){
            agreementGroup.setStyleName("control-group none");
        } else {
            valid = false;
            agreementGroup.setStyleName("control-group error");
        }

        errorAlertBlock.setVisible(!valid);
        errorAlertBlock.setText("Заполните, пожалуйста, все поля, помеченные символом *");

        surnameTooltip.reconfigure();
        nameTooltip.reconfigure();
        lastNameTooltip.reconfigure();
        otherInstituteTooltip.reconfigure();
        courseTooltip.reconfigure();
        facultyTooltip.reconfigure();
//        graduationYearTooltip.reconfigure();
        uploadPhotoTooltip.reconfigure();
        emailTooltip.reconfigure();
        telephoneTooltip.reconfigure();
        skypeTooltip.reconfigure();
        otherContactTooltip.reconfigure();
        otherInterestTooltip.reconfigure();
        otherJobTooltip.reconfigure();
        otherWorkTypeSpecificTooltip.reconfigure();
        otherSkillsLevelTooltip.reconfigure();
        workExperienceTooltip.reconfigure();
        whereYouKnowAboutTCTooltip.reconfigure();
        whyTakeYouInNetCrackerTooltip.reconfigure();
        moreInformationAboutYouTooltip.reconfigure();
        agreementTooltip.reconfigure();

        return valid;
    }

    public void setInstitutes(List<InstituteDTO> instituteDTOList) {
        instituteListBox.setInstituteList(instituteDTOList);
    }

    public void disableFields() {
         uploadPhotoWidget.disableFields();
         surnameField.setEnabled(false);
         nameField.setEnabled(false);
         lastNameField.setEnabled(false);
         instituteListBox.setEnabled(false);
         otherInstituteField.setEnabled(false);
         courseField.setEnabled(false);
         facultyField.setEnabled(false);
         graduationYearField.setReadOnly(true);
         isStudentBox.setEnabled(false);
         emailField.setEnabled(false);
         telephoneField.setEnabled(false);
         skypeField.setEnabled(false);
         otherContactField.setEnabled(false);
         trainingCenterInterestField.setEnabled(false);
         workInNetCrackerInterestField.setEnabled(false);
         otherInterestTextArea.setEnabled(false);
         qaDevelopmentField.setEnabled(false);
         softwareDevelopmentField.setEnabled(false);
         otherJobInterestTextArea.setEnabled(false);
         qaExpertWorkTypeField.setEnabled(false);
         qaAutomationWorkTypeField.setEnabled(false);
         qaDevelopmentWorkTypeField.setEnabled(false);
         softwareDevelopmentWorkTypeField.setEnabled(false);
         leadershipWorkTypeField.setEnabled(false);
         otherWorkTypeSpecificField.setEnabled(false);
         softwareDevLifeCycleField.setEnabled(false);
         qaRoleInLifeCycleField.setEnabled(false);
         whatIsTestCaseField.setEnabled(false);
         whatIsDefectField.setEnabled(false);
         testingTypeField.setEnabled(false);
         networkTechnologyLevelField.setEnabled(false);
         OOPLevelField.setEnabled(false);
         dbSqlLevelField.setEnabled(false);
         clientServerArchitectureAndWebField.setEnabled(false);
         otherSkillsLevelField.setEnabled(false);
         workExperienceField.setEnabled(false);
         englishReadLevelField.setEnabled(false);
         englishWriteLevelField.setEnabled(false);
         englishSpeakLevelField.setEnabled(false);
         whereYouKnowAboutTCField.setEnabled(false);
         whyTakeYouInNetCrackerField.setEnabled(false);
         moreInformationAboutYouField.setEnabled(false);
         agreementCheckBox.setEnabled(false);
    }

    public void clearFields() {
        uploadPhotoWidget.setUserImage("");

        surnameField.setText("");
        nameField.setText("");
        lastNameField.setText("");
        instituteListBox.setSelectedIndex(-1);
        otherInstituteField.setText("");
        courseField.setText("");
        facultyField.setText("");
        graduationYearField.setValue(null);
        isStudentBox.setSelectedIndex(-1);
        emailField.setText("");
        telephoneField.setText("");
        skypeField.setText("");
        otherContactField.setText("");
        trainingCenterInterestField.setValue(false);
        workInNetCrackerInterestField.setValue(false);
        otherInterestTextArea.setText("");
        qaDevelopmentField.setValue(false);
        softwareDevelopmentField.setValue(false);
        otherJobInterestTextArea.setText("");
        qaExpertWorkTypeField.setValue(false);
        qaAutomationWorkTypeField.setValue(false);
        qaDevelopmentWorkTypeField.setValue(false);
        softwareDevelopmentWorkTypeField.setValue(false);
        leadershipWorkTypeField.setValue(false);
        otherWorkTypeSpecificField.setText("");
        softwareDevLifeCycleField.setSelectedIndex(-1);
        qaRoleInLifeCycleField.setSelectedIndex(-1);
        whatIsTestCaseField.setSelectedIndex(-1);
        whatIsDefectField.setSelectedIndex(-1);
        testingTypeField.setSelectedIndex(-1);
        networkTechnologyLevelField.setSelectedIndex(-1);
        OOPLevelField.setSelectedIndex(-1);
        dbSqlLevelField.setSelectedIndex(-1);
        clientServerArchitectureAndWebField.setSelectedIndex(-1);
        otherSkillsLevelField.setText("");
        workExperienceField.setText("");
        englishReadLevelField.setSelectedIndex(-1);
        englishWriteLevelField.setSelectedIndex(-1);
        englishSpeakLevelField.setSelectedIndex(-1);
        whereYouKnowAboutTCField.setText("");
        whyTakeYouInNetCrackerField.setText("");
        moreInformationAboutYouField.setText("");
    }

/*    public Button getDownloadButton() {
        return downloadButton;
    }*/

    interface Binder extends UiBinder<Widget, QAResumeWidget> {
    }
}