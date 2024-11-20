package org.springframework.samples.petclinic.visits.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class VisitRecordRepository {
    public List<VisitRecord> fetchRecords(int petId, int limit) {
        List<VisitRecord> records = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            try (InputStream inputStream = VisitRecordRepository.class.getClassLoader().getResourceAsStream("reports/visit_record.json")) {
                if (inputStream == null) {
                    throw new IllegalArgumentException("File not found: visit_record.json");
                }


                ObjectMapper objectMapper = new ObjectMapper();
                VisitRecord record = objectMapper.readValue(inputStream, VisitRecord.class);
                record.setVisitId(limit - i + "");
                record.setPetId(petId + "");

                records.add(record);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        return records;
    }
}
