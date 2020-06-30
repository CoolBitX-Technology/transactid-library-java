package com.netki.model

/**
 * Representation of InvoiceRequest message.
 */
data class InvoiceRequest(
    /**
     * Integer-number-of-satoshis.
     */
    val amount: Long? = 0,

    /**
     * Human-readable description of invoice request for the receiver.
     */
    val memo: String? = null,

    /**
     * Secure (usually TLS-protected HTTP) location where an EncryptedProtocolMessage SHOULD be sent when ready.
     */
    val notificationUrl: String? = null,

    /**
     * Account owners.
     */
    val owners: List<Owner> = emptyList(),

    /**
     * List of attestations requested
     */
    val attestationsRequested: List<Attestation> = emptyList(),

    /**
     * Type of sender's pki data.
     */
    val senderPkiType: PkiType? = PkiType.NONE,

    /**
     * Sender's pki data, depends on senderPkiType.
     */
    val senderPkiData: String? = null,

    /**
     * Sender's Signature of the whole message.
     */
    val senderSignature: String? = null
)
