package com.netki.keymanagement.util

import com.netki.exceptions.CertificateProviderException
import com.netki.model.Attestation
import com.netki.model.IvmsConstraints
import com.netki.util.ErrorInformation.CERTIFICATE_INFORMATION_NOT_CORRECT_ERROR_PROVIDER

private const val DATA_LIMIT_LENGTH = 64
private const val PRINCIPAL_STRING = "CN=%s, C=%s, L=%s, O=%s, OU=%s, ST=%s"
internal fun Attestation.toPrincipal(data: String, ivmsConstraints: IvmsConstraints? = null): String {

    var data64Characters = ""
    var extraData = ""

    if (data.length > DATA_LIMIT_LENGTH) {
        data64Characters = data.substring(0, DATA_LIMIT_LENGTH)
        extraData = data.substring(DATA_LIMIT_LENGTH, data.length)
    } else {
        data64Characters = data
    }

    val ivmConstraintValue = ivmsConstraints ?: ""

    if (!this.validateConstraint(ivmsConstraints)) {
        throw CertificateProviderException(
            String.format(
                CERTIFICATE_INFORMATION_NOT_CORRECT_ERROR_PROVIDER,
                ivmConstraintValue,
                this
            )
        )
    }

    return when (this) {
        Attestation.LEGAL_PERSON_PRIMARY_NAME -> String.format(
            PRINCIPAL_STRING,
            "legalPersonName.primaryIdentifier",
            extraData,
            "legalPersonNameType",
            "legalPrimaryName",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.LEGAL_PERSON_SECONDARY_NAME -> String.format(
            PRINCIPAL_STRING,
            "legalPersonName.secondaryIdentifier",
            extraData,
            "legalPersonNameType",
            "legalSecondaryName",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_DEPARTMENT -> String.format(
            PRINCIPAL_STRING,
            "address.department",
            extraData,
            "department",
            "department",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_SUB_DEPARTMENT -> String.format(
            PRINCIPAL_STRING,
            "address.subDepartment",
            extraData,
            "subDepartment",
            "subDepartment",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_STREET_NAME -> String.format(
            PRINCIPAL_STRING,
            "address.streetName",
            extraData,
            "streetName",
            "streetName",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_BUILDING_NUMBER -> String.format(
            PRINCIPAL_STRING,
            "address.buildingNumber",
            extraData,
            "buildingNumber",
            "buildingNumber",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_BUILDING_NAME -> String.format(
            PRINCIPAL_STRING,
            "address.buildingName",
            extraData,
            "buildingName",
            "buildingName",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_FLOOR -> String.format(
            PRINCIPAL_STRING,
            "address.floor",
            extraData,
            "floor",
            "floor",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_POSTBOX -> String.format(
            PRINCIPAL_STRING,
            "address.postBox",
            extraData,
            "postBox",
            "postBox",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_ROOM -> String.format(
            PRINCIPAL_STRING,
            "address.room",
            extraData,
            "room",
            "room",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_POSTCODE -> String.format(
            PRINCIPAL_STRING,
            "address.postCode",
            extraData,
            "postCode",
            "postCode",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_TOWN_NAME -> String.format(
            PRINCIPAL_STRING,
            "address.townName",
            extraData,
            "townName",
            "townName",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_TOWN_LOCATION_NAME -> String.format(
            PRINCIPAL_STRING,
            "address.townLocationName",
            extraData,
            "townLocationName",
            "townLocationName",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_DISTRICT_NAME -> String.format(
            PRINCIPAL_STRING,
            "address.districtName",
            extraData,
            "districtName",
            "districtName",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_COUNTRY_SUB_DIVISION -> String.format(
            PRINCIPAL_STRING,
            "address.countrySubDivision",
            extraData,
            "countrySubDivision",
            "countrySubDivision",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_ADDRESS_LINE -> String.format(
            PRINCIPAL_STRING,
            "address.addressLine",
            extraData,
            "addressLine",
            "addressLine",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ADDRESS_COUNTRY -> String.format(
            PRINCIPAL_STRING,
            "address.country",
            extraData,
            "country",
            "country",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.NATURAL_PERSON_FIRST_NAME -> String.format(
            PRINCIPAL_STRING,
            "naturalName.secondaryIdentifier",
            extraData,
            "naturalPersonNameType",
            "naturalPersonFirstName",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.NATURAL_PERSON_LAST_NAME -> String.format(
            PRINCIPAL_STRING,
            "naturalName.primaryIdentifier",
            extraData,
            "naturalPersonNameType",
            "naturalPersonLastName",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.BENEFICIARY_PERSON_FIRST_NAME -> String.format(
            PRINCIPAL_STRING,
            "beneficiaryName.secondaryIdentifier",
            extraData,
            "beneficiaryPersonNameType",
            "beneficiaryPersonFirstName",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.BENEFICIARY_PERSON_LAST_NAME -> String.format(
            PRINCIPAL_STRING,
            "beneficiaryName.primaryIdentifier",
            extraData,
            "beneficiaryPersonNameType",
            "beneficiaryPersonLastName",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.BIRTH_DATE -> String.format(
            PRINCIPAL_STRING,
            "naturalPerson.dateOfBirth",
            extraData,
            "dateInPast",
            "birthdate",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.BIRTH_PLACE -> String.format(
            PRINCIPAL_STRING,
            "naturalPerson.placeOfBirth",
            extraData,
            "countryCode",
            "country",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.COUNTRY_OF_RESIDENCE -> String.format(
            PRINCIPAL_STRING,
            "naturalPerson.countryOfResidence",
            extraData,
            "countryCode",
            "country",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ISSUING_COUNTRY -> String.format(
            PRINCIPAL_STRING,
            "nationalIdentifier.countryOfIssue",
            extraData,
            "nationalIdentifierType",
            "nationalIdentifier",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.NATIONAL_IDENTIFIER_NUMBER -> String.format(
            PRINCIPAL_STRING,
            "nationalIdentifier.number",
            extraData,
            "number",
            "documentNumber",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.NATIONAL_IDENTIFIER -> String.format(
            PRINCIPAL_STRING,
            "nationalIdentifier.documentType",
            extraData,
            "nationalIdentifierType",
            "documentType",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.ACCOUNT_NUMBER -> String.format(
            PRINCIPAL_STRING,
            "accountNumber",
            extraData,
            "accountNumber",
            "accountNumber",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.CUSTOMER_IDENTIFICATION -> String.format(
            PRINCIPAL_STRING,
            "customerIdentification",
            extraData,
            "customerIdentification",
            "customerIdentification",
            data64Characters,
            ivmConstraintValue
        )
        Attestation.REGISTRATION_AUTHORITY -> String.format(
            PRINCIPAL_STRING,
            "registrationAuthority",
            extraData,
            "registrationAuthority",
            "registrationAuthority",
            data64Characters,
            ivmConstraintValue
        )
    }
}

internal fun Attestation.validateConstraint(ivmsConstraints: IvmsConstraints?) = when (this) {
    Attestation.LEGAL_PERSON_PRIMARY_NAME,
    Attestation.LEGAL_PERSON_SECONDARY_NAME,
    Attestation.NATURAL_PERSON_FIRST_NAME,
    Attestation.NATURAL_PERSON_LAST_NAME,
    Attestation.BENEFICIARY_PERSON_FIRST_NAME,
    Attestation.BENEFICIARY_PERSON_LAST_NAME -> ivmsConstraints == IvmsConstraints.ALIA ||
            ivmsConstraints == IvmsConstraints.BIRT ||
            ivmsConstraints == IvmsConstraints.MAID ||
            ivmsConstraints == IvmsConstraints.LEGL ||
            ivmsConstraints == IvmsConstraints.MISC
    Attestation.ADDRESS_DEPARTMENT,
    Attestation.ADDRESS_SUB_DEPARTMENT,
    Attestation.ADDRESS_STREET_NAME,
    Attestation.ADDRESS_BUILDING_NUMBER,
    Attestation.ADDRESS_BUILDING_NAME,
    Attestation.ADDRESS_FLOOR,
    Attestation.ADDRESS_POSTBOX,
    Attestation.ADDRESS_ROOM,
    Attestation.ADDRESS_POSTCODE,
    Attestation.ADDRESS_TOWN_NAME,
    Attestation.ADDRESS_TOWN_LOCATION_NAME,
    Attestation.ADDRESS_DISTRICT_NAME,
    Attestation.ADDRESS_COUNTRY_SUB_DIVISION,
    Attestation.ADDRESS_ADDRESS_LINE,
    Attestation.ADDRESS_COUNTRY -> ivmsConstraints == IvmsConstraints.GEOG ||
            ivmsConstraints == IvmsConstraints.BIZZ ||
            ivmsConstraints == IvmsConstraints.HOME
    Attestation.NATIONAL_IDENTIFIER -> ivmsConstraints == IvmsConstraints.ARNU ||
            ivmsConstraints == IvmsConstraints.CCPT ||
            ivmsConstraints == IvmsConstraints.RAID ||
            ivmsConstraints == IvmsConstraints.DRLC ||
            ivmsConstraints == IvmsConstraints.FIIN ||
            ivmsConstraints == IvmsConstraints.TXID ||
            ivmsConstraints == IvmsConstraints.SOCS ||
            ivmsConstraints == IvmsConstraints.IDCD ||
            ivmsConstraints == IvmsConstraints.LEIX ||
            ivmsConstraints == IvmsConstraints.MISC
    else -> ivmsConstraints == null
}
