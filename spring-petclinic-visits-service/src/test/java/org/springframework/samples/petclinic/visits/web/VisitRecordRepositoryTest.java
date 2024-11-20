package org.springframework.samples.petclinic.visits.web;

import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visits.model.VisitRecord;
import org.springframework.samples.petclinic.visits.model.VisitRecordRepository;

import java.util.List;

public class VisitRecordRepositoryTest {
    @Test
    public void testParse() {
        VisitRecordRepository repo = new VisitRecordRepository();
        List<VisitRecord> records = repo.fetchRecords(1, 10);
        assert records.size() == 10;
    }
}
