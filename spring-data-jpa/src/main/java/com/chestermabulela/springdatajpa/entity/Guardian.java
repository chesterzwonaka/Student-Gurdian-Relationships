package com.chestermabulela.springdatajpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")),
        @AttributeOverride(
                name = "address",  // corrected the attribute name from "adress" to "address"
                column = @Column(name = "guardian_address")),  // corrected the column name from "guardian_adress" to "guardian_address"
        @AttributeOverride(
                name = "mobileNo",
                column = @Column(name = "guardian_mobile_no")
        )
})
@Builder
public class Guardian {
    private String name;
    private String address;
    private String mobileNo;
}
