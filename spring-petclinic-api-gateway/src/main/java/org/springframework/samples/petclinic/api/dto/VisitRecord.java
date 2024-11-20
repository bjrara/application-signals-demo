package org.springframework.samples.petclinic.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VisitRecord {
    private String visitId;
    private String petId;
    private Clinic clinic;
    private VisitDetails visitDetails;

    @Getter
    @Setter
    public static class Clinic {
        private String clinicId;
        private String name;
        private String phone;
        private Address address;

        @Getter
        @Setter
        public static class Address {
            private String street;
            private String city;
            private String state;
            private String zipCode;
        }
    }

    @Getter
    @Setter
    public static class VisitDetails {
        private String date;
        private String time;
        private String reason;
        private List<String> notes;
        private Vet vet;
        private Charges charges;

        @Getter
        @Setter
        public static class Vet {
            private String vetId;
            private String name;
        }

        @Getter
        @Setter
        public static class Charges {
            private double consultationFee;
            private double vaccinationCost;
            private double totalCost;
            private String currency;
        }
    }
}
