package com.example.FiveReel.combinations.standart;

import com.example.FiveReel.combinations.CombinationElementI;
import com.example.FiveReel.combinations.CombinationManagerI;
import com.example.FiveReel.combinations.CombinationResult;
import com.example.FiveReel.combinations.SpinResult;
import com.example.FiveReel.utils.LogUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandartCombinationManager implements CombinationManagerI {


    @Override
    public CombinationResult calculate(SpinResult result) {
        CombinationResult combinationResult = new CombinationResult();
        List<Integer> selectedElements = result.getSelectedElements();
        Map<CombinationElementI, Integer> map = new HashMap<CombinationElementI, Integer>();
        for (Integer index : selectedElements) {
            CombinationElementI element = StandartCombinationElement.findElementByIndex(index);
            if (map.get(element) == null) {
                map.put(element, 1);
            } else {
                map.put(element, map.get(element) + 1);
            }
        }
        LogUtils.d("map = " + map);
        int commonMultiplier = 0;
        for (Map.Entry<CombinationElementI, Integer> entry : map.entrySet()) {
            CombinationElementI element = entry.getKey();
            Integer count = entry.getValue();
            if (count>2){
                combinationResult.setWin(true);
                commonMultiplier += element.getMultiplier()*count;
            }
        }
        LogUtils.d("commonMultiplier = " + commonMultiplier);
        combinationResult.setWinMultiplier(commonMultiplier);
        return combinationResult;
    }
}
