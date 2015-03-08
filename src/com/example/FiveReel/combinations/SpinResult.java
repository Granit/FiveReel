package com.example.FiveReel.combinations;

import java.util.ArrayList;
import java.util.List;

public class SpinResult {
    private List<Integer> selectedElements;

    public SpinResult(){
        selectedElements = new ArrayList<Integer>();
    }
    public List<Integer> getSelectedElements() {
        return selectedElements;
    }

    public void addSelectedElement(Integer selectedElement) {
        this.selectedElements.add(selectedElement);
    }
}
