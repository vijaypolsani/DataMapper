package org.kp.digital.aem.personalization.components;

import com.univocity.parsers.csv.CsvFormat;
import com.univocity.parsers.csv.CsvParserSettings;
import dagger.Component;
import org.kp.digital.aem.personalization.modules.CsvFormatModule;
import org.kp.digital.aem.personalization.modules.CsvParserSettingsModule;

import javax.inject.Singleton;

/**
 * Created by vijay on 12/10/15.
 */
@Singleton
@Component(modules = {CsvParserSettingsModule.class, CsvFormatModule.class})
public interface CsvParserSettingsComponent {

    CsvParserSettings provideCsvParserSettings();

    CsvFormat provideCsvFormat();
}
