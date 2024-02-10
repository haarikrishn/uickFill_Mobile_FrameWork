package com.DmartLabs.commonutils;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

public class GSheetObject {

    Map<String, GSheet> gSheetMap;

    public GSheetObject(){
        this.gSheetMap = new HashMap<>();
    }
    public GSheet getGSheet(String sheetId) throws GeneralSecurityException, IOException {
        if(gSheetMap.containsKey(sheetId)){
            return gSheetMap.get(sheetId);
        }else {
            GSheet gSheet = new GSheet(sheetId);
            gSheetMap.put(sheetId, gSheet);
            return gSheet;
        }
    }

    /** Unit Test **/
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        GSheetObject gSheetUtils = new GSheetObject();
        String value1 = gSheetUtils.getGSheet("1pPkZ3wZNBMfMTJVFse7Aer_9eaw2Lmhbn2sU3Akoj9E").getCellValue("Sheet1", 3,"C");
        System.out.println("Value 1: " + value1);
        String value2 =gSheetUtils.getGSheet("1pPkZ3wZNBMfMTJVFse7Aer_9eaw2Lmhbn2sU3Akoj9E").getCellValue("Sheet1", 3,"C");
        System.out.println("Value 2: " + value2);
    }

}