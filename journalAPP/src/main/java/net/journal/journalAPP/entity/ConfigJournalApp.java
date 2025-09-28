package net.journal.journalAPP.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "config_journal_app")
@Data // this creates getters , setters etc for every variable
@NoArgsConstructor
public class ConfigJournalApp {

    private String key;
    private String value;

}
