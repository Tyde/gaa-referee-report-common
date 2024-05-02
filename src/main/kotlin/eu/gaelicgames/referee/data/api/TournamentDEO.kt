package eu.gaelicgames.referee.data.api

import eu.gaelicgames.referee.data.LocalDateSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDate


@Serializable
data class TournamentDEO(
    val id: Long,
    val name: String,
    val location: String,
    @Serializable(with = LocalDateSerializer::class) val date: LocalDate,
    val region: Long,
    val isLeague: Boolean? = null,
    @Serializable(with = LocalDateSerializer::class) val endDate: LocalDate? = null
)

@Serializable
data class NewTournamentDEO(
    val name: String,
    val location: String,
    @Serializable(with = LocalDateSerializer::class) val date: LocalDate,
    val region: Long,
    val isLeague: Boolean? = null,
    @Serializable(with = LocalDateSerializer::class) val endDate: LocalDate? = null
)

@Serializable
data class RegionDEO(
    val id: Long,
    val name: String
)
@Serializable
data class PublicTournamentReportDEO(
    val tournament: TournamentDEO,
    val games: List<PublicGameReportDEO>,
    val teams: List<TeamDEO>
)
@Serializable
data class CompleteTournamentReportDEO(
    val tournament: TournamentDEO,
    val games: List<CompleteGameReportWithRefereeReportDEO>,
    val teams: List<TeamDEO>,
    val pitches: List<PitchDEO>
)


@Serializable
data class DeleteCompleteTournamentDEO(
    val id:Long
)


@Serializable
data class MergeTournamentDEO(
    val mergeFromId: Long,
    val mergeToId: Long
)


