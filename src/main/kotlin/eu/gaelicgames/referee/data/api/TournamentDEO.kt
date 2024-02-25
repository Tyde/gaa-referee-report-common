package eu.gaelicgames.referee.data.api

import eu.gaelicgames.referee.data.*
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate


@Serializable
data class TournamentDEO(
    val id: Long,
    val name: String,
    val location: String,
    @Serializable(with = LocalDateSerializer::class) val date: LocalDate,
    val region: Long
)

@Serializable
data class NewTournamentDEO(
    val name: String,
    val location: String,
    @Serializable(with = LocalDateSerializer::class) val date: LocalDate,
    val region: Long
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


