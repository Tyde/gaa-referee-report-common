package eu.gaelicgames.referee.data

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


object LocalDateSerializer : KSerializer<LocalDate> {
    override fun deserialize(decoder: Decoder): LocalDate {
        return LocalDate.parse(decoder.decodeString())
    }

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("LocalDate", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDate) {
        encoder.encodeString(DateTimeFormatter.ISO_DATE.format(value))
    }

}

object LocalDateTimeSerializer : KSerializer<LocalDateTime> {
    override fun deserialize(decoder: Decoder): LocalDateTime {
        val string = decoder.decodeString()
        val dt = kotlin
            .runCatching {
                // Parse with offset as it is coming this way from TS
                LocalDateTime.from(
                    DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(string)
                )
            }
            .recover {
                // Parse without offset as it is coming this way from Kotlin (see Cache)
                LocalDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse(string))
            }
        return dt.getOrThrow()
    }

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("LocalDateTime", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        encoder.encodeString(DateTimeFormatter.ISO_DATE_TIME.format(value))
    }

}

object LocalDateTimeCacheSerializer : KSerializer<LocalDateTime> {
    override fun deserialize(decoder: Decoder): LocalDateTime {
        return LocalDateTime.from(DateTimeFormatter.ISO_DATE_TIME.parse(decoder.decodeString()))
    }

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("LocalDateTime", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: LocalDateTime) {
        encoder.encodeString(DateTimeFormatter.ISO_DATE_TIME.format(value))
    }

}

@Serializable
data class GameCodeDEO(
    val name: String, val id: Long
)


@Serializable
enum class ApiErrorOptions {
    @SerialName("insertionFailed")
    INSERTION_FAILED,

    @SerialName("deleteFailed")
    DELETE_FAILED,

    @SerialName("notFound")
    NOT_FOUND,

    @SerialName("notAuthorized")
    NOT_AUTHORIZED,

    @SerialName("illegalArgument")
    ILLEGAL_ARGUMENT
}

@Serializable
data class ApiError(
    val error: ApiErrorOptions, val message: String
)


