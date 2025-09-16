package eu.gaelicgames.referee.data.api

import eu.gaelicgames.referee.data.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.sql.transactions.transaction

@Serializable
data class PitchPropertyDEO(
    val id: Long,
    val name: String,
    val disabled: Boolean
)


@Serializable
data class PitchVariablesDEO(
    val surfaces: List<PitchPropertyDEO>,
    val widths: List<PitchPropertyDEO>,
    val lengths: List<PitchPropertyDEO>,
    val markingsOptions: List<PitchPropertyDEO>,
    val goalPosts: List<PitchPropertyDEO>,
    val goalDimensions: List<PitchPropertyDEO>,
)

//PitchPropertyType Enum
enum class PitchPropertyType(val id: Long) {
    SURFACE(0),
    LENGTH(1),
    WIDTH(2),
    MARKINGS(3),
    GOALPOSTS(4),
    GOALDIMENSIONS(5);

    companion object {
        private val map = values().associateBy(PitchPropertyType::id)
        fun fromLong(longValue: Long): PitchPropertyType? {
            return map[longValue]
        }
    }

}

//PitchPropertyType serializer by id
@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = PitchPropertyType::class)
object PitchPropertyTypeSerializer : KSerializer<PitchPropertyType> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("PitchPropertyType", PrimitiveKind.LONG)

    override fun deserialize(decoder: Decoder): PitchPropertyType {
        val id = decoder.decodeLong()
        return PitchPropertyType.fromLong(id) ?: throw IllegalArgumentException("Unknown PitchPropertyType id: $id")
    }

    override fun serialize(encoder: Encoder, value: PitchPropertyType) {
        encoder.encodeLong(value.id)
    }
}

@Serializable
data class PitchVariableUpdateDEO(
    val id: Long,
    val name: String,
    @Serializable(with = PitchPropertyTypeSerializer::class) val type: PitchPropertyType,
    val disabled: Boolean? = false
)

@Serializable
enum class DeletionState {
    DELETED,
    DISABLED,
    FAILED
}
@Serializable
data class DeletePitchVariableResultDEO(
    val id: Long,
    val deletionState : DeletionState
)

@Serializable
data class NewPitchVariableDEO(
    val name: String,
    @Serializable(with = PitchPropertyTypeSerializer::class) val type: PitchPropertyType
)


@Serializable
data class PitchReportDEO(
    val id: Long? = null,
    val name: String,
    val report: Long,
    val surface: Long? = null,
    val width: Long? = null,
    val length: Long? = null,
    val smallSquareMarkings: Long? = null,
    val penaltySquareMarkings: Long? = null,
    val thirteenMeterMarkings: Long? = null,
    val twentyMeterMarkings: Long? = null,
    val longMeterMarkings: Long? = null,
    val goalPosts: Long? = null,
    val goalDimensions: Long? = null,
    val additionalInformation: String? = null,
)
@Serializable
data class DeletePitchReportDEO(
    val id: Long
)
@Serializable
data class PitchDEO(
    val id: Long?,
    val report: Long?,
    val name: String,
    val surface: Long? = null,
    val length: Long? = null,
    val width: Long? = null,
    val smallSquareMarkings: Long? = null,
    val penaltySquareMarkings: Long? = null,
    val thirteenMeterMarkings: Long? = null,
    val twentyMeterMarkings: Long? = null,
    val longMeterMarkings: Long? = null,
    val goalPosts: Long? = null,
    val goalDimensions: Long? = null,
    val additionalInformation: String
)
