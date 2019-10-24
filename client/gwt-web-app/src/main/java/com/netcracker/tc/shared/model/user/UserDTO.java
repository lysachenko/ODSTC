package com.netcracker.tc.shared.model.user;

import com.netcracker.tc.client.validation.Registration;
import com.netcracker.tc.client.validation.SignIn;
import com.netcracker.tc.shared.model.interview.InterviewSlotDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserDTO implements Serializable {

    private Long id;

    @Size(min = 0, max = 50, message = "Максимальная длина email - 50 символов")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Неправильный email")
    private String login;
    @Pattern(regexp = "^((?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])).{6,15}$", message = "Пароль должен состоять из букв латинского алфавита, содержать минимум одну строчную букву, заглавную букву и цифру. Длина пароля от 6 до 15 символов")
    private String password;
    private RoleDTO role;

    private ResumeDTO resume;
    private StudentDetailDTO studentDetail;

    private Set<InterviewSlotDTO> interviewSlots = new HashSet<InterviewSlotDTO>(0);

    private Date lastLoginDate;

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public ResumeDTO getResume() {
        return resume;
    }

    public void setResume(ResumeDTO resume) {
        this.resume = resume;
    }

    public StudentDetailDTO getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetailDTO studentDetail) {
        this.studentDetail = studentDetail;
    }

    public Set<InterviewSlotDTO> getInterviewSlots() {
        return interviewSlots;
    }

    public void setInterviewSlots(Set<InterviewSlotDTO> interviewSlots) {
        this.interviewSlots = interviewSlots;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}