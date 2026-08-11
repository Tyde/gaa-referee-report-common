package eu.gaelicgames.referee.data.api

import eu.gaelicgames.referee.data.*
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate
import java.time.LocalDateTime


@Serializable
data class TeamDEO(
    val name: String, val id: Long, val isAmalgamation: Boolean, val amalgamationTeams: List<TeamDEO>?,
    @Serializable(with = LocalDateSerializer::class) val changeDate: LocalDate? = null
)
@Serializable
data class NewTeamDEO(
    val name: String,
    @Serializable(with = LocalDateSerializer::class) val changeDate: LocalDate? = null
)

@Serializable
data class NewAmalgamationDEO(
    val name: String, val teams: List<TeamDEO>,
    @Serializable(with = LocalDateSerializer::class) val changeDate: LocalDate? = null
)

@Serializable
data class MergeTeamsDEO(
    val baseTeam: Long, val teamsToMerge: List<Long>,
    @Serializable(with = LocalDateSerializer::class) val changeDate: LocalDate? = null
)

@Serializable
data class TeamAliasDEO(val id: Long, val teamId: Long, val alias: String)

@Serializable
data class NewTeamAliasDEO(val teamId: Long, val alias: String)

@Serializable
data class UpdateTeamAliasDEO(val id: Long, val alias: String)

@Serializable
data class DeleteTeamAliasDEO(val id: Long)

@Serializable
data class TeamHistoryEventDEO(
    val changeType: String,
    @Serializable(with = LocalDateSerializer::class) val changeDate: LocalDate,
    val oldValue: String? = null,
    val newValue: String? = null,
    @Serializable(with = LocalDateTimeSerializer::class) val recordedAt: LocalDateTime
)
