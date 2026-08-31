package eu.gaelicgames.referee.data.api

import kotlinx.serialization.Serializable

@Serializable
data class RuleDEO(
    val id: Long,
    val code: Long,
    val isCaution: Boolean,
    val isBlack: Boolean,
    val isRed: Boolean,
    val description: String,
    val isDisabled: Boolean,
    val descriptionFr: String? = null,
    val descriptionDe: String? = null,
    val descriptionEs: String? = null,
    val ruleNumber: String? = null,
    val ruleNumberSortKey: String? = null,
    val superseeds: Long? = null,
    val isLatest: Boolean = true,
    val createdAt: String? = null,
    val createdBy: Long? = null,
    val lineageRootId: Long? = null
) {
}

@Serializable
data class RuleHistoryDEO(
    val lineageRootId: Long,
    val versions: List<RuleDEO>
)

@Serializable
data class NewRuleVersionDEO(
    val parentId: Long,
    val code: Long,
    val isCaution: Boolean,
    val isBlack: Boolean,
    val isRed: Boolean,
    val description: String,
    val isDisabled: Boolean,
    val ruleNumber: String? = null,
    val descriptionFr: String? = null,
    val descriptionDe: String? = null,
    val descriptionEs: String? = null
)

@Serializable
data class RuleTranslation(
    val ruleEn: String,
    val ruleFr: String,
    val ruleDe: String,
    val ruleEs: String
)
@Serializable
data class ModifyRulesDEOState(
    val id: Long,
)
@Serializable
data class RuleIsDeletableDEO(
    val id: Long,
    val isDeletable: Boolean
)

@Serializable
data class NewRuleDEO(
    val code: Long,
    val isCaution: Boolean,
    val isBlack: Boolean,
    val isRed: Boolean,
    val description: String,
    val isDisabled: Boolean,
    val ruleNumber: String? = null,
    val descriptionFr: String? = null,
    val descriptionDe: String? = null,
    val descriptionEs: String? = null
)

@Serializable
data class RuleTranslationRequestDEO(
    val description: String
)
