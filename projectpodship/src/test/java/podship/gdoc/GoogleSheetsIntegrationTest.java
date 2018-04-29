/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package podship.gdoc;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesResponse;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * 1gBWrpfxHi1p9UgAsOKxJddWZBXWZ_1QDAGWOT2WRed0
 */
public class GoogleSheetsIntegrationTest {

    private static Sheets sheetsService;
    private static String SPREADSHEET_ID = "1gBWrpfxHi1p9UgAsOKxJddWZBXWZ_1QDAGWOT2WRed0";

    public GoogleSheetsIntegrationTest() {
    }

    @BeforeClass
    public static void setup() throws GeneralSecurityException, IOException {
        sheetsService = SheetsServiceUtil.getSheetsService();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void whenWriteSheet_thenReadSheetOk() throws IOException {
//        ValueRange body = new ValueRange()
//                .setValues(Arrays.asList(
//                        Arrays.asList("Expenses January"),
//                        Arrays.asList("books", "30"),
//                        Arrays.asList("pens", "10"),
//                        Arrays.asList("Expenses February"),
//                        Arrays.asList("clothes", "20"),
//                        Arrays.asList("shoes", "5")));
//        UpdateValuesResponse result = sheetsService.spreadsheets().values()
//                .update(SPREADSHEET_ID, "A1", body)
//                .setValueInputOption("RAW")
//                .execute();
//
//        List<ValueRange> data = new ArrayList<>();
//        data.add(new ValueRange()
//                .setRange("D1")
//                .setValues(Arrays.asList(
//                        Arrays.asList("January Total", "=B2+B3"))));
//        data.add(new ValueRange()
//                .setRange("D4")
//                .setValues(Arrays.asList(
//                        Arrays.asList("February Total", "=B5+B6"))));
//
//        BatchUpdateValuesRequest batchBody = new BatchUpdateValuesRequest()
//                .setValueInputOption("USER_ENTERED")
//                .setData(data);
//
//        BatchUpdateValuesResponse batchResult = sheetsService.spreadsheets().values()
//                .batchUpdate(SPREADSHEET_ID, batchBody)
//                .execute();
//
//        ValueRange appendBody = new ValueRange()
//                .setValues(Arrays.asList(
//                        Arrays.asList("Total", "=E1+E4")));
//        AppendValuesResponse appendResult = sheetsService.spreadsheets().values()
//                .append(SPREADSHEET_ID, "A1", appendBody)
//                .setValueInputOption("USER_ENTERED")
//                .setInsertDataOption("INSERT_ROWS")
//                .setIncludeValuesInResponse(true)
//                .execute();
//
//        ValueRange total = appendResult.getUpdates().getUpdatedData();
//        assertEquals(total.getValues().get(0).get(1), "65");
//
        List<String> ranges = Arrays.asList("E1", "E4");
        BatchGetValuesResponse readResult = sheetsService.spreadsheets().values()
                .batchGet(SPREADSHEET_ID)
                .setRanges(ranges)
                .execute();

        ValueRange januaryTotal = readResult.getValueRanges().get(0);
        assertEquals("40", januaryTotal.getValues().get(0).get(0));

        ValueRange febTotal = readResult.getValueRanges().get(1);
        assertEquals("25", febTotal.getValues().get(0).get(0));
    }

}
