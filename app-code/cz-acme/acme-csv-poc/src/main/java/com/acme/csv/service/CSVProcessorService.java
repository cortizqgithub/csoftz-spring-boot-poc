/*----------------------------------------------------------------------------*/
/* Source File:   CSVPROCESSORSERVICE.JAVA                                    */
/* Copyright (c), 2023 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Sep.12/2023  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.csv.service;

import static com.acme.csv.consts.GlobalConstants.JSON_EXT;
import static com.acme.csv.consts.GlobalConstants.REGEX_DOT;
import static com.acme.csv.consts.GlobalConstants.SEPARATOR_DASH;
import static com.acme.csv.consts.GlobalConstants.SEPARATOR_SLASH;

import com.acme.csv.domain.document.LanguageDocument;
import com.acme.csv.service.intr.LanguageProcessorService;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

/**
 * Process CSV files with the header containing the following columns:
 * <u><li>u_key</li>
 * <li>u_language</li>
 * <li>u_text_value</li></u>
 * <p>The file is stored in a {@link LanguageDocument} structure.</p>
 *
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
public class CSVProcessorService implements LanguageProcessorService {
    private static final int CSV_U_KEY_POS = 0;
    private static final int CSV_U_LANGUAGE_POS = 1;
    private static final int CSV_U_TEXT_VALUE_POS = 2;
    private static final int CSV_U_ACTIVE_POS = 3;
    private static final int CSV_HEADER_LINE = 0;

    private static final String OUTPUT_FOLDER = "output";

    @Override
    public void process() {
        var processFolderPath = "/path/to/csv/files";

        listFilesUsing(processFolderPath)
            .forEach(csvFile -> {
                try {
                    processCSVMap(csvFile, processCSVFile(processFolderPath + SEPARATOR_SLASH + csvFile));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
    }

    private Map<String, Object> processCSVFile(String fileName) throws Exception {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Processing file [" + fileName + "]");
        var csvLines = readCSVAllLines(Path.of(new File(fileName).toURI()));

        csvLines.remove(CSV_HEADER_LINE);

        return convertCSVToMap(csvLines);
    }

    private void processCSVMap(String csvFile, Map<String, Object> csvMap) {
        csvMap.forEach((csvMapKey, csvMapValue) -> {

            var csvParts = csvFile.split(REGEX_DOT);
            var compoundId = csvMapKey + SEPARATOR_DASH + csvParts[CSV_U_KEY_POS];
            var csvMapValues = (Map<String, String>) csvMapValue;

            Optional<LanguageDocument> document;
            LanguageDocument languageDocument = null;

            document = retrieveDocumentFromJSON(compoundId);


            if (!document.isPresent()) {
                languageDocument = new LanguageDocument(csvMapValues, csvMapKey);
            } else {
                var documentValues = languageDocument.values();

                languageDocument = document.get();
                csvMapValues.forEach((documentKey, documentValue) -> {
                    if (documentValues.containsKey(documentKey)) {
                        documentValues.replace(documentKey, documentValue);
                    } else {
                        documentValues.put(documentKey, documentValue);
                    }
                });
            }


            updateDocumentToJSON(compoundId, languageDocument);
        });

        System.out.println("END processing CSV to Map");
    }

    private Map<String, Object> convertCSVToMap(List<String[]> csvLines) {
        var csvMap = new LinkedHashMap<String, Object>();
        var invalidTextList = List.of("<script", "<style");

        csvLines.forEach(line -> {
            var languageCode = line[CSV_U_LANGUAGE_POS].toLowerCase();

            if (!StringUtils.EMPTY.equals(languageCode)) {

                var lineKey = line[CSV_U_KEY_POS];
                var lineValue = line[CSV_U_TEXT_VALUE_POS];
                var lineActive = Boolean.valueOf(line[CSV_U_ACTIVE_POS]);

                if (lineActive && !StringUtils.EMPTY.equals(lineKey)) {
                    var lineValueValid = hasMatchingSubstring(lineValue, invalidTextList);

                    if (!lineValueValid) {
                        if (!csvMap.containsKey(languageCode)) {
                            var itemMap = new LinkedHashMap<String, String>();

                            itemMap.put(lineKey, lineValue);
                            csvMap.put(languageCode, itemMap);
                        } else {
                            var itemMap = (Map<String, String>) csvMap.get(languageCode);

                            if (!itemMap.containsKey(lineKey)) {
                                itemMap.put(lineKey, lineValue);
                            } else {
                                System.out.println("Duplicate [" + languageCode + "][" + lineKey + "][" + lineValue + "]");
                            }
                        }
                    }
                }
            }
        });

        return csvMap;
    }

    public List<String[]> readCSVAllLines(Path filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                return csvReader.readAll();
            }
        }
    }

    private Set<String> listFilesUsing(String dir) {
        return Stream.of(new File(dir).listFiles())
            .filter(file -> !file.isDirectory())
            .map(File::getName)
            .collect(Collectors.toSet());
    }

    private Optional<LanguageDocument> retrieveDocumentFromJSON(String compoundId) {
        var jsonFileName = "jsonWorkPath" + SEPARATOR_SLASH + "GSONFILES_FOLDER" + SEPARATOR_SLASH + compoundId + JSON_EXT;

        //  try {

        //  return Optional.ofNullable(new ObjectMapper().fromJson(new FileReader(jsonFileName), LanguageDocument.class));
        //} catch (FileNotFoundException e) {
        return Optional.empty();
        //}
    }

    private void updateDocumentToJSON(String compoundId, LanguageDocument languageDocument) {
        var jsonFileName = "jsonWorkPath" + SEPARATOR_SLASH + OUTPUT_FOLDER + SEPARATOR_SLASH + compoundId + JSON_EXT;

        System.out.println("Writing to [" + jsonFileName + "]");

       /* try {
            FileWriter writer = new FileWriter(jsonFileName);
            Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
            gson.toJson(languageDocument, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        */
    }

    private boolean hasMatchingSubstring(String str, List<String> substrings) {
        return substrings.stream().anyMatch(str::contains);
    }
}
