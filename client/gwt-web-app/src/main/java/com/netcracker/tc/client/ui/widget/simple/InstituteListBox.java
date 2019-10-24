package com.netcracker.tc.client.ui.widget.simple;

import com.github.gwtbootstrap.client.ui.ListBox;
import com.netcracker.tc.shared.model.resume.InstituteDTO;

import java.util.List;

public class InstituteListBox extends ListBox {

    private List<InstituteDTO> instituteList;

    public InstituteListBox() {
    }

    public void setInstituteList(List<InstituteDTO> instituteList) {
        this.instituteList = instituteList;

        // TODO anky0315
        //clear();

        for (InstituteDTO instituteDTO: instituteList){
            addItem(instituteDTO.getDescription());
        }
    }

    public InstituteDTO getSelectedInstitute(){
        return instituteList.get(getSelectedIndex());
    }

    public void setInstitute(InstituteDTO institute) {
        if (institute == null){
            return;
        }

        for (int i=0; i< instituteList.size(); i++){
            if (instituteList.get(i).getId().equals(institute.getId())){
                setSelectedIndex(i);
            }
        }
    }
}