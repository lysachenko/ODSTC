package com.netcracker.tc.shared.model.resume;

import com.netcracker.tc.shared.model.user.UserDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by unconsionable on 05.08.2014.
 */
public class ResumeDTO implements Serializable {

    private Long id;
    private ResumeStatusDTO resumeStatus;
    private Long version;
    private String errorDescription;
    private Date modifiedDate;
    private Date approvedDate;

    @NotNull(message = "Введите имя")
    @Size(min = 1, max = 30, message = "Максимальная длина имени - 30 символов")
    @Pattern(regexp = "^[^!^~#$%^&*()<>]+$", message = "Нельзя использовать спецсимволы")
    private String name;

    @NotNull(message = "Введите фамилию")
    @Size(min = 1, max = 30, message = "Максимальная длина фамилии - 30 символов")
    @Pattern(regexp = "^[^!^~#$%^&*()<>]+$", message = "Нельзя использовать спецсимволы")
    private String surname;

    @NotNull(message = "Введите имя")
    @Size(min = 1, max = 30, message = "Максимальная длина имени - 30 символов")
    @Pattern(regexp = "^[^!^~#$%^&*()<>]+$", message = "Нельзя использовать спецсимволы")
    private String engName;

    public String getEngSurname() {
        return engSurname;
    }

    public void setEngSurname(String engSurname) {
        this.engSurname = engSurname;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    @NotNull(message = "Введите фамилию")
    @Size(min = 1, max = 30, message = "Максимальная длина фамилии - 30 символов")
    @Pattern(regexp = "^[^!^~#$%^&*()<>]+$", message = "Нельзя использовать спецсимволы")
    private String engSurname;

    @NotNull(message = "Введите отчество")
    @Size(min = 1, max = 30, message = "Максимальная длина отчества - 30 символов")
    @Pattern(regexp = "^[^!^~#$%^&*()<>]+$", message = "Нельзя использовать спецсимволы")
    private String lastName;
    @Size(min = 0, max = 50, message = "Максимальная длина email - 50 символов")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Неправильный email")
    private String email;
//    @Pattern(regexp = "^(\\([0-9]{3}\\))+([0-9]{3}\\-)+([0-9]{2}\\-)+([0-9]{2})$", message = "Неправильный номер телефона")
    private String telephoneNum;
    @Size(max = 30, message = "Максимальная длина skype - 30 символов")
    private String skype;
    @NotNull(message = "Выберите фотографию")
    @Size(min = 1, message = "Выберите фотографию")
    private String photoPath;

    private DevResumeDetailDTO devResumeDetail;
    private QAResumeDetailDTO qaResumeDetail;

    private UserDTO user;

    private List<ResumeKnowledgeDTO> resumeKnowledges = new ArrayList<ResumeKnowledgeDTO>();

    public ResumeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ResumeStatusDTO getResumeStatus() {
        return resumeStatus;
    }

    public void setResumeStatus(ResumeStatusDTO resumeStatus) {
        this.resumeStatus = resumeStatus;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public DevResumeDetailDTO getDevResumeDetail() {
        return devResumeDetail;
    }

    public void setDevResumeDetail(DevResumeDetailDTO devResumeDetail) {
        this.devResumeDetail = devResumeDetail;
    }

    public QAResumeDetailDTO getQaResumeDetail() {
        return qaResumeDetail;
    }

    public void setQaResumeDetail(QAResumeDetailDTO qaResumeDetail) {
        this.qaResumeDetail = qaResumeDetail;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<ResumeKnowledgeDTO> getResumeKnowledges() {
        return resumeKnowledges;
    }

    public void setResumeKnowledges(List<ResumeKnowledgeDTO> resumeKnowledges) {
        this.resumeKnowledges = resumeKnowledges;
    }
}