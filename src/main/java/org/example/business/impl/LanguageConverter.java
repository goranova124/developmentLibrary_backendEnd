package org.example.business.impl;

import org.example.domain.Language;
import org.example.persistence.entity.LanguageEntity;

public class LanguageConverter {
    public static Language convert (LanguageEntity languageEntity){
        return Language.builder().
                language(languageEntity.getLanguage())
                .example(languageEntity.getExample()).build();
    }
}
