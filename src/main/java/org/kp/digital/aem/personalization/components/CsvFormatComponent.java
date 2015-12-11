package org.kp.digital.aem.personalization.components;

import com.univocity.parsers.csv.CsvFormat;
import dagger.Component;
import org.kp.digital.aem.personalization.modules.CsvFormatModule;

import javax.inject.Singleton;

/**
 * Created by vijay on 12/10/15.
 */
@Singleton
@Component(modules = {CsvFormatModule.class})
public interface CsvFormatComponent {

    CsvFormat provideCsvFormat();
}
