package eu.gaelicgames.referee.data.api

import eu.gaelicgames.referee.data.LocalDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class TeamGameDEO(
    val gameId: Long,
    val reportId: Long,
    val tournament: TournamentDEO,
    @Serializable(with = LocalDateTimeSerializer::class)
    val startTime: LocalDateTime?,
    val playedAsTeam: TeamDEO,
    val opponentTeam: TeamDEO,
    val playedAsGoals: Int,
    val playedAsPoints: Int,
    val opponentGoals: Int,
    val opponentPoints: Int,
    val refereeId: Long,
    val refereeName: String,
    val codeId: Long,
    val codeName: String,
    val gameTypeId: Long?,
    val gameTypeName: String?
)
