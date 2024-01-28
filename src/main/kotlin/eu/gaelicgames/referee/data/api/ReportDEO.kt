package eu.gaelicgames.referee.data.api

import eu.gaelicgames.referee.data.*
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime
import java.util.*

@Serializable
data class CompleteReportDEO(
    val id: Long,
    val tournament: TournamentDEO,
    val code: Long,
    val additionalInformation: String,
    val isSubmitted: Boolean,
    @Serializable(with = LocalDateTimeSerializer::class) val submitDate: LocalDateTime?,
    val selectedTeams: List<TeamDEO>,
    val gameReports: List<CompleteGameReportDEO>,
    val pitches: List<PitchDEO>,
    val referee: RefereeDEO,
)
@Serializable
data class TournamentReportByIdDEO(
    val id:Long
)
@Serializable
data class TournamentReportShareLinkDEO(
    val id:Long,
    val uuid: String
)

@Serializable
data class UpdateReportAdditionalInformationDEO(
    val id: Long,
    val additionalInformation: String
)
@Serializable
data class NewTournamentReportDEO(
    val id: Long? = null,
    val tournament: Long,
    val selectedTeams: List<Long>,
    val gameCode: Long
)
@Serializable
data class TournamentReportDEO(
    val id: Long? = null,
    val tournament: Long? = null,
    val code: Long? = null,
    val additionalInformation: String? = null,
    val isSubmitted: Boolean? = null,
    @Serializable(with = LocalDateTimeSerializer::class) val submitDate: LocalDateTime? = null,
)
@Serializable
data class CompactTournamentReportDEO(
    val id:Long,
    val tournament: Long,
    val code: Long,
    val isSubmitted: Boolean,
    @Serializable(with = LocalDateTimeSerializer::class) val submitDate: LocalDateTime? = null,
    val refereeId: Long,
    val refereeName: String,
    val numGameReports: Long,
    val numTeams: Long,
    val additionalInformation: String
)
@Serializable
data class DeleteTournamentReportDEO(
    val id: Long
)
