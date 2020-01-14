package com.netcracker.tc.shared.model.resume;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class DevResumeDetailDTO implements Serializable {

    private Long id;

    private InstituteDTO institute;
    @Size(min = 0, max = 50, message = "Максимальная длина названия института - 50 символов")
    private String instituteOtherName;
    @Size(min = 1, max = 10, message = "Максимальная длина курса - 10 символов")
    private String course;
    @Size(min = 1, max = 100, message = "Максимальная длина названия факультета - 100 символов")
    private String faculty;
    @Size(min = 1, max = 100, message = "Максимальная длина названия кафедры - 100 символов")
    private String department;
    @Size(min = 1, max = 100, message = "Максимальная длина названия специальности - 100 символов")
    private String specialty;
    private Integer graduationYear;
    @Size(max = 4000, message = "Максимальное количество символов для поля 'Другие контакты' - 4000 символов")
    private String otherContacts;
    private String trainingCenterInterest;
    private String workInNetCrackerInterest;
    @Size(max = 4000, message = "Максимальное количество символов для поля 'Другое' (Интересы) - 4000 символов")
    private String otherJobInterests;
    private String backEndInterest;
    private String frontEndInterest;
    private String dbInterest;
    @Size(max = 4000, message = "Максимальное количество символов для поля 'Другое' (Тип работы) - 4000 символов")
    private String otherWorkTypeSpecific;

    private Integer OOPLevel;
    private Integer dbLevel;
    private Integer webLevel;
    private Integer userInterfaceLevel;
    private Integer umlLevel;
    @Size(max = 4000, message = "Максимальное количество символов для поля 'Другие разделы' - 4000 символов")
    private String otherSkillsLevel;
    @Size(max = 4000, message = "Максимальное количество символов для поля 'Опыт работы' - 4000 символов")
    private String workExperience;
    private Integer englishReadLevel;
    private Integer englishWriteLevel;
    private Integer englishSpeakLevel;
    @Size(max = 4000, message = "Максимальное количество символов для поля 'Откуда вы узнали об Учебном центре' - 4000 символов")
    private String whereYouKnowAboutTC;
    @Size(max = 4000, message = "Максимальное количество символов для поля 'Почемувас нужно взять в УЦ'- 4000 символов")
    private String whyTakeYouInNetCracker;
    @Size(max = 4000, message = "Максимальное количество символов для поля 'Дополнительные сведения' - 4000 символов")
    private String moreInformationAboutYou;

    private ResumeDTO resume;

    public DevResumeDetailDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InstituteDTO getInstitute() {
        return institute;
    }

    public void setInstitute(InstituteDTO institute) {
        this.institute = institute;
    }

    public String getInstituteOtherName() {
        return instituteOtherName;
    }

    public void setInstituteOtherName(String instituteOtherName) {
        this.instituteOtherName = instituteOtherName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getOtherContacts() {
        return otherContacts;
    }

    public void setOtherContacts(String otherContacts) {
        this.otherContacts = otherContacts;
    }

    public String getTrainingCenterInterest() {
        return trainingCenterInterest;
    }

    public void setTrainingCenterInterest(String trainingCenterInterest) {
        this.trainingCenterInterest = trainingCenterInterest;
    }

    public String getWorkInNetCrackerInterest() {
        return workInNetCrackerInterest;
    }

    public void setWorkInNetCrackerInterest(String workInNetCrackerInterest) {
        this.workInNetCrackerInterest = workInNetCrackerInterest;
    }

    public String getOtherJobInterests() {
        return otherJobInterests;
    }

    public void setOtherJobInterests(String otherJobInterests) {
        this.otherJobInterests = otherJobInterests;
    }

    public String getBackEndInterest() {
        return backEndInterest;
    }

    public void setBackEndInterest(String backEndInterest) {
        this.backEndInterest = backEndInterest;
    }

    public String getFrontEndInterest() {
        return frontEndInterest;
    }

    public void setFrontEndInterest(String frontEndInterest) {
        this.frontEndInterest = frontEndInterest;
    }

    public String getDbInterest() {
        return dbInterest;
    }

    public void setDbInterest(String dbInterest) {
        this.dbInterest = dbInterest;
    }

    public String getOtherWorkTypeSpecific() {
        return otherWorkTypeSpecific;
    }

    public void setOtherWorkTypeSpecific(String otherWorkTypeSpecific) {
        this.otherWorkTypeSpecific = otherWorkTypeSpecific;
    }

    public Integer getOOPLevel() {
        return OOPLevel;
    }

    public void setOOPLevel(Integer OOPLevel) {
        this.OOPLevel = OOPLevel;
    }

    public Integer getDbLevel() {
        return dbLevel;
    }

    public void setDbLevel(Integer dbLevel) {
        this.dbLevel = dbLevel;
    }

    public Integer getWebLevel() {
        return webLevel;
    }

    public void setWebLevel(Integer webLevel) {
        this.webLevel = webLevel;
    }

    public Integer getUserInterfaceLevel() {
        return userInterfaceLevel;
    }

    public void setUserInterfaceLevel(Integer userInterfaceLevel) {
        this.userInterfaceLevel = userInterfaceLevel;
    }

    public Integer getUmlLevel() {
        return umlLevel;
    }

    public void setUmlLevel(Integer umlLevel) {
        this.umlLevel = umlLevel;
    }

    public String getOtherSkillsLevel() {
        return otherSkillsLevel;
    }

    public void setOtherSkillsLevel(String otherSkillsLevel) {
        this.otherSkillsLevel = otherSkillsLevel;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public Integer getEnglishReadLevel() {
        return englishReadLevel;
    }

    public void setEnglishReadLevel(Integer englishReadLevel) {
        this.englishReadLevel = englishReadLevel;
    }

    public Integer getEnglishWriteLevel() {
        return englishWriteLevel;
    }

    public void setEnglishWriteLevel(Integer englishWriteLevel) {
        this.englishWriteLevel = englishWriteLevel;
    }

    public Integer getEnglishSpeakLevel() {
        return englishSpeakLevel;
    }

    public void setEnglishSpeakLevel(Integer englishSpeakLevel) {
        this.englishSpeakLevel = englishSpeakLevel;
    }

    public String getWhereYouKnowAboutTC() {
        return whereYouKnowAboutTC;
    }

    public void setWhereYouKnowAboutTC(String whereYouKnowAboutTC) {
        this.whereYouKnowAboutTC = whereYouKnowAboutTC;
    }

    public String getWhyTakeYouInNetCracker() {
        return whyTakeYouInNetCracker;
    }

    public void setWhyTakeYouInNetCracker(String whyTakeYouInNetCracker) {
        this.whyTakeYouInNetCracker = whyTakeYouInNetCracker;
    }

    public String getMoreInformationAboutYou() {
        return moreInformationAboutYou;
    }

    public void setMoreInformationAboutYou(String moreInformationAboutYou) {
        this.moreInformationAboutYou = moreInformationAboutYou;
    }

    public ResumeDTO getResume() {
        return resume;
    }

    public void setResume(ResumeDTO resume) {
        this.resume = resume;
    }

    public String getInstituteDescription() {
        if (institute.isOtherInstitute()) {
            return instituteOtherName;
        }

        return institute.getDescription();
    }
}