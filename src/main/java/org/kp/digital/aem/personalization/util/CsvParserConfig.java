package org.kp.digital.aem.personalization.util;

import com.univocity.parsers.common.processor.RowProcessor;
import com.univocity.parsers.csv.CsvFormat;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

/**
 * Created by vijay on 11/11/15.
 */
public class CsvParserConfig {

    private static final char PIPE = '|';
    private final CsvParserSettings csvParserSettings = new CsvParserSettings();
    private final CsvFormat csvFormat = new CsvFormat();
    private final CsvParser csvParser;

    public CsvParserConfig(RowProcessor rowProcessor) {
        csvParserSettings.setLineSeparatorDetectionEnabled(true);
        csvParserSettings.setParseUnescapedQuotes(true);
        csvParserSettings.setHeaderExtractionEnabled(true);
        csvParserSettings.setRowProcessor(rowProcessor);
        csvFormat.setDelimiter(PIPE);
        csvParserSettings.setFormat(csvFormat);
        csvParser = new CsvParser(csvParserSettings);
    }

    public CsvParser getCsvParser() {
        return csvParser;
    }
}
