package com.netki.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

/**
 * List of types of attestations supported.
 */
enum class Attestation(id: Int) {

    @JsonProperty("legalPersonPrimaryIdentifier")
    @SerializedName("legalPersonPrimaryIdentifier")
    LEGAL_PERSON_PRIMARY_NAME(0),

    @JsonProperty("legalPersonSecondaryIdentifier")
    @SerializedName("legalPersonSecondaryIdentifier")
    LEGAL_PERSON_SECONDARY_NAME(1),

    @JsonProperty("addressDepartment")
    @SerializedName("addressDepartment")
    ADDRESS_DEPARTMENT(2),

    @JsonProperty("addressSubDepartment")
    @SerializedName("addressSubDepartment")
    ADDRESS_SUB_DEPARTMENT(3),

    @JsonProperty("addressStreetName")
    @SerializedName("addressStreetName")
    ADDRESS_STREET_NAME(4),

    @JsonProperty("addressBuildingNumber")
    @SerializedName("addressBuildingNumber")
    ADDRESS_BUILDING_NUMBER(5),

    @JsonProperty("addressBuildingName")
    @SerializedName("addressBuildingName")
    ADDRESS_BUILDING_NAME(6),

    @JsonProperty("addressFloor")
    @SerializedName("addressFloor")
    ADDRESS_FLOOR(7),

    @JsonProperty("addressPostbox")
    @SerializedName("addressPostbox")
    ADDRESS_POSTBOX(8),

    @JsonProperty("addressRoom")
    @SerializedName("addressRoom")
    ADDRESS_ROOM(9),

    @JsonProperty("addressPostcode")
    @SerializedName("addressPostcode")
    ADDRESS_POSTCODE(10),

    @JsonProperty("addressTownName")
    @SerializedName("addressTownName")
    ADDRESS_TOWN_NAME(11),

    @JsonProperty("addressTownLocationName")
    @SerializedName("addressTownLocationName")
    ADDRESS_TOWN_LOCATION_NAME(12),

    @JsonProperty("addressDistrictName")
    @SerializedName("addressDistrictName")
    ADDRESS_DISTRICT_NAME(13),

    @JsonProperty("addressCountrySubDivision")
    @SerializedName("addressCountrySubDivision")
    ADDRESS_COUNTRY_SUB_DIVISION(14),

    @JsonProperty("addressAddressLine")
    @SerializedName("addressAddressLine")
    ADDRESS_ADDRESS_LINE(15),

    @JsonProperty("addressCountry")
    @SerializedName("addressCountry")
    ADDRESS_COUNTRY(16),

    @JsonProperty("naturalPersonFirstName")
    @SerializedName("naturalPersonFirstName")
    NATURAL_PERSON_FIRST_NAME(17),

    @JsonProperty("naturalPersonLastName")
    @SerializedName("naturalPersonLastName")
    NATURAL_PERSON_LAST_NAME(18),

    @JsonProperty("beneficiaryPersonFirstName")
    @SerializedName("beneficiaryPersonFirstName")
    BENEFICIARY_PERSON_FIRST_NAME(19),

    @JsonProperty("beneficiaryPersonLastName")
    @SerializedName("beneficiaryPersonLastName")
    BENEFICIARY_PERSON_LAST_NAME(20),

    @JsonProperty("birthDate")
    @SerializedName("birthDate")
    BIRTH_DATE(21),

    @JsonProperty("birthPlace")
    @SerializedName("birthPlace")
    BIRTH_PLACE(22),

    @JsonProperty("countryOfResidence")
    @SerializedName("countryOfResidence")
    COUNTRY_OF_RESIDENCE(23),

    @JsonProperty("issuingCountry")
    @SerializedName("issuingCountry")
    ISSUING_COUNTRY(24),

    @JsonProperty("nationalIdentifierNumber")
    @SerializedName("nationalIdentifierNumber")
    NATIONAL_IDENTIFIER_NUMBER(25),

    @JsonProperty("nationalIdentifier")
    @SerializedName("nationalIdentifier")
    NATIONAL_IDENTIFIER(26),

    @JsonProperty("accountNumber")
    @SerializedName("accountNumber")
    ACCOUNT_NUMBER(27),

    @JsonProperty("customerIdentification")
    @SerializedName("customerIdentification")
    CUSTOMER_IDENTIFICATION(28),

    @JsonProperty("registrationAuthority")
    @SerializedName("registrationAuthority")
    REGISTRATION_AUTHORITY(29)
}

/**
 * List of IVMS Constraints.
 */
enum class IvmsConstraints() {
    GEOG,
    BIZZ,
    HOME,
    ALIA,
    BIRT,
    MAID,
    LEGL,
    MISC,
    ARNU,
    CCPT,
    RAID,
    DRLC,
    FIIN,
    TXID,
    SOCS,
    IDCD,
    LEIX
}
