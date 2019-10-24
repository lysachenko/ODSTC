/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.netcracker.tc.shared.action;

import com.gwtplatform.dispatch.rpc.shared.Result;

/**
 *
 * @author anla1215
 */
public class ChangeRegistrationStatusResult implements Result {
    
    private Boolean isChanged;
    private Boolean hasErrors;

    private ChangeRegistrationStatusResult() {
    }   
    
    public ChangeRegistrationStatusResult(Boolean isChanged) {
        this.isChanged = isChanged;
        this.hasErrors = false;
    }

    public ChangeRegistrationStatusResult(Boolean isChanged, Boolean hasErrors) {
        this.isChanged = isChanged;
        this.hasErrors = hasErrors;
    }

    public Boolean getIsChanged() {
        return isChanged;
    }

    public void setIsChanged(Boolean isChanged) {
        this.isChanged = isChanged;
    }

    public Boolean getHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(Boolean hasErrors) {
        this.hasErrors = hasErrors;
    }
    
    
    
}
